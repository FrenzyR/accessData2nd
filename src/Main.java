import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static final int possibleLetters = 26;
    public static File fileRoute = new File("./quijote.txt");
    public static StringBuilder donQuixote;

    static {
        try {
            donQuixote = quixoteStore();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException { //TODO trycatch
        timesInFileCharacter('a');
        //System.out.println("There's a total of " + timesInFileCharacter('a') + " 'a's in Don Quixote");
        compareAppearancesOfCharacterInFile();
    }

    public static int timesInFileCharacter(char givenCharacter) throws FileNotFoundException { //TODO file parametro
        int charCounter = 0;
        for (int i = 0; i < donQuixote.length(); i++) {
            if (donQuixote.charAt(i) == givenCharacter) {
                charCounter++;
            }
        }
        return charCounter;

    }

    public static void compareAppearancesOfCharacterInFile() throws FileNotFoundException {
        int charCounter = 0;
        char givenChar;
        int y = 0;
        HashMap<Character, Integer> comparison;
        comparison = new HashMap<Character, Integer>();
        while (y < possibleLetters) {
            givenChar = (char) ('a' + y);
            comparison.put(givenChar, 0);
            y++;
        }
        int comparisonNumber = 0;
        for (int i = 0; i < possibleLetters; i++) {
            givenChar = (char) ('a' + i);
            comparison.replace(givenChar, timesInFileCharacter(givenChar));

        }
        System.out.println(comparison);


    }

    public static StringBuilder quixoteStore() throws FileNotFoundException {
        StringBuilder donQuixote = new StringBuilder();
        Scanner quixoteReader = new Scanner(fileRoute);
        while (quixoteReader.hasNext()) {
            donQuixote.append(quixoteReader.nextLine());

        }
        return donQuixote;
    }
}