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
        /*para cada Sitio dentro de una ruta, tenemos que saber
         si es un sitio valido, en caso de no serlo, DEBEMOS
         eliminarlo de la ruta*/
        boolean rutaValida = true;
        ArrayList<Sitio> sitiosAVerificar = r.getSitios();
        for(Sitio sitio:sitiosAVerificar){
            //ahora, como se que es valido?
            // si el sitio existe dentro de los sitios en el Salar
            if(!existeDentroDelSalar(sitio)){
                //entonces lo tengo que eliminar de la ruta, como lo hago?
                rutaValida = false;
            }
        }
        return rutaValida;
    }
    
    
    
}
