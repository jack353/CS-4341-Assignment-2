import java.util.ArrayList;

public class BinPopulation {
    int popSize;
    int size;
    ArrayList<BinIndividual> individuals = new ArrayList<>();
    ArrayList<BinIndividual> children = new ArrayList<>();



    //move all this to main method
    public BinPopulation(int s){
        size = s;
        generateIndividuals();
        findFitnesses();
        sortIndividuals();
        cull();
        getProbabilites();
        haveKids();
    }

    private void generateIndividuals() {
        for (int i = 0; i < individuals.size(); i++) {
            individuals.add(new BinIndividual());
        }
    }

    void findFitnesses(){
        for (BinIndividual i : individuals)
            i.findFitness();
    }

    private void cull(){
        int num = (int)Math.floor(individuals.size()/4);
        for (int i = 0; i < num; i++){
            individuals.remove(0);
        }
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

    void haveKids(){
        addFittestTwo();

        while(children.size() < size){
            addTwoChildren();
        }
        individuals = children;
        children = new ArrayList<>();
    }

    void addFittestTwo() {
        children.add(individuals.get(individuals.size()-1));
        children.add(individuals.get(individuals.size()-2));
    }

    void addTwoChildren(){
        BinIndividual p1 = getParent();
        BinIndividual p2 = getParent();

        BinIndividual c1 = new BinIndividual();
        BinIndividual c2 = new BinIndividual();

        //c1.bins.get(0).setBin(p1.bins.get(0).subList(0,5).addAll(p2.bins.get(0).subList(5,10)));
    }

    BinIndividual getParent(){
        double p = Math.random();

        for (BinIndividual i : individuals){
            if (i.cumProb > p)
                return(i);
        }
        return(null);
    }

    /*ArrayList<Float> getNewBin(BinIndividual p1, BinIndividual p2, int bin){

    }*/


}