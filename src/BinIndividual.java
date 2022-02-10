import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BinIndividual {

    float fitness = 0;
    double cumProb = 0;

    ArrayList<BinGene> bins = new ArrayList<>();

    public BinIndividual(){
        bins.add(new BinGene());
        bins.add(new BinGene());
        bins.add(new BinGene());
        bins.add(new BinGene());
        fillBins(40);
    }

    public BinIndividual(ArrayList<BinGene> g){
        bins = g;
        findFitness();
    }

    ArrayList<Integer> fillBins(int size){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < size) {
            int random = randomGenerator.nextInt(size);
            if (!numbers.contains(random)) {
                numbers.add(random);
                bins.get((int)Math.floor(numbers.size()/10)).add(Main.input[random]);
            }
        }
        return numbers;
    }

    void findFitness(){
        fitness = calcBin1() + calcBin2() + calcBin3();
    }

    float calcBin1(){
        float total = 1;
        for (int i = 0; i < 10; i++){
            total = total * bins.get(0).get(i);
        }
        return total;
    }

    float calcBin2(){
        float total = 0;
        for (int i = 0; i < 10; i++){
            total = total + bins.get(1).get(i);
        }
        return total;
    }

    float calcBin3(){
        return(Collections.max(bins.get(2).bin) - Collections.min(bins.get(2).bin));
    }

    void setCumProb(float n){
        cumProb = n;
    }


}