package org.example.ejercicio2;

public class TarjetaComun extends Tarjeta {
    public TarjetaComun() {
        super("Visa", 0.00);
    }

    @Override
    public void pagar(Pedido unPedido) {
        double costoAPagar = unPedido.aplicarDescuentoSobreTotal(this.descuento);
        if (hayDineroDisponible(costoAPagar)) {
            descontarImporte(costoAPagar);
        }
    }

    @Override
    public float verSaldo() {
        return super.verSaldo();
    }

}


