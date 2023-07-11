/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

/**
 *
 * @author Aruna
 */
import java.util.regex.Pattern;

public class StringValidator {
    public static void main(String[] args) {
        // Example usage
        String input = "qwe123";

        boolean hasTextAndNumbers = hasTextAndNumbers(input);
        System.out.println("Has text and numbers: " + hasTextAndNumbers);
    }

    public static boolean hasTextAndNumbers(String input) {
        boolean hasText = Pattern.compile("[a-zA-Z]").matcher(input).find();
        //boolean hasNumbers = Pattern.compile("\\d").matcher(input).find();

        return hasText;
    }
}

