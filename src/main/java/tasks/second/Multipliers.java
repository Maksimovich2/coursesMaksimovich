package tasks.second;

import java.util.Scanner;

/**
 * Создайте программу, которая будет вычислять и выводить на экран простые множители,
 * из которых состоит целое число, введенное пользователем.
 * Если введенное число не целое, то нужно сообщать пользователю об ошибке.
 */

public class Multipliers {
    private double number;

    private void enterNumber(){
        System.out.print("enter number: ");
        Scanner in = new Scanner(System.in);
        this.number = in.nextDouble();
    }

    public void factorization() {
        int firstMultiplier = 2;
        if (number % 1 == 0) {
            while (number != 1) {
                if (number % firstMultiplier == 0) {
                    System.out.print(firstMultiplier + " ");
                    number /= firstMultiplier;
                } else if (firstMultiplier == 2) {
                    firstMultiplier++;
                } else {
                    firstMultiplier += 2;
                }
            }
        }
        else{
            throw new IllegalArgumentException("enter an integer");
        }
    }

    public static void main(String[] args) {
        Multipliers multipliers = new Multipliers();
        multipliers.enterNumber();
        multipliers.factorization();
    }
}
