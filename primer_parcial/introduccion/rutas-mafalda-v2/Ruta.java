import java.util.ArrayList;

public class Ruta
{
    private ArrayList<Sitio> sitios;
    private Empresa quienLaOferta;
    
    public Ruta(ArrayList<Sitio> sitios, Empresa quienLaOferta){
        this.sitios = sitios;
        this.quienLaOferta = quienLaOferta;
    }
    
    public ArrayList<Sitio> getSitios(){
        return sitios;
    }
    
    public void setSitios(ArrayList<Sitio> nuevo){
        this.sitios = nuevo;
    }
}
