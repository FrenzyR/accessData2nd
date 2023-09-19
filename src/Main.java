import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static File fileRoute = new File("./quijote.txt");
    public static StringBuilder donQuixote;

    static {
        try {
            donQuixote = quixoteStore();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ammountOfTimesInFileCharacter('a');
        ammountOfTimesInFileCharacter('b');
        ammountOfTimesInFileCharacter('c');
        compareAmmountOfCharactersInFile();
    }

    public static void ammountOfTimesInFileCharacter(char givenCharacter) throws FileNotFoundException {
        char[] character = new char[26];
        for (int i = 0; i < character.length; i++) {
            character[i] = (char) ('a' + i);
        }
        int charCounter = 0;
        for (int i = 0; i < donQuixote.length(); i++) {
            if (donQuixote.charAt(i)==givenCharacter){
                charCounter++;
            }
        }
        System.out.println("There's " + charCounter + " instances of the character " + givenCharacter);
    }

    public static void compareAmmountOfCharactersInFile() throws FileNotFoundException {
        int charCounter = 0;
        int y = 0;
        HashMap<Character, Integer> comparison;
        comparison = new HashMap<Character, Integer>();
        while (y < 26){
            comparison.put((char) ('a' + y), y);
            y++;
        }
        char[] donQuixoteChars = donQuixote.toString().toCharArray();
        for (char donQuixoteChar : donQuixoteChars) {
            comparison.replace(donQuixoteChar, charCounter++);

        }
        System.out.println(comparison);

    }

    public static StringBuilder quixoteStore() throws FileNotFoundException {
        StringBuilder donQuixote = new StringBuilder();
        Scanner quixoteReader = new Scanner(fileRoute);
        while (quixoteReader.hasNext()){
            donQuixote.append(quixoteReader.nextLine());

        }
        return donQuixote;
    }
}