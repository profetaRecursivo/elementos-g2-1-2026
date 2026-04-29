package examenpp;
import java.util.ArrayList;

public class Tercer
{
    public ArrayList<String> todosLosPal(String cad){
        ArrayList<String> res = new ArrayList<String>();
        todosLosPal(cad, 0, 0, res);
        return res;
    }
    private void todosLosPal(String cad, int i, int j, 
    ArrayList<String> res){
        if(i < cad.length()){
            if(j < cad.length()){
                String subCad = subCadena(cad, i, j);
                if(esPal(subCad)){
                    if(!res.contains(subCad)){
                        res.add(subCad);
                    }
                }
                todosLosPal(cad, i, j+1, res);
            }else{
                todosLosPal(cad, i+1, i+1, res);
            }
        }    
    }
    
    private String subCadena(String cad, int i, int j){
        String res;
        if(i <= j){
            res = cad.charAt(i) + subCadena(cad, i+1, j);
        }else{
            res= "";
        }
        return res;
    }
    
    private boolean esPal(String cad){
        boolean res = esPal(cad, 0, cad.length() - 1);
        return res;
    }
    private boolean esPal(String cad, int izq, int der){
        boolean es = true;
        if(izq<=der){
            if(cad.charAt(izq) != cad.charAt(der)){
                es = false;
            }else{
                es = esPal(cad, izq+1, der-1);
            }
        }
        return es;
    }
}