package readability;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Readability {
    private final File fileName;
    private final String text;
    private final int words;
    private final int sentences;
    private final int characters;
    private final int syllables;
    private final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
    private int polysyllables;

    public Readability(String fileName) {
        this.fileName = new File(fileName);
        this.text = importFile();
//        this.text = "This is the front page of the Simple English Wikipedia. Wikipedias are places where people work together to write encyclopedias in different languages. We use Simple English words and grammar here. The Simple English Wikipedia is for everyone! That includes children and adults who are learning English. There are 142,262 articles on the Simple English Wikipedia. All of the pages are free to use. They have all been published under both the Creative Commons License and the GNU Free Documentation License. You can help here! You may change these pages and make new pages. Read the help pages and other good pages to learn how to write pages here. If you need help, you may ask questions at Simple talk. Use Basic English vocabulary and shorter sentences. This allows people to understand normally complex terms or phrases.";
        this.words = getWords();
        this.sentences = getSentences();
        this.characters = getCharacters();
        this.syllables = getSyllables();
    }


    private int getSyllables() {
        final String[] separateBySpace = text.split("\\s+");
        int count = 0;
        int poly = 0;
        for (String word : separateBySpace) {
            int otro = 0;
            boolean prevIsVowel = false;
            word = word.replaceAll("\\s*\\p{Punct}+\\s*$", "");

            if (word.toLowerCase().endsWith("e")) {
                word = word.substring(0, word.length() - 1);
            }

            for (char c : word.toLowerCase().toCharArray()) {
                final boolean isVowel = vowels.contains(c);
                if (isVowel && !prevIsVowel) {
                    ++otro;
                }
                prevIsVowel = isVowel;
            }

            //Get count of polysyllables
            if (otro > 2) {
                poly++;
            }

            otro = otro == 0 ? otro + 1 : otro;
            count += otro;
        }

        setPolysyllables(poly);
        return count;
    }

    private int getPolysyllables() {
        return this.polysyllables;
    }

    private void setPolysyllables(int poly) {
        this.polysyllables = poly;
    }

    private int getCharacters() {
        final String[] separateBySpace = text.split("\\s+");

        return Arrays.stream(separateBySpace).mapToInt(
                String::length).sum();
    }

    private int getSentences() {
        return text.split("[.!?]+\\s*").length;
    }

    private int getWords() {
        return text.split("\\s+").length;
    }

    public void getResultReadability() {
        final String algo;
        System.out.println("The text is:");
        System.out.println(text);
        System.out.println();

        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + getPolysyllables());
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");

        algo = new Scanner(System.in).nextLine();

        final Algorithm algorithm = new Algorithm();
        double average = 0;

        switch (algo.toUpperCase()) {
            case "ARI":
                average = algorithm.getARI(characters, words, sentences);
                break;
            case "FK":
                average = algorithm.getFK(words, sentences, syllables);
                break;
            case "SMOG":
                average = algorithm.getSMOG(polysyllables, sentences);
                break;
            case "CL":
                average = algorithm.getCL(characters, words, sentences);
                break;
            case "ALL":
                average += algorithm.getARI(characters, words, sentences);
                average += algorithm.getFK(words, sentences, syllables);
                average += algorithm.getSMOG(polysyllables, sentences);
                average += algorithm.getCL(characters, words, sentences);
                average = average / 4;
                break;
        }

        System.out.printf("\nThis text should be understood in average by %.0f year olds.", average);
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
