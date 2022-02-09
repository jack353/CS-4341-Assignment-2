import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //setup to take proper command line arguments
    // puzzle#, filename, #seconds

    public static void main(String[] args) {

        ArrayList<Float> input = new ArrayList<Float>();

        File myObj = new File("src/input.txt");
        Scanner myReader = null;

        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            input.add(Float.parseFloat(data));
        }
        myReader.close();

        //setup to pass input to ga
    }
}