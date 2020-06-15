package readability;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String text = scanner.nextLine();

        final String[] sentences = text.split("([!.?])");

        /**
         * Identify those pesky unicode spaces
         * Replace them for regular whitespace
         * Then, trimming and split all the words
         */
        final int words = Arrays.stream(sentences).mapToInt(
                str -> str.replaceAll("\\s+|\\p{Z}|\\p{Space}|\\p{Blank}", " ")
                        .trim()
                        .split("\\s+|\\p{Z}|\\p{Space}|\\p{Blank}").length)
                .sum();

        double result = (double) words / sentences.length;

        System.out.println(result <= 10 ? "EASY" : "HARD");

    }
}
