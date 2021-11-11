import java.time.LocalDateTime;

public class Login{
    private LocalDateTime date;
    private String password;
    private Persona persona;
    private Boolean valid;
    private LoginState state;
    Login(LocalDateTime d, Persona p,Huella h, String pass){
        this.date = d;
        this.password = pass;
        this.persona = p;
        if(p.getHuella().isEqualTo(h)){
            if(p instanceof Administrador ){
                if(((Administrador)p).getPassword() != pass){
                    this.valid = true;
                }
                else{
                    this.valid = false;
                    this.state = LoginState.PROBLEMA_PASSWORD;
                }
            }else{
            this.valid = false;
            this.state = LoginState.EXTRA_PASSWORD;
            }
        }else{
            this.valid = false;
            this.state = LoginState.PROBLEMA_HUELLA;
        }
    }
    Login(LocalDateTime d, Persona p,Huella h){
        this.date = d;
        this.persona = p;
        if(p.getHuella().isEqualTo(h)){
            this.valid = true;
            this.state = LoginState.EXITOSO;
        }else{
            this.valid = false;
            this.state = LoginState.PROBLEMA_HUELLA;
        }
    }
    public boolean isValid(){
        return valid;
    }
}