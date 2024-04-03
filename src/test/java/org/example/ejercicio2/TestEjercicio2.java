package org.example.ejercicio2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEjercicio2 {

    @Test
    public void testReservaMesa() {
        Mesa mesa = new Mesa(1, 5);
        mesa.reservarMesa(5);

        assertTrue(mesa.estaReservada());
    }

    @Test
    public void testDesocuparMesa() {
        Mesa mesa = new Mesa(1, 5);
        mesa.reservarMesa(5);
        mesa.desocuparMesa();

        assertFalse(mesa.estaReservada());
    }

    @Test
    public void testPagoTarjetaVisa() {
        Plato plato = new Plato("Milanesa", 1500,1);
        Plato plato2 = new Plato("Pure de Papas", 3500,2);
        Bebida bebida3 = new Bebida("Vino", 2500,3);
        Mesa mesa1 = new Mesa(1, 10);


        Pedido pedido1 = new Pedido(1);
        pedido1.asignarPlato(plato);
        pedido1.asignarPlato(plato2);
        pedido1.asignarBebida(bebida3);
        pedido1.confirmarPedido();
        mesa1.asignarPedido(pedido1);
        var visa = new Visa();

        visa.pagar(mesa1.cobrar());
        // Las tarjetas tienen un saldo inicial de 10.000
        // el total de los platos es 5000
        // la bebida sale 2500. menos el 0.03 porciento seria 2425
        // en total los platos y bebidas seria 7425
        // luego hacemos la resta de los 10000 - el total y debiera quedar 2575
        assertEquals(2575, visa.verSaldo());


    }

    @Test
    public void testPagoTarjetaMastercard() {
        Mesa mesa2 = new Mesa(2, 8);
        Plato plato3 = new Plato("Asado", 5500,4);
        Bebida bebida1 = new Bebida("Agua saborizada", 1000,5);
        Bebida bebida2 = new Bebida("Gaseosa", 1500,6);

        Pedido pedido1 = new Pedido(1);
        pedido1.asignarPlato(plato3);
        pedido1.asignarBebida(bebida1);
        pedido1.asignarBebida(bebida2);
        pedido1.confirmarPedido();
        mesa2.asignarPedido(pedido1);

        var master = new Mastercard();
        master.pagar(mesa2.cobrar());
        // Costo plato menos el 3% es 5535
        // costo bebidas es 2500. El total seria 7835
        // restamos los 10000 del credito de la tarjeta y debieran quedar 2165
        assertEquals(2165, master.verSaldo());


    }

    @Test
    public void testPagoTarjetaComarca() {
        Mesa mesa2 = new Mesa(2, 8);
        Plato plato3 = new Plato("Asado", 5500,7);
        Bebida bebida1 = new Bebida("Agua saborizada", 1000,8);
        Bebida bebida2 = new Bebida("Gaseosa", 1500,9);

        Pedido pedido1 = new Pedido(1);
        pedido1.asignarPlato(plato3);
        pedido1.asignarBebida(bebida1);
        pedido1.asignarBebida(bebida2);
        pedido1.confirmarPedido();
        mesa2.asignarPedido(pedido1);

        var comarca = new ComarcaPlus();
        comarca.pagar(mesa2.cobrar());
        // Costo plato mas el costo de bebidas es 8000
        // Le restamos el porcentaje de 2% y quedan 7840
        // restamos los 10000 del credito de la tarjeta y debieran quedar 2160
        assertEquals(2160, comarca.verSaldo());
    }

    @Test
    public void testPagoTarjetaComun() {
        Mesa mesa2 = new Mesa(2, 8);
        Plato plato3 = new Plato("Asado", 5500,10);
        Bebida bebida1 = new Bebida("Agua saborizada", 1000,11);
        Bebida bebida2 = new Bebida("Gaseosa", 1500,12);

        Pedido pedido1 = new Pedido(1);
        pedido1.asignarPlato(plato3);
        pedido1.asignarBebida(bebida1);
        pedido1.asignarBebida(bebida2);
        pedido1.confirmarPedido();
        mesa2.asignarPedido(pedido1);

        var tarjetaComun = new TarjetaComun();
        tarjetaComun.pagar(mesa2.cobrar());
        // Costo plato mas el costo de bebidas es 8000
        // esta tarjeta no tiene descuento asique deberia quedar 2000 de saldo
        assertEquals(2000, tarjetaComun.verSaldo());
    }

    @Test
    public void testRunTimeExeption() {
        Mesa mesa2 = new Mesa(2, 8);
        Plato plato1 = new Plato("Asado", 5500,13);
        Plato plato2 = new Plato("Asado", 5500,14);

        Pedido pedido1 = new Pedido(1);
        pedido1.asignarPlato(plato1);
        pedido1.asignarPlato(plato2);
        pedido1.confirmarPedido();
        mesa2.asignarPedido(pedido1);

        var tarjetaComun = new TarjetaComun();
        // Costo plato mas el costo de bebidas es 8000
        // esta tarjeta no tiene descuento asique deberia quedar 2000 de saldo
        assertThrows(RuntimeException.class, () -> {
            tarjetaComun.pagar(mesa2.cobrar());
        });
    }
}