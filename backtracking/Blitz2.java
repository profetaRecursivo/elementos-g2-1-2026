package backtracking;
import java.util.ArrayList;

public class Blitz2
{
    //gates
    public boolean sePuedeFormar(String palabra, char[][] mat){
        ArrayList<String> todas = new ArrayList<String>();
        String actual = "";
        formar(mat, todas, actual, 0, 0);
        //filtro
        boolean res = false;
        for(String s:todas){
            if(s.equals(palabra)){
                res = true;
            }
        }
        return res;
    }

    private void formar(char[][] mat, ArrayList<String> todas, String actual, int i, int j){
        if(i < mat.length){
            if(j < mat.length){
                //puedo colocar la letra de la posicion i j
                // a la cadena actual
                if(mat[i][j] != '$'){//no lo visite
                    //significa puedo tomar;
                    
                    String anterior = foto(actual);
                    char ant = mat[i][j];
                    actual+=mat[i][j];
                    mat[i][j] = '$';
                    formar(mat, todas, actual, i-1, j);
                    formar(mat, todas, actual, i+1, j);
                    formar(mat, todas, actual, i, j-1);
                    formar(mat, todas, actual, i, j+1);
                    formar(mat, todas, actual, i-1, j+1);
                    formar(mat, todas, actual, i+1, j+1);
                    formar(mat, todas, actual, i+1, j-1);
                    formar(mat, todas, actual, i-1, j-1);
                    actual = anterior;
                    mat[i][j] = ant;
                }
            }
        }
    }
}
//para obetener recien todas las soluciones se debe llamar 
//a formar desde 0, 0, luego 0, 1, luego 0, 2 y asi sobre toda la matriz mat
