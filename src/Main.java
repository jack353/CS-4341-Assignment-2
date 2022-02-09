import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            File myObj = new File("C:\\Users\\Alex\\Desktop\\CS-4341-Assignment-2\\src\\input.txt");
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data+"\n");
            }
            myReader.close();
    }
}