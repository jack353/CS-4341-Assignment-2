import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    //setup to take proper command line arguments
    // puzzle#, filename, #seconds

    public static void main(String[] args) {

        float[] input = new float[40];
        int counter = 0;

        File myObj = new File("C:\\Users\\Alex\\Desktop\\CS-4341-Assignment-2\\src\\input.txt");
        Scanner myReader = null;

        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            //System.out.println(data+"\n");
            float num = Float.parseFloat(data);
            //System.out.println(num+"\n");
            input[counter] = num;
        }
        myReader.close();

        //setup to pass input to ga
    }
}