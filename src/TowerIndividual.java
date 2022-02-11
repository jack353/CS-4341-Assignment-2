import java.util.ArrayList;

public class TowerIndividual {

    public float fitness = 0;
    int totalCost = 0;
    double cumProb = 0;



    public TowerIndividual(){
        //bins.add(new BinGene());

        //fillBins(40);
    }


    void setCumProb(float n){
        cumProb = n;
    }

    void setFitness(float f){
        fitness = f;
    }

}
