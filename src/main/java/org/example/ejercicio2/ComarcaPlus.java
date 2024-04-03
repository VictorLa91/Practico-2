package org.example.ejercicio2;

public class ComarcaPlus extends Tarjeta {


    public ComarcaPlus() {
        super("ComarcaPlus", 0.02);

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
