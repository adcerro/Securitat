import java.util.ArrayList;

public class Huella {
    private ArrayList<Senal>  senales= new ArrayList<>();
    Huella(Senal a, Senal b, Senal c){
        this.senales.add(a);
        this.senales.add(b);
        this.senales.add(c);
    }
    Huella(Senal a, Senal b){
        this.senales.add(a);
        this.senales.add(b);
    }
    Huella(ArrayList<Senal> s){
        this.senales = s;
    }
    public boolean isEqualTo(Huella h){
        boolean isEqual;
        boolean match;
        int iterator;
        if(h.getSenales().size() == this.getSenales().size()){
            isEqual = true;
            for(Senal s: senales){
                match = false;
                iterator =0;
                while(iterator<h.getSenales().size()&& match==false){
                    if(h.getSenales().get(iterator).matches(s)){
                        match = true;
                    }
                    iterator = iterator +1;
                }
                isEqual = isEqual && match;
            }
        }else{
            isEqual = false;
        }
        return isEqual;
    }
    public ArrayList<Senal> getSenales(){
        return senales;
    }
}
