package examenpp;

public class Primer
{
    public int cantCamiones(int cajas, int capacidad){
        int res;
        if(cajas <= capacidad){
            res = 1;
        }else{
            res = cantCamiones(cajas/2, capacidad) + 
            cantCamiones(cajas - cajas/2, capacidad);
        }
        return res;
    }
}