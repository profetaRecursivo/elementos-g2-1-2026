
public class Admin
{
    private Ruta[] rutas;
    private Mapa mapa;//correctos
    
    public Admin(Ruta[] rutas, Mapa mapa){
        this.rutas = rutas;
        this.mapa = mapa;
    }
    
    public boolean validarRuta(Ruta r){
        Sitio[] sitiosEnElSalar = mapa.getSitios();
        for(Sitio s:sitiosEnElSalar){
            
        }
    }
}
