import java.util.ArrayList;

public class Ruta
{
    private ArrayList<Sitio> sitios;
    private Empresa quienLaOferta;
    
    public Ruta(ArrayList<Sitio> sitios, Empresa quienLaOferta){
        this.sitios = sitios;
        this.quienLaOferta = quienLaOferta;
    }
}
