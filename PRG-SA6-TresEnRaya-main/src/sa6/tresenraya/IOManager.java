/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa6.tresenraya;

import java.util.Scanner;

/**
 * Helper class that handles all the console input and output.
 *
 * @author batoi
 */
public class IOManager {

    private static Scanner keyboard = new Scanner(System.in);
    private static final String REG_EXP = "^[a-z A-Z]-[1-9]*$";
    private static final String REG_EXP_DIMENSION = "[4-8]";

    /**
     * Keeps asking for a cell until the input looks like "Letter-Number" (e.g. A-1).
     *
     * @param message the text shown before asking
     * @return the cell typed by the user
     */
    public static String readLetterDashNumber(String message) {
        int x = 0;

        System.out.println(message);
        System.out.print("Enter a cell as Letter-Number: ");
        String choice = "";
        do {
            choice = keyboard.nextLine();

        } while (!choice.matches(REG_EXP));

        return choice;
    }

    /**
     * Prints a message on the console.
     *
     * @param message the text to print
     */
    public static void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints a message and reads a line of text.
     *
     * @param message the text shown before asking
     * @return the line typed by the user
     */
    public static String readText(String message) {
        System.out.println(message);
        return keyboard.nextLine();
    }

    /**
     * Keeps asking until the user types a valid board size.
     *
     * @param message the text shown before asking
     * @return the number typed by the user
     */
    public static int readInteger(String message) {
        System.out.println(message);
        String answer;
        do {
            answer = keyboard.next();
            if (!answer.matches(REG_EXP_DIMENSION)) {
                System.out.println("Enter a valid number");
            }
        } while (!answer.matches(REG_EXP_DIMENSION));
        return Integer.parseInt(answer);
    }

    /**
     * Asks a yes/no question. The user answers with "s" (yes) or "n" (no).
     *
     * @param message the question to show
     * @return true if the user answered "s"
     */
    public static boolean askForConfirmation(String message) {
        System.out.println(message);
        System.out.print("Answer yes or no (s = yes / n = no): ");
        String answer = null;
        do {
            answer = keyboard.next();

            if (answer.equalsIgnoreCase("s") || answer.equalsIgnoreCase("n")) {

                break;
            }
            System.out.println("\n\tError. Answer with s or n: ");

        } while (true);

        if (answer.equalsIgnoreCase("s")) {
            return true;
        };
        return false;

    }

    /**
     * Closes the keyboard scanner.
     */
    public static void close() {
        keyboard.close();
    }

    /**
     * Converts a row letter into its index (a = 0, b = 1, ...).
     *
     * @param letter the letter to convert
     * @return the index of the letter, or 25 for any other value
     */
    public static int letterToNumber(String letter) {
        return switch (letter.toLowerCase()) {
            case "a" -> 0;
            case "b" -> 1;
            case "c" -> 2;
            case "d" -> 3;
            case "e" -> 4;
            case "f" -> 5;
            case "g" -> 6;
            case "h" -> 7;
            case "i" -> 8;
            case "j" -> 9;
            case "k" -> 10;
            case "l" -> 11;
            case "m" -> 12;
            case "n" -> 13;
            case "o" -> 14;
            case "p" -> 15;
            case "q" -> 16;
            case "r" -> 17;
            case "s" -> 18;
            case "t" -> 19;
            case "u" -> 20;
            case "v" -> 21;
            case "w" -> 22;
            case "x" -> 23;
            case "y" -> 24;
            default -> 25;
        };
    }

}
