import java.util.ArrayList;

public class BinPopulation {
    int popSize;
    ArrayList<BinIndividual> individuals = new ArrayList<>();

    public void generateIndividuals(int size) {
        for (int i = 0; i < individuals.size(); i++) {
            individuals.add(new BinIndividual());
        }
    }

    public BinIndividual findFittest() {
        int maxFit = Integer.MIN_VALUE;
        BinIndividual max = individuals.get(0);
        for (BinIndividual i : individuals){
            if (maxFit <= i.fitness){
                maxFit = i.fitness;
                max = i;
            }
        }
        return max;
    }
}