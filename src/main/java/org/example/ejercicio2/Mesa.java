package org.example.ejercicio2;

public class Mesa {
    private Integer numero;
    private Integer lugares;
    private Boolean reservado;
    private Pedido pedido;

    public Mesa(Integer numero, Integer cantidadLugares) {
        this.numero = numero;
        this.lugares = cantidadLugares;
        this.reservado = false;
        this.pedido = new Pedido();
    }

    public void reservarMesa(int cantidadLugaresAreservar) {
        if (this.lugares >= cantidadLugaresAreservar) {
            this.lugares -= cantidadLugaresAreservar;
            this.reservado = true;
        }

    }

    public void desocuparMesa() {
        this.reservado = false;
    }

    public void asignarPedido(Pedido unPedido) {
        this.pedido = unPedido;
    }


    public boolean estaReservada() {
        return this.reservado;
    }

    public Pedido cobrar() {

        return pedido;
    }

}
