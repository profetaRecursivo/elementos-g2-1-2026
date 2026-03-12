
public class Punto
{
    private int x;
    private int y;
    
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o){
        boolean iguales = false;
        if(o instanceof Punto){
            Punto p = (Punto)o;
            iguales = this.x == p.x && this.y == p.y;
        }
        return iguales;
    }
}
