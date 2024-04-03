package org.example;

import org.example.ejercicio2.Bebida;
import org.example.ejercicio2.Mesa;
import org.example.ejercicio2.Pedido;
import org.example.ejercicio2.Plato;
import persistencia.DatosEnBase;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var persistenciaEnDatos= new DatosEnBase();

        Mesa mesa2 = new Mesa(2, 8);
        Plato plato3 = new Plato("Asado", 5500,10);
        Bebida bebida1 = new Bebida("Agua saborizada", 1000,11);
        Bebida bebida2 = new Bebida("Gaseosa", 1500,12);

        Pedido pedido1 = new Pedido(1,persistenciaEnDatos);
        pedido1.asignarPlato(plato3);
        pedido1.asignarBebida(bebida1);
        pedido1.asignarBebida(bebida2);
        pedido1.confirmarPedido();
        mesa2.asignarPedido(pedido1);


    }




}