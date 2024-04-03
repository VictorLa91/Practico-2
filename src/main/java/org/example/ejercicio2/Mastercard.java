package org.example.ejercicio2;

public class Mastercard extends Tarjeta {

    public Mastercard() {
        super("Mastercard", 0.03);
    }

    @Override
    public void pagar(Pedido unPedido) {
        double costoAPagar = unPedido.aplicarDescuentoPlatos(this.descuento)
                + unPedido.cuantoSalenLasBebidas();
        if (hayDineroDisponible(costoAPagar)) {
            descontarImporte(costoAPagar);
        }
    }

    @Override
    public float verSaldo() {
        return super.verSaldo();
    }
}
