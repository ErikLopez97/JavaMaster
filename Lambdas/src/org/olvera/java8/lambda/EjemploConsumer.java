package org.olvera.java8.lambda;

import org.olvera.java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {

        //Consumer<String> consumidor = saludo -> System.out.println(saludo);
        Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(f.format(fecha));
        };
        consumidor.accept(new Date());

        //Esto es una forma de tener BiConsumer
        /*
        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> {
            System.out.println(nombre + " tiene, " + edad + " años ");
        };
        consumidorBi.accept("Erik", 20);
         */

        //Esta es otra forma de simplicar el codigo
        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> System.out.println(nombre + " tiene " + edad + " años ");
        consumidorBi.accept("Erik", 20);

        //Consumer<String> consumidor2 = mensaje -> System.out.println(mensaje);  Recordemos que "mensaje" es el parametro y en este caso consumidor2 es el nombre del metodo

        // Aun se puede simplificar aun mas lo que tenemos arriba
        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola mundo lambda");

        List<String> nombres = Arrays.asList("andres", "pepe", "luz", "paco");
        nombres.forEach(consumidor2);

        Supplier<Usuario> creaUsuario = () -> new Usuario();
        Usuario usuario = creaUsuario.get();
        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;
        asignarNombre.accept(usuario, " Andres ");

        System.out.println("Nombre de usario " + usuario.getNombre());

        //-----------------------------------------------------------------------------------------------------------------------
        /*
            Supplier<String> proveedor = () -> {
            return "Hola mundo lambda supplient";
        };
        System.out.println(proveedor.get());
         */

        // Lo de arriba se puede simplificar

        Supplier<String> proveedor = () -> "Hola munda lambda supplier";
        System.out.println(proveedor.get());

    }
}
