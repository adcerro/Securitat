public class Administrador extends Persona{
    private String password;
    Administrador(String nombre, Huella h, String p){
        super(nombre, h);
        this.password = p;
    }
    public String getPassword(){
        return this.password;
    }
}
