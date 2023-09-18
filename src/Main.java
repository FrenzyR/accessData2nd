import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File fileRoute = new File("./quijote.txt");
        String donQuixote;
        try {
            Scanner quixoteReader = new Scanner(fileRoute);
            while (quixoteReader.hasNext()){
                donQuixote = quixoteReader.next();
                System.out.print(donQuixote);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}