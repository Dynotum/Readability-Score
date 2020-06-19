package readability;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Readability {
    private final File fileName;
    private final String text;
    private final int words;
    private final int sentences;
    private final int characters;
    private final double score;
    private final int syllables;

    public Readability(String fileName) {
        this.fileName = new File(fileName);
//        this.text = importFile();
        this.text = "This is the front page of the Simple English Wikipedia. Wikipedias are places where people work together to write encyclopedias in different languages. We use Simple English words and grammar here. The Simple English Wikipedia is for everyone! That includes children and adults who are learning English. There are 142,262 articles on the Simple English Wikipedia. All of the pages are free to use. They have all been published under both the Creative Commons License and the GNU Free Documentation License. You can help here! You may change these pages and make new pages. Read the help pages and other good pages to learn how to write pages here. If you need help, you may ask questions at Simple talk. Use Basic English vocabulary and shorter sentences. This allows people to understand normally complex terms or phrases.";
        this.words = getWords();
        this.sentences = getSentences();
        this.characters = getCharacters();
        this.score = getScore();
        this.syllables = getSyllables();
    }

    private int getSyllables() {
        final String[] separateBySpace = text.split("\\s+");
        int count = 0;
        for (String word : separateBySpace) {
            System.out.println(word);
            word = word.replaceAll("\\s*\\p{Punct}+\\s*$", "");

            if (word.toLowerCase().endsWith("e")) {
                word = word.substring(0, word.length() - 1);
            }

            if (word.matches("[aeiouyAEIOUY]{1,3}")) {
                word = word.replaceAll("[aeiouyAEIOUY]{1,3}", "");
                int res = word.replaceAll("[^aeiouyAEIOUY]", "").length();
                System.out.println("a ver " + res);

                count = res == 0 ? count + 1 : count + res;

                System.out.println(word + "!!!!!!!!!!!!!!!!");
            } else if (word.matches("\\w+")) {
                System.out.println("++ " + word.replaceAll("[^aeiouyAEIOUY]", "").length() + " ++");

                if (word.matches("[aeiouyAEIOUY]{2}")){
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$");
                }

                int res = word.replaceAll("[^aeiouyAEIOUY]", "").length();

                count = res == 0 ? count + 1 : count + res;
                System.out.println("final resu= " + res);
            } else {
                System.out.println("+1+");
                count++;
            }

            System.out.println("final word = " + word);
            System.out.println("current counter = " + count);
            System.out.println("+==========================================");
        }
        System.out.println("Syllables: " + count);
        return count;
    }

    private double getScore() {
        final double score = 4.71 * ((double) characters / words) + 0.5 * ((double) words / sentences) - 21.43;
        return score;
    }

    private int getCharacters() {
        final String[] separateBySpace = text.split("\\s+");

        return Arrays.stream(separateBySpace).mapToInt(
                characters -> characters.length()).sum();
    }

    private int getSentences() {
        return text.split("[.!?]+\\s*").length;
    }

    private int getWords() {
        return text.split("\\s+").length;
    }

    public void getResultReadability() {
        System.out.println("The text is:");
        System.out.println(text);
        System.out.println();

        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.println("Syllables: " + syllables);

        System.out.printf("The score is: %.2f\n", score);
        System.out.println("This text should be understood by " + getAge() + " year olds.");
    }

    private String getAge() {
        switch ((int) Math.ceil(score)) {
            case 1:
                return "5-6";
            case 2:
                return "6-7";
            case 3:
                return "7-9";
            case 4:
                return "9-10";
            case 5:
                return "10-11";
            case 6:
                return "11-12";
            case 7:
                return "12-13";
            case 8:
                return "13-14";
            case 9:
                return "14-15";
            case 10:
                return "15-16";
            case 11:
                return "16-17";
            case 12:
                return "17-18";
            case 13:
                return "18-24";
            default:
                return "24+";
        }
    }

    private String importFile() {
        final StringBuilder stringBuilder = new StringBuilder();
        if (fileName.exists()) {
            try (var isr = new InputStreamReader(new FileInputStream(fileName));
                 var br = new BufferedReader(isr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                }
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        } else {
            System.out.println("Error : File not found.");
        }
        return stringBuilder.toString();
    }
}
