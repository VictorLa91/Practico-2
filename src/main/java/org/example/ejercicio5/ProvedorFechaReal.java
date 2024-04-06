package org.example.ejercicio5;

import java.time.LocalDateTime;

public class ProvedorFechaReal implements ProvedorDeFecha{
    @Override
    public LocalDateTime fecha() {
        return LocalDateTime.now();
    }
}
