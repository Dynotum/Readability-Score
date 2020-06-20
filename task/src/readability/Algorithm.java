package readability;

public class Algorithm {

    public double getARI(int characters, int words, int sentences) {
        final double score = 4.71 * ((double) characters / words) + 0.5 * ((double) words / sentences) - 21.43;
        final int age = getAge(score);

        System.out.printf("Automated Readability Index: %.2f (about %d year olds).\n", score, age);
        return age;
    }

    private int getAge(double score) {
        switch ((int) Math.round(score)) {
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 9;
            case 4:
                return 10;
            case 5:
                return 11;
            case 6:
                return 12;
            case 7:
                return 13;
            case 8:
                return 14;
            case 9:
                return 15;
            case 10:
                return 16;
            case 11:
                return 17;
            case 12:
                return 18;
            default:
                return 24;
        }
    }

    public double getFK(int words, int sentences, int syllables) {
        final double score = (0.39 * ((double) words / sentences)) + (11.8 * ((double) syllables / words)) - 15.59;
        final int age = getAge(score);

        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).\n", score, age);
        return age;
    }

    public double getSMOG(int polysyllables, int sentences) {
        final double score = 1.043 * (Math.sqrt(polysyllables * ((double) 30 / sentences))) + 3.1291;
        final int age = getAge(score);

        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).\n", score, age);
        return age;
    }

    public double getCL(int characters, int words, int sentences) {
        final double L = ((double) characters / words) * 100;
        final double S = ((double) sentences / words) * 100;
        final double score = 0.0588 * L - 0.296 * S - 15.8;
        final int age = getAge(score);

        System.out.printf("Coleman–Liau index: %.2f (about %d year olds).\n", score, age);
        return age;
    }
}