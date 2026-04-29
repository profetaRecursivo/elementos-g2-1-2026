package examenpp;

public class Segundo
{
    public int diaAhorro(int monto){
        int res = diaAhorro(1, 1, monto);
        return res;
    }
    private int diaAhorro(int dia, int ahorro, int monto){
        int res;
        if(ahorro >= monto){
            res = dia;
        }else{
            res = diaAhorro(dia + 1, ahorro + (dia+1), monto);
        }
        return res;
    }
}