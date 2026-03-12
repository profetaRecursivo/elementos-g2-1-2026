import java.util.ArrayList;

public class Admin
{
    private Ruta[] rutas;
    private Sitio[] sitiosEnElSalar;
    
    public Admin(Ruta[] rutas, Sitio[] sitiosEnElSalar){
        this.rutas = rutas;
        this.sitiosEnElSalar = sitiosEnElSalar;
    }
    
    public boolean validarRuta(Ruta r){
        boolean rutaValida = true;
        ArrayList<Sitio> sitiosAVerificar = r.getSitios();
        ArrayList<Sitio> nuevos = new ArrayList<Sitio>();
        for(Sitio sitio:sitiosAVerificar){
            if(existeDentroDelSalar(sitio)){
                nuevos.add(sitio);
            }else{
                rutaValida = false;
            }
        }
        r.setSitios(nuevos);
        return rutaValida;
    }
    private boolean existeDentroDelSalar(Sitio s){
        boolean existe = false;
        for(Sitio sitio:sitiosEnElSalar){
            if(sitio.equals(s)){
                existe = true;
            }
        }
        return existe;
    }
    
    public Ruta rutaDeseada(ArrayList<Sitio> sitiosDeseados){
        Ruta rutaDeseada = null;
        for(Ruta r:rutas){
            if(pasaPorTodosLosSitios(r, sitiosDeseados)){
                rutaDeseada = r;
            }
        }
        return rutaDeseada;
    }
    
    private boolean pasaPorTodosLosSitios(Ruta r, ArrayList<Sitio> sitiosDeseados){
        boolean pasa = true;
        ArrayList<Sitio> sitiosDeLaRuta = r.getSitios();
        for(Sitio s:sitiosDeseados){
            if(!sitiosDeLaRuta.contains(s)){
               pasa = false;
            }
        }
        return pasa;
    }
}
    

