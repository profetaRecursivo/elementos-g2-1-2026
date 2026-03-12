
public class Sitio
{
    private String nombre;
    private Punto ubicacion;
    public Sitio(String nombre, Punto ubicacion){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    
    @Override
    public boolean equals(Object o){
        boolean iguales = false;
        if(o instanceof Sitio){
            Sitio s = (Sitio)o;
            iguales = this.nombre.equals(s.nombre) && this.ubicacion.equals(s.ubicacion);
        }
        return iguales;
    }
}
