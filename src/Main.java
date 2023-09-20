import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args){
        timesInFileCharacter('a', new File("./quijote.txt"));
        compareAppearancesOfCharacterInFile(new File("./quijote.txt"));
    }

    public static int timesInFileCharacter(char givenCharacter, File givenFile) {
        int charCounter = 0;
        StringBuilder textFile = new StringBuilder();
        Scanner textReader = null;
        try {
            textReader = new Scanner(givenFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (textReader.hasNext()) {
            textFile.append(textReader.nextLine());
        }
        for (int i = 0; i < textFile.length(); i++) {
            if (textFile.charAt(i) == givenCharacter) {
                charCounter++;
            }
        }
        return charCounter;

    }

    public static void compareAppearancesOfCharacterInFile(File givenFile) {
        Map<Character, Integer> map;
        map = new HashMap<Character, Integer>();
        StringBuilder textFile = new StringBuilder();
        Scanner textReader = null;
        try {
            textReader = new Scanner(givenFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (textReader.hasNext()) {
            textFile.append(textReader.nextLine());
        }
        for (int i = 0; i < textFile.length(); i++) {
            if (!map.containsKey(textFile.charAt(i))){
                map.putIfAbsent(textFile.charAt(i), map.getOrDefault(textFile.charAt(i), 0)+1);
            }
            else {
                map.put(textFile.charAt(i), map.get(textFile.charAt(i))+1);
            }
        }
        int maxValue = Collections.max(map.values());
        char key = 'a';
        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                key = entry.getKey();
            }
        }
        System.out.println("El caracter más usado es: " + key + "\nCon: " + maxValue + " usos"); //El caracter más usado es espacio, yo no hago las reglas
    }




}