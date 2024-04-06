package org.example.ejercicio1;

public class Participante {
    private String nombre;
    private int ID;
    private Integer puntaje;

    public Participante(String nombre, int ID) {
        this.nombre=nombre;
        this.puntaje = 0;
        this.ID=ID;

    }

    public void SumarPuntaje(Integer puntos) {
        this.puntaje += puntos;
    }

    public String getDatos() {
        StringBuilder copiaDatos = new StringBuilder();
        copiaDatos.append("Nombre:").append(this.nombre).append(" || ")
                .append("Puntaje: ").append(this.puntaje);
        return copiaDatos.toString();
    }
    public  int getId(){
        return  this.ID;
    }

}