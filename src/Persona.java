import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Persona {
    private String nombre;
    private Huella huella;
    private int contPer;
    private int id = this.hashCode();
    private ArrayList<Login> logs = new ArrayList<>();
    Persona(String nombre, Huella h){
        this.nombre = nombre;
        this.huella = h;
    }
    public Huella getHuella(){
        return huella;
    }
    public void setNum(int n){
        contPer = n;

    }
    public String getName(){
        return nombre;
    }
    public ArrayList<Login> getLogs(){
        return logs;
    }
    public int getNum(){
        return contPer;
    }
    public int getId(){
        return id;
    }
    
}
