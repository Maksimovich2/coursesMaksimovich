package tasks.fourth;

import java.util.Scanner;

/**
 * Создайте программу, которая будет получать число и печатать его в следующем формате
 * (формы цифр можно придумать свои, главное, чтобы они читались на экране):
 * (*) Дополнительно: сделайте так, чтобы наибольшая цифра состояла не из ‘*’, а из соответствующих маленьких (обычных) цифр.
 */

public class NumbersAsterisks {
    private final String[][] templatePrintNumbers = {
            {" ", " ", "*", " ", " ", " ", "*", "*", " ", "  ", "*", "*", "*", "  ", " ", "*", " ", "*", "  ", " ", "*", "*", "*", "  ", " ", "*", "*", "*", "  ", " ", "*", "*", "*", " ", "  ", "  ", "*", "*", "*", " ", "*", "*", "*", " ", "  ", "*", "*", "*", "  ", " "},
            {" ", "*", "*", " ", " ", "*", " ", " ", "*", "  ", " ", " ", "*", "  ", " ", "*", " ", "*", "  ", " ", "*", " ", " ", "  ", " ", "*", " ", " ", "  ", " ", " ", " ", "*", " ", "  ", "  ", "*", " ", "*", " ", "*", " ", "*", " ", "  ", "*", " ", "*", "  ", " "},
            {" ", " ", "*", " ", " ", " ", " ", " ", "*", "  ", " ", " ", "*", "  ", " ", "*", " ", "*", "  ", " ", "*", " ", " ", "  ", " ", "*", " ", " ", "  ", " ", " ", " ", "*", " ", "  ", "  ", "*", " ", "*", " ", "*", " ", "*", " ", "  ", "*", " ", "*", "  ", " "},
            {" ", " ", "*", " ", " ", " ", " ", " ", "*", "  ", "*", "*", "*", "  ", " ", "*", "*", "*", "  ", " ", "*", "*", "*", "  ", " ", "*", "*", "*", "  ", " ", " ", " ", "*", " ", "  ", "  ", "*", "*", "*", " ", "*", "*", "*", " ", "  ", "*", " ", "*", "  ", " "},
            {" ", " ", "*", " ", " ", " ", "*", "*", " ", "  ", " ", " ", "*", "  ", " ", " ", " ", "*", "  ", " ", " ", " ", "*", "  ", " ", "*", " ", "*", "  ", " ", " ", "*", "*", "*", "  ", "  ", "*", " ", "*", " ", " ", " ", "*", " ", "  ", "*", " ", "*", "  ", " "},
            {" ", " ", "*", " ", " ", " ", "*", " ", " ", "  ", " ", " ", "*", "  ", " ", " ", " ", "*", "  ", " ", " ", " ", "*", "  ", " ", "*", " ", "*", "  ", " ", " ", " ", "*", " ", "  ", "  ", "*", " ", "*", " ", " ", " ", "*", " ", "  ", "*", " ", "*", "  ", " "},
            {" ", " ", "*", " ", " ", " ", "*", "*", "*", "  ", "*", "*", "*", "  ", " ", " ", " ", "*", "  ", " ", "*", "*", "*", "  ", " ", "*", "*", "*", "  ", " ", " ", " ", "*", " ", "  ", "  ", "*", "*", "*", " ", "*", "*", "*", " ", "  ", "*", "*", "*", "  ", " "}
    };
    private int number;

    private void enterNumber(){
        System.out.print("enter number: ");
        Scanner in = new Scanner(System.in);
        this.number = in.nextInt();
    }

    private int[] makeArrayNumbers(){
        String temp = Integer.toString(number);
        int[] numbers = new int[temp.length()];
        for (int numberIndex = 0; numberIndex < temp.length(); numberIndex++)
        {
            numbers[numberIndex] = Integer.parseInt(String.valueOf(temp.charAt(numberIndex)));
        }
        return numbers;
    }

    public void printNumbers(){
        int[] arrayNumbers = makeArrayNumbers();
        int indexMaxElement = searchMaxElementArray(arrayNumbers);
        for (int width = 0; width < 7; width++) {
            for (int currentIndexMatrix = 0; currentIndexMatrix < arrayNumbers.length; currentIndexMatrix++) {
                int temp = initialPrintIndex(arrayNumbers[currentIndexMatrix]);
                for (int startIndexDigitPrinting = temp; startIndexDigitPrinting < temp + 5; startIndexDigitPrinting++) {
                    System.out.print(swapSymbols(templatePrintNumbers[width][startIndexDigitPrinting], indexMaxElement, currentIndexMatrix, String.valueOf(arrayNumbers[indexMaxElement])) );
                }
            }
            System.out.println();
        }
    }

    private String swapSymbols(String replaceableSymbol, int indexMaxElement, int currentIndex, String swapSymbol){
        if(replaceableSymbol.equals(" ")){
            return " ";
        }
        if (replaceableSymbol.equals("*") && indexMaxElement == currentIndex) {
            return swapSymbol;
        }
        else{
            return replaceableSymbol;
        }
    }

    private int initialPrintIndex(int printNumber){
        int[] printValues = new int[] {44, 0, 5, 10, 15, 20, 25, 29, 35, 39};
        return printValues[printNumber];
    }

    private int searchMaxElementArray(int[] array){
        int indexMaxElement = 0;
        int maxNumber = 0;
        for (int numberIndex = 0; numberIndex < array.length; numberIndex++) {
            if(maxNumber <= array[numberIndex]){
                maxNumber = array[numberIndex];
                indexMaxElement = numberIndex;
            }
        }
        return indexMaxElement;
    }

    public static void main(String[] args) {
        NumbersAsterisks templateNumbers = new NumbersAsterisks();
        templateNumbers.enterNumber();
        templateNumbers.printNumbers();
    }
}
