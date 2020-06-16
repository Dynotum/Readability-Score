package readability;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Readability {
    private final File fileName;
    private final String text;
    private final int words;
    private final int sentences;
    private final int characters;
    private final double score;

    public Readability(String fileName) {
        this.fileName = new File(fileName);
        this.text = importFile();
        this.words = getWords();
        this.sentences = getSentences();
        this.characters = getCharacters();
        this.score = getScore();
    }

    private double getScore() {
        final double score = 4.71 * ((double) characters /  words) + 0.5 * ((double) words / sentences) - 21.43;
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
