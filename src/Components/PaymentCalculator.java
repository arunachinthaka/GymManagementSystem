/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

/**
 *
 * @author Aruna
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PaymentCalculator {
    public static void main(String[] args) {
        // Example usage
        LocalDate currentMonth = LocalDate.now();
        int monthsToAdd = 3;

        LocalDate nextPaymentDate = calculateNextPaymentMonth(currentMonth, monthsToAdd);
        System.out.println("Next Payment Date: " + formatPaymentDate(nextPaymentDate));
    }

    public static LocalDate calculateNextPaymentMonth(LocalDate currentMonth, int monthsToAdd) {
        return currentMonth.plusMonths(monthsToAdd);
    }
    
    public static LocalDate calculateNextPaymentYear(int yearsFromNow) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.plusYears(yearsFromNow);
    }

    public static String formatPaymentDate(LocalDate paymentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return paymentDate.format(formatter);
    }
}

