package org.example.ejercicio1;

import org.example.comunicacion.EnviarMail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import persistencia.DatosEnDisco;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


public class TestEjercicio {

    @Test
    public void inscripcionEnTermino() {
        var comunicador= new EnviarMail();
        Participante participante1 = new Participante("Victor",1991);
        Concurso concurso1 = new Concurso(LocalDateTime.now().minusDays(1),
                LocalDateTime.now().plusDays(4), 1,comunicador,
                new DatosEnDisco(),new FakeProvedorFecha() );
        concurso1.InscribirParticipante(participante1, LocalDateTime.now());
        String datos= LocalDate.now().toString()+ ", "+ participante1.getId()+", "+ concurso1.getID();

        assertThrows(RuntimeException.class, () -> {
            concurso1.estaInscripto(participante1);

        });

    }

    @Test
    public void incripcionFueraDeTermino() {
        var comunicador= new EnviarMail();
        Participante participante1 = new Participante("Antonio",1991);
        Concurso concurso1 = new Concurso(LocalDateTime.now().minusDays(1),
                LocalDateTime.now().plusDays(4), 2,comunicador,
                new DatosEnDisco(),new FakeProvedorFecha());

        assertThrows(RuntimeException.class, () -> {
            concurso1.InscribirParticipante(participante1, LocalDateTime.now().plusDays(6));
            ;
        });
    }

    @Test
    public void participanteRepetido() {
        var comunicador= new EnviarMail();
        Participante participante1 = new Participante("Victor",1991);
        Concurso concurso1 = new Concurso(LocalDateTime.now().minusDays(1),
                LocalDateTime.now().plusDays(4), 3,comunicador,
                new DatosEnDisco(),new FakeProvedorFecha());
        concurso1.InscribirParticipante(participante1, LocalDateTime.now());

        assertThrows(RuntimeException.class, () -> {
            concurso1.estaInscripto(participante1);
        });
    }

    @Test
    public void obtenerCopiaDeDatosDeParticipante() {
        var comunicador= new EnviarMail();
        Participante participante1 = new Participante("Victor",1991);
        Participante participante2 = new Participante("Hugo",1992);
        Participante participante3 = new Participante("Carlos",1993);
        Concurso concurso1 = new Concurso(LocalDateTime.now().minusDays(1),
                LocalDateTime.now().plusDays(4), 5,comunicador,
                new DatosEnDisco(),new FakeProvedorFecha());
        concurso1.InscribirParticipante(participante1, LocalDateTime.now());
        concurso1.InscribirParticipante(participante2, LocalDateTime.now().plusDays(2));

        Concurso concurso2 = new Concurso(LocalDateTime.now().minusDays(1),
                LocalDateTime.now().plusDays(4), 4,comunicador,
                new DatosEnDisco(),new FakeProvedorFecha());
        concurso2.InscribirParticipante(participante1, LocalDateTime.now());
        concurso2.InscribirParticipante(participante2, LocalDateTime.now().plusDays(2));

        assertEquals(concurso1.mostrarParticipantes(), concurso2.mostrarParticipantes());

    }
    @Test
    public void testRegistroFake(){
        var registroFake= new FakeRegistroIncripcion();
        Participante participante1 = new Participante("Victor",1991);
        Concurso concurso1 = new Concurso(LocalDateTime.now().minusDays(1),
                LocalDateTime.now().plusDays(4), 5,new EnviarMail(),
                registroFake,new FakeProvedorFecha());
        String data= new FakeProvedorFecha().fecha() + "||"+ participante1.getId() + "||" + concurso1.getID() + "\n" ;
        concurso1.InscribirParticipante(participante1, new FakeProvedorFecha().fecha());

         var cadena= "2024-04-05T10:25:30||1991||5\n";
         Assert.assertTrue(registroFake.empiezaCon(cadena));

    }
}