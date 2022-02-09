import java.io.File;

public class Population {
    int popSize;
    Individual[] individuals = new Individual[10];

    public void generateIndividuals(int size) {
        for (int i = 0; i < individuals.length; i++) {
            individuals[i] = new Individual();
        }
    }

    public Individual findFittest(int[] nums) {
        int maxFit = Integer.MIN_VALUE;
        int ind = 0;
        for (int i = 0; i < individuals.length; i++) {
            individuals[i].go(nums);
            if (maxFit <= individuals[i].fitness) {
                maxFit = individuals[i].fitness;
                i = i;
            }
        }
        return individuals[ind];
    }
}