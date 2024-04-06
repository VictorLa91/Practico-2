package org.example.ejercicio1;

import org.example.ejercicio3.PersistirDatos;

public class FakeRegistroIncripcion implements PersistirDatos {
    private  String registro;
    @Override
    public void guardarRegistro(String registro) {
        this.registro=registro;
    }


    public boolean empiezaCon(String frase) {
        return this.registro.startsWith(frase);
    }
}
