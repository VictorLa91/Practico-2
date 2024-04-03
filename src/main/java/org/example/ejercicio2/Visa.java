package org.example.ejercicio2;

public class Visa extends Tarjeta {


    public Visa() {
        super("Visa", 0.03);
    }

    @Override
    public void pagar(Pedido unPedido) {
        double costoAPagar = unPedido.cuantoSalenLosPlatos() +
                unPedido.aplicarDescuentoBebidas(this.descuento);
        if (hayDineroDisponible(costoAPagar)) {
            descontarImporte(costoAPagar);
        }
    }

    @Override
    public float verSaldo() {
        return super.verSaldo();
    }
}
