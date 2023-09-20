import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static File fileRoute = new File("./quijote.txt");
    public static StringBuilder textFile;

    public static void main(String[] args){
        timesInFileCharacter('a');
        compareAppearancesOfCharacterInFile();
    }

    public static int timesInFileCharacter(char givenCharacter) { //TODO file parametro
        int charCounter = 0;
        for (int i = 0; i < Main.textFile.length(); i++) {
            if (Main.textFile.charAt(i) == givenCharacter) {
                charCounter++;
            }
        }
        return charCounter;

    }

    public static void compareAppearancesOfCharacterInFile() {
        Map<Character, Integer> map;
        map = new HashMap<Character, Integer>();
        for (int i = 0; i < Main.textFile.length(); i++) {
            if (!map.containsKey(Main.textFile.charAt(i))){
                map.putIfAbsent(Main.textFile.charAt(i), map.getOrDefault(Main.textFile.charAt(i), 0)+1);
            }
            else {
                map.put(Main.textFile.charAt(i), map.get(Main.textFile.charAt(i))+1);
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

    public static StringBuilder fileStore() throws FileNotFoundException {
        StringBuilder textFile = new StringBuilder();
        Scanner textReader = new Scanner(Main.fileRoute);
        while (textReader.hasNext()) {
            textFile.append(textReader.nextLine());
        }
        return textFile;
    }

    static {
        try {
            Main.textFile = fileStore();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}