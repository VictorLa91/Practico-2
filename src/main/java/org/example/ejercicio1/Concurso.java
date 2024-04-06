package org.example.ejercicio1;

import org.example.ejercicio3.PersistirDatos;
import org.example.ejercicio4.Comunicacion;
import org.example.ejercicio5.ProvedorDeFecha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Concurso {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaCierre;
    private int ID;
    private ArrayList<Participante> inscriptos;
    private Comunicacion comunicador;
    private  PersistirDatos persistir;
    private ProvedorDeFecha provedor;

    public Concurso(LocalDateTime inicio, LocalDateTime fin,
                    int ID, Comunicacion comunicador,
                    PersistirDatos persitencia,
                    ProvedorDeFecha proveedor) {
        this.fechaCierre = fin;
        this.fechaInicio = inicio;
        this.ID = ID;
        this.inscriptos = new ArrayList<Participante>();
        this.comunicador=comunicador;
        this.persistir=persitencia;
        this.provedor=proveedor;

    }

    public void InscribirParticipante(Participante unParticipante, LocalDateTime fechaInscripcion) {
        if (estaLaIncripcionEnTermino(fechaInscripcion)) {
            if (!estaInscripto(unParticipante)) {
                this.inscriptos.add(unParticipante);
                ganaPuntosExtras(unParticipante, fechaInscripcion);
                String data= fechaInscripcion.toString() + "||"+ unParticipante.getId() + "||" + this.ID + "\n" ;
                this.persistir.guardarRegistro(data);
                this.comunicador.enviarMail();
            }
        }
    }

    public boolean estaLaIncripcionEnTermino(LocalDateTime fechaInscripcion) {
        if (!fechaInscripcion.isBefore(this.fechaCierre)) {
            throw new RuntimeException("La inscripcion ha terminado");
        }
        return true;
    }

    public void ganaPuntosExtras(Participante unParticipante, LocalDateTime fechaInscripcion) {
        if (fechaInscripcion.isEqual(this.fechaInicio) || fechaInscripcion.isAfter(this.fechaInicio)) {
            unParticipante.SumarPuntaje(10);
        }
    }

    public boolean estaInscripto(Participante unParticipante) {
        if (this.inscriptos.contains(unParticipante)) {
            throw new RuntimeException("Ya esta inscripto");
        }
        return false;
    }

    public String mostrarParticipantes() {
        StringBuilder sb = new StringBuilder();
        for (Participante participante : inscriptos) {
            sb.append(participante.getDatos()).append("\n");
        }
        return sb.toString();
    }

    public  int getID(){
        return  this.ID;
    }

}
