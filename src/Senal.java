public class Senal {
    private int x;
    private int y;
    private SenaHuella senal;
    Senal(int x, int y, SenaHuella s){
        this.x = x;
        this.y = y;
        this.senal = s;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public SenaHuella getSenal(){
        return senal;
    }
    public boolean matches(Senal s){
        if(x == s.getX()&& y == s.getY()&& senal.equals(s.getSenal())){
            return true;
        }else{
            return false;
        }
        
    }
}
