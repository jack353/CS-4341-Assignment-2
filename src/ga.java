import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ga {

    //setup to take proper command line arguments
    // puzzle#, filename, #seconds

    public static final float[] input = new float[40];

    public static void main(String[] args) {

        int puzzle = Integer.parseInt(args[0]);

        if(args.length != 3){
            System.out.println("An error occurred.");
            System.out.println("Invalid number of input.");
            System.out.println("Please input a puzzle #, filename, and # of seconds.");
        } else if(puzzle != 1 && puzzle != 2) {
            System.out.println("An error occurred.");
            System.out.println("Invalid puzzle input.");
            System.out.println("Please input puzzle number 1 or 2.");
        }

        int counter = 0;
        int time = Integer.parseInt(args[2]);

        File myObj = new File("C:\\Users\\Alex\\Desktop\\CS-4341-Assignment-2\\src\\" + args[1]);
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
            //1System.out.println(num+"\n");
            input[counter] = num;
        }
        myReader.close();

        solve(puzzle, input, time);
    }

    static void solve(int puzzle, float[] input, int time){
        long startTime = System.nanoTime();
        if(puzzle == 1){
            BinPopulation p = new BinPopulation(20);
            p.generateIndividuals();
            while((System.nanoTime() - startTime) / 1000000000 < time){
                p.findFitnesses();
                p.sortIndividuals();
                p.cull();
                p.getProbabilites();
                p.haveKids();
            }

        }

        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1000000000;
        System.out.println(elapsedTime);
    }
}
