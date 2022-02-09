import java.util.ArrayList;

public class BinPopulation {
    int popSize;
    ArrayList<BinIndividual> individuals = new ArrayList<>();

    public BinPopulation(int size){
        generateIndividuals(size);
        sortIndividuals();
        cull();
        getProbabilites();
    }

    private void generateIndividuals(int size) {
        for (int i = 0; i < individuals.size(); i++) {
            individuals.add(new BinIndividual());
        }
    }

    private void cull(){
        int num = (int)Math.floor(individuals.size()/4);
        for (int i = 0; i < num; i++){
            individuals.remove(0);
        }
    }

    public BinIndividual findFittest() {
        float maxFit = Integer.MIN_VALUE;
        BinIndividual max = individuals.get(0);
        for (BinIndividual i : individuals){
            if (maxFit <= i.fitness){
                maxFit = i.fitness;
                max = i;
            }
        }
        return max;
    }

    private void sortIndividuals() {
        // Outer loop
        for (int i = 0; i < individuals.size(); i++) {
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < individuals.size(); j++) {

                // Checking elements
                BinIndividual temp;
                if (individuals.get(j).fitness < individuals.get(i).fitness) {

                    // Swapping
                    temp = individuals.get(i);
                    individuals.set(i, individuals.get(j));
                    individuals.set(j, temp);
                }
            }
        }
    }

    private void getProbabilites(){
        float sum = getFitSum();
        float cumulative = 0;
        for (int i = 0; i < individuals.size(); i++){
            cumulative += (individuals.get(i).fitness/sum);
            individuals.get(i).setCumProb(cumulative);
        }
    }

    private float getFitSum(){
        float sum = 0;
        for (int i = 0; i < individuals.size(); i++){
            sum += individuals.get(i).fitness;
        }
        return sum;
    }
}