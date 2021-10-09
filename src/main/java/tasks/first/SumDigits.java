package tasks.first;

/**
 * Напишите программу, которая возвращает сумму цифр, присутствующих в данной строке.
 * Если цифр нет, то возвращаемая сумма должна быть равна 0.
 */

public class SumDigits {

    public int sumNumbersInString(String line) {
        if(line == null){
            throw new IllegalArgumentException("Line cannot be null!");
        }
        boolean hasDigit = line.matches(".*\\d+.*");

        int sum = 0;
        if (hasDigit) {
            int value = Integer.parseInt(line.replaceAll("[^0-9]", ""));
            String str = Integer.toString(value);
            int[] numbers = new int[str.length()];
            for (int numberIndex = 0; numberIndex < str.length(); numberIndex++) {
                numbers[numberIndex] = Integer.parseInt(String.valueOf(str.charAt(numberIndex)));
            }
            for (int number : numbers) {
                sum += number;
            }
            return sum;
        }
        else
            return 0;
    }

    public static void main(String[] args) {
        SumDigits testString = new SumDigits();
        System.out.println(testString.sumNumbersInString("f23fd4 gg11rh"));
    }
}
