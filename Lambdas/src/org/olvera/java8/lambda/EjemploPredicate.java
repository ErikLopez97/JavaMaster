package org.olvera.java8.lambda;

import org.olvera.java8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        Predicate<Integer> test = num -> num > 10;
        boolean r = test.test(7);
        System.out.println("r = " + r);

        Predicate<String> t2 = role -> role.equals("Role_Admin");
        System.out.println(t2.test("Role_User"));

        BiPredicate<String, String> t3 = String::equals; // (a, b) -> a.equals(b);
        System.out.println(t3.test("andres", "andres"));

        BiPredicate<Integer, Integer> t4 = Integer::equals;
        System.out.println(t4.test(5, 6));

        BiPredicate<Integer, Integer> t5 = (i, j) -> j < i;
        System.out.println(t5.test(10, 5));

        Usuario a = new Usuario();
        Usuario b = new Usuario();

        a.setNombre("maria");
        b.setNombre("maria");
        BiPredicate<Usuario, Usuario> t6 = (ua, ub) -> ua.getNombre().equals(ub.getNombre());
        System.out.println(t6.test(a, b));
    }
}
