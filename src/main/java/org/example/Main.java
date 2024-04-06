package org.example;

import org.example.comunicacion.EnviarMail;
import org.example.ejercicio1.Concurso;
import org.example.ejercicio1.Participante;
import org.example.ejercicio2.Bebida;
import org.example.ejercicio2.Mesa;
import org.example.ejercicio2.Pedido;
import org.example.ejercicio2.Plato;
import org.example.ejercicio5.ProvedorFechaReal;
import org.example.practicaLambda.AprendiendoLambdas;
import persistencia.DatosEnBase;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

      /*  var persistirDatos= new DatosEnBase();
        var comunicador = new EnviarMail();
        var provedorDeFechas= new ProvedorFechaReal();

        Mesa mesa2 = new Mesa(2, 8);
        Plato plato3 = new Plato("Asado", 5500,10);
        Bebida bebida1 = new Bebida("Agua saborizada", 1000,11);
        Bebida bebida2 = new Bebida("Gaseosa", 1500,12);


        Pedido pedido1 = new Pedido(1,persistirDatos);
        pedido1.asignarPlato(plato3);
        pedido1.asignarBebida(bebida1);
        pedido1.asignarBebida(bebida2);
        pedido1.confirmarPedido();
        mesa2.asignarPedido(pedido1);

        var concurso = new Concurso(LocalDateTime.now().minusDays(5),
                LocalDateTime.now().plusDays(10),
                                    1,comunicador,persistirDatos,provedorDeFechas);
        var participante = new Participante("Victor",10);
        concurso.InscribirParticipante(participante,LocalDateTime.now());
*/
        AprendiendoLambdas aprendiendo = new AprendiendoLambdas();
        aprendiendo.unMetodo((c) -> c.length() % 2 == 0 );

        aprendiendo.unMetodo(c -> c.startsWith("a"));
    }




}