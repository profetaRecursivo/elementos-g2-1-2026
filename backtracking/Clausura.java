package backtracking;
import java.util.ArrayList;

public class Clausura
{
    public ArrayList<ArrayList<Integer>> clasura(int[] arr){
        //primero, declarar la promesa de respuesta
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        //Tener una solucion, sin completar
        ArrayList<Integer> actual = new ArrayList<Integer>();
        clausura(arr, res, actual, 0);
        return res;
    }
    private void clausura(int[] arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> actual, int i){
        if(i >= arr.length){
            res.add(foto(actual));
        }else{
            //tomar
            actual.add(arr[i]);
            clausura(arr, res, actual, i+1);
            //no tomar
            actual.remove(actual.size() - 1);
            clausura(arr, res, actual, i+1);
        }
    }
    
    private ArrayList<Integer> foto(ArrayList<Integer> original){
        ArrayList<Integer> copia = new ArrayList<Integer>();
        foto(original, copia, 0);
        return copia;
    }
    
    private void foto(ArrayList<Integer> original, ArrayList<Integer> copia, int i){
        if(i < original.size()){
            copia.add(original.get(i));
            foto(original, copia, i+1);
        }
    }
}
