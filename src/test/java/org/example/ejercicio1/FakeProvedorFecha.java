package org.example.ejercicio1;

import org.example.ejercicio5.ProvedorDeFecha;

import java.time.LocalDateTime;

public class FakeProvedorFecha implements ProvedorDeFecha {
    @Override
    public LocalDateTime fecha() {
        return LocalDateTime.of(2024,4,5,10,25,30);
    }
}
