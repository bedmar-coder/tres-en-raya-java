/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa6.tresenraya;

import java.util.Scanner;

/**
 *
 * @author batoi
 */
public class GestorIO {

    private static Scanner teclado = new Scanner(System.in);
    private static final String REG_EXP = "^[a-z A-Z]-[1-9]*$";
    private static final String REG_EXP_DIMENSION="[4-8]";

    public static String leerLetraGuionNumero(String mensaje) {
        int x = 0;

        System.out.println(mensaje);
        System.out.print("Introduce Casilla Letra-Numero: ");
        String eleccion = "";
        do {
            eleccion = teclado.nextLine();

            

        } while (!eleccion.matches(REG_EXP));

        return eleccion;
    }
    
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public static String leerTexto(String mensaje) {
        System.out.println(mensaje);
        return teclado.nextLine();
    }
    public static int leerEntero(String mensaje) {
        System.out.println(mensaje);
        String respuesta;
        do{
           respuesta= teclado.next();
           if(!respuesta.matches(REG_EXP_DIMENSION)){
               System.out.println("Escribe un número valido");
           }
        } while(!respuesta.matches(REG_EXP_DIMENSION));
        return Integer.parseInt(respuesta);
    }

    public static boolean solicitarConfirmacion(String mensaje) {
        System.out.println(mensaje);
        System.out.print("Responde si o no(s/n): ");
        String respuesta = null;
        do {
            respuesta = teclado.next();

            if (respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("n")) {

                break;
            }
            System.out.println("\n\tError. Responde con s o n: ");

        } while (true);

        if (respuesta.equalsIgnoreCase("s")) {
            return true;
        };
        return false;

    }

    public static void cerrar() {
        teclado.close();
    }

    public static int letraANumero(String letra) {
        return switch (letra.toLowerCase()) {
            case "a" ->
                0;
            case "b" ->
                1;
            case "c" ->
                2;
            case "d" ->
                3;
            case "e" ->
                4;
            case "f" ->
                5;
            case "g" ->
                6;
            case "h" ->
                7;
            case "i" ->
                8;
            case "j" ->
                9;
            case "k" ->
                10;
            case "l" ->
                11;
            case "m" ->
                12;
            case "n" ->
                13;
            case "o" ->
                14;
            case "p" ->
                15;
            case "q" ->
                16;
            case "r" ->
                17;
            case "s" ->
                18;
            case "t" ->
                19;
            case "u" ->
                20;
            case "v" ->
                21;
            case "w" ->
                22;
            case "x" ->
                23;
            case "y" ->
                24;
            default ->
                25;
        };
    }

}
