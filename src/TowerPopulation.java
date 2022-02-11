import java.util.ArrayList;

public class TowerPopulation {
    int size;
    ArrayList<TowerIndividual> individuals = new ArrayList<>();
    ArrayList<TowerIndividual> children = new ArrayList<>();

    public TowerPopulation(int s){
        size = s;
    }

    public void generateIndividuals() {
        for (int i = 0; i < size; i++) {
            individuals.add(new TowerIndividual());
        }
    }

    public void findFitnesses(){
        for (int i = 0; i < individuals.size(); i++);
//            individuals.get(i).findFitness();
    }

    public  void cull(){
        int num = (int)Math.floor(individuals.size()/4);
        for (int i = 0; i < num; i++){
            individuals.remove(0);
        }
    }

    public void sortIndividuals() {
        // Outer loop
        for (int i = 0; i < individuals.size(); i++) {
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < individuals.size(); j++) {

                // Checking elements
                TowerIndividual temp;
                if (individuals.get(j).fitness < individuals.get(i).fitness) {

                    // Swapping
                    temp = individuals.get(i);
                    individuals.set(i, individuals.get(j));
                    individuals.set(j, temp);
                }
            }
        }
    }

    public void getProbabilites(){
        float cumulative = 0;
        float sum = getFitSum();
        for (int i = 0; i < individuals.size(); i++){
            cumulative += (individuals.get(i).fitness/sum);
            individuals.get(i).setCumProb(cumulative);
        }
    }

    private float getFitSum(){
        float sum = 0;
        for (TowerIndividual i : individuals){
            sum += i.fitness;
        }
        return sum;
    }
}
