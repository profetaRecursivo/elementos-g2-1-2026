package backtracking;
import java.util.ArrayList;


/**
 * Write a description of class Impresor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Impresora
{
    public void imprimir(ArrayList<char[][]> lista){
        for(char[][] mat:lista){
            for(int i = 0; i<mat.length; i++){
                for(int j = 0; j<mat.length; j++){
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("===========================================\n");
        }
        System.out.println(lista.size());
    }
    
    public void imprimirLista(ArrayList<ArrayList<Integer>> lista){
        for(ArrayList<Integer> x:lista){
            for(int y:x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
