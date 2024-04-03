package org.example.ejercicio2;

public abstract class Tarjeta {
    protected double descuento;
    protected String nombre;
    protected float credito;

    public Tarjeta(String nombre, double descuento) {
        this.nombre = nombre;
        this.descuento = descuento;
        this.credito = 10000F;

    }

    public void pagar(Pedido unPedido) {

    }

    public float verSaldo() {
        return this.credito;
    }

    public boolean hayDineroDisponible(double monto) {
        if (this.credito < monto) {
            throw new RuntimeException("NO HAY PLATA");
        }
        return true;
    }

    public void descontarImporte(double monto) {
        this.credito -= (float) monto;
    }

}
