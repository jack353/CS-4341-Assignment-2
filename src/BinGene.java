import java.util.ArrayList;

public class BinGene {

    ArrayList<Float> bin = new ArrayList<>();

    public void add(float n){
        bin.add(n);
    }

    public float get(int n){
        return bin.get(n);
    }
}
