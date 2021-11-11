public class Persona {
    private String nombre;
    private Huella huella;
    private int contPer;
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
}
