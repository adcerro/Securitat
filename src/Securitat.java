import java.time.LocalDateTime;
import java.util.ArrayList;
public class Securitat {
    private ArrayList<Persona> personas = new ArrayList<>();
    private ArrayList<Login> logs = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Securitat securitat = new Securitat();

//Creación de usuario Pedro exitoso

Huella tempHuella = new Huella(new Senal(1,2,SenaHuella.ARCO_LLANO),new Senal(3,4,SenaHuella.BIFURCACION));

securitat.addPersona("Pedro", tempHuella);

//Creación de usuario Pablo no exitoso, usa huella de Pedro que ya existe

securitat.addPersona("Pablo", tempHuella);

//Creación de usuario Pablo exitoso

tempHuella = new Huella(new Senal(2,4,SenaHuella.CONO),new Senal(7,2,SenaHuella.DELTA),new Senal(6,4,SenaHuella.BIFURCACION));

securitat.addPersona("Pablo", tempHuella);

//Nuevo usuario con la misma huella de Pablo, con señales en desorden

tempHuella = new Huella(new Senal(7,2,SenaHuella.DELTA),new Senal(6,4,SenaHuella.BIFURCACION),new Senal(2,4,SenaHuella.CONO));

securitat.addPersona("Camilo", tempHuella);

//Creacion de administrador Pilar

tempHuella = new Huella(new Senal(5,2,SenaHuella.ATRAVESADO),new Senal(2,8,SenaHuella.LAZO_LLANO),new Senal(6,4,SenaHuella.BIFURCACION));

securitat.addAdministrador("Pilar", tempHuella,"HolaMundo!");

///Creacion de administrador Patricio con la misma huella de Pilar

securitat.addAdministrador("Patricio", tempHuella,"BlahBlahBlah");

//Creacion de administrador Patricio

tempHuella = new Huella(new Senal(2,2,SenaHuella.ATRAVESADO),new Senal(3,8,SenaHuella.PORO),new Senal(6,4,SenaHuella.BIFURCACION));

securitat.addAdministrador("Patricio", tempHuella,"BlahBlahBlah");

LocalDateTime d = LocalDateTime.now();

//Pedro con huella de Patricia

securitat.addLogin(d, securitat.getPersona(0), securitat.getPersona(3).getHuella()); //Nula

//Pedro con su huella

securitat.addLogin(d, securitat.getPersona(0), securitat.getPersona(0).getHuella()); //Exitosa Pedro

//Pilar como usuaria, pero como es administradora, necesita password

securitat.addLogin(d, securitat.getPersona(2), securitat.getPersona(2).getHuella()); // No password

//Pilar como administradora

securitat.addLogin(d, securitat.getPersona(2), securitat.getPersona(2).getHuella(), "HolaMundo!");

//Pilar como administradora, con password, pero con huella errada

securitat.addLogin(d, securitat.getPersona(2), securitat.getPersona(1).getHuella(), "HolaMundo!");

//Patricio como administrador con problemas de password

securitat.addLogin(d, securitat.getPersona(3), securitat.getPersona(3).getHuella(), "BlahBlahBlah!");

//Patricio como administrador

securitat.addLogin(d, securitat.getPersona(3), securitat.getPersona(3).getHuella(), "BlahBlahBlah");

//Patricio como administrador con huella errada

securitat.addLogin(d, securitat.getPersona(3), securitat.getPersona(2).getHuella(), "BlahBlahBlah");

//Patricio como administrador con huella errada

securitat.addLogin(d, securitat.getPersona(3), securitat.getPersona(2).getHuella(), "BlahBlahBlah");

//Patricio como administradora con huella errada

securitat.addLogin(d, securitat.getPersona(3), securitat.getPersona(2).getHuella(), "BlahBlahBlah");

securitat.calcMayorProblemaEntreAdministradores(LoginState.PROBLEMA_HUELLA);

securitat.calcMayorProblemaEntreAdministradores(LoginState.PROBLEMA_PASSWORD);

securitat.calcMayorProblemaEntreAdministradores(LoginState.NO_PASSWORD);
    }  
    public void addPersona(String n, Huella h){
        boolean unique=true;
        for(Persona p: personas){
            if(p.getHuella().isEqualTo(h)){
                unique = false;
            }
        }
        if (unique == false){
        System.out.println("Huella ya existe! Usuario "+n+" no fue creado");}
        else{
        personas.add(new Persona(n, h));
        System.out.println("Creacion exitosa! Usuario "+n);
    }
        
    }
    public void addAdministrador(String n, Huella h, String p){
        boolean uniqueA=true;
        for(Persona pe: personas){
            if(pe.getHuella().isEqualTo(h)){
                uniqueA = false;
            }
        }
        if (uniqueA == false){
            System.out.println("Huella ya existe! Administrador "+n+" no fue creado");
        }else{
            personas.add(new Administrador(n, h, p));
            System.out.println("Creación exitosa! Administrador "+n);
        }
    }
    public Persona getPersona(int i){
        try {
            return personas.get(i);
        } catch (Exception e) {
           return new Persona(null, new Huella(null, null));
        }
    }
    public void addLogin(LocalDateTime d, Persona p, Huella h, String pass){
       Login  l =new Login(d, p, h, pass);
       if(l.isValid()){
           logs.add(l);
           System.out.println("Login de "+p.getName()+" exitoso!");
       }else{
        System.out.println("Login de "+p.getName()+" no exitoso -"+l.state());
       }
    }
    public void addLogin(LocalDateTime d, Persona p, Huella h){
        Login  l =new Login(d, p, h);
       if(l.isValid()){
           logs.add(l);
           System.out.println("Login de "+p.getName()+" exitoso!");
       }else{
            System.out.println("Login de "+p.getName()+" no exitoso -"+l.state());
       }
    }
    public void calcMayorProblemaEntreAdministradores(LoginState log){
        for(Login l: logs){

        }
    }
}
