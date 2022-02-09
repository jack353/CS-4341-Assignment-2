import java.util.ArrayList;
import java.util.Random;

public class BinIndividual {

    int fitness = 0;

    ArrayList<BinGene> bins = new ArrayList<>();

    public BinIndividual(){
        bins.add(new BinGene());
        bins.add(new BinGene());
        bins.add(new BinGene());
        bins.add(new BinGene());
        fillBins(40);
        findFitness();
    }

    private ArrayList<Integer> fillBins(int size){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < size) {
            int random = randomGenerator.nextInt(size);
            if (!numbers.contains(random)) {
                numbers.add(random);
                bins.get(Math.floor(numbers.size()/10).add(.get(random));
            }
        }
        return numbers;
    }

    public void findFitness(){

    }


}
