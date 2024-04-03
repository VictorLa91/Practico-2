package org.example.ejercicio1;

import org.junit.jupiter.api.Test;
import persistencia.DatosEnDisco;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestEjercicio {

    @Test
    public void inscripcionEnTermino() {
        Participante participante1 = new Participante("Victor",1991);
        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(4), 1);
        concurso1.InscribirParticipante(participante1, LocalDate.now());
        String datos= LocalDate.now().toString()+ ", "+ participante1.getId()+", "+ concurso1.getID();

        assertThrows(RuntimeException.class, () -> {
            concurso1.estaInscripto(participante1);

        });

        var escrbirDatos = new DatosEnDisco();
        escrbirDatos.enDiscoPersistirDatos(datos);
    }

    @Test
    public void incripcionFueraDeTermino() {
        Participante participante1 = new Participante("Antonio",1991);
        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(4), 2);

        assertThrows(RuntimeException.class, () -> {
            concurso1.InscribirParticipante(participante1, LocalDate.now().plusDays(6));
            ;
        });
    }

    @Test
    public void participanteRepetido() {
        Participante participante1 = new Participante("Victor",1991);
        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(4), 3);
        concurso1.InscribirParticipante(participante1, LocalDate.now());

        assertThrows(RuntimeException.class, () -> {
            concurso1.estaInscripto(participante1);
        });
    }

    @Test
    public void obtenerCopiaDeDatosDeParticipante() {
        Participante participante1 = new Participante("Victor",1991);
        Participante participante2 = new Participante("Hugo",1992);
        Participante participante3 = new Participante("Carlos",1993);
        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(4), 5);
        concurso1.InscribirParticipante(participante1, LocalDate.now());
        concurso1.InscribirParticipante(participante2, LocalDate.now().plusDays(2));

        Concurso concurso2 = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(4), 4);
        concurso2.InscribirParticipante(participante1, LocalDate.now());
        concurso2.InscribirParticipante(participante2, LocalDate.now().plusDays(2));

        assertEquals(concurso1.mostrarParticipantes(), concurso2.mostrarParticipantes());

    }
}