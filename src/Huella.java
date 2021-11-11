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
        if(h.getSenales().size() == this.getSenales().size()){
            isEqual = true;
            for(Senal s: senales){
                System.out.println("initial "+isEqual);
                System.out.println("compare "+h.getSenales().contains(s));
                isEqual = isEqual && h.getSenales().contains(s);
            }
        }else{
            isEqual = false;
        }
        System.out.println("final "+isEqual);
        return isEqual;
    }
    public ArrayList<Senal> getSenales(){
        return senales;
    }
}
