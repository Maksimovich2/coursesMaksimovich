package tasks.third;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Создайте программу, которая будет:
 * -подсчитывать количество гласных в словах
 * -выводить слова отсортированным списком по количеству гласных (сначала те, у которых больше гласных)
 * -делать первую гласную букву в слове заглавной
 * Предложение вводится пользователем вручную русскими буквами. Разделитель пробел (“ ”).
 */

public class Vowels {
    private static final Pattern vowels = Pattern.compile("(?iu)[ауоыиэяюёеАУОЫИЭЯЮЁЕ]");
    private final List<Character> vowel =  new ArrayList<>(Arrays.asList('а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е'));

    private String line;

    private void enterLine(){
        System.out.print("enter line: ");
        Scanner in = new Scanner(System.in);
        this.line = in.nextLine();
    }
    public void countVowel() {
        if (line == null) {
            throw new IllegalArgumentException("the word cannot be null!");
        }
        Matcher matcher = vowels.matcher(line);
        int vowelsCounter = 0;
        while (matcher.find()) {
            vowelsCounter++;
        }
        System.out.println("Результат: " + vowelsCounter + " гласных");
    }

    public void sortWords() {
        List<String> list = Arrays.asList(line.split("\\s+"));
        list.sort(Comparator.comparing(this::getValue).reversed());
        System.out.println(list);
    }

    private Integer getValue(String line) {
        Matcher matcher = vowels.matcher(line);
        int countVowelsInWord = 0;
        while (matcher.find()) {
            countVowelsInWord++;
        }
        return countVowelsInWord;
    }

    public void replacement() {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("check your line!");
        }
        String[] words = line.split("\\s+");

        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            char[] lettersWord = words[wordIndex].toCharArray();
            for (int lettersWordIndex = 0; lettersWordIndex < lettersWord.length; lettersWordIndex++) {
                if (vowel.contains(lettersWord[lettersWordIndex])) {
                    String firstVowel = String.valueOf(lettersWord[lettersWordIndex]).toUpperCase(Locale.ROOT);
                    lettersWord[lettersWordIndex] = firstVowel.toCharArray()[0];
                    words[wordIndex] = String.valueOf(lettersWord);
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(words));
    }

    public static void main(String[] args) {
        Vowels lineWithVowels = new Vowels();
        lineWithVowels.enterLine();
        lineWithVowels.countVowel();
        lineWithVowels.sortWords();
        lineWithVowels.replacement();
    }
}
