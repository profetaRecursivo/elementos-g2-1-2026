package backtracking;
import java.util.ArrayList;

public class Reinas
{
    public ArrayList<char[][]> reinas(int n){
        ArrayList<char[][]> ans = new ArrayList<>();
        char [][] actual = new char[n][n];
        llenar(actual, 0, 0, ' ');
        reinas(0, 0, actual, ans);
        return ans;
    }
    private void llenar(char[][] mat, int  i, int j, char x){
        if(i < mat.length){
            if(j < mat.length){
                mat[i][j] = x;
                llenar(mat, i, j+1, x);
            }else{
                llenar(mat, i+1, 0, x);
            }
        }
    }
    private boolean puedoColocarla(int i, int j, char[][] mat){
        boolean arriba = caminar(i, j, mat, -1, 0);
        boolean abajo = caminar(i, j, mat, +1, 0);
        boolean izq = caminar(i, j, mat, 0, -1);
        boolean der = caminar(i, j, mat, 0, +1);
        boolean ne = caminar(i, j, mat, -1, +1);
        boolean se = caminar(i, j, mat, +1, +1);
        boolean so = caminar(i, j, mat, +1, -1);
        boolean no = caminar(i, j, mat, -1, -1);
        return !arriba && !abajo && !izq && !der && !ne && !se && !so && !no;
    }
    private boolean esValida(int i, int j, int n){
        return i>=0 && j>=0 && j<n && i < n; 
    }
    private boolean caminar(int i, int j, char[][] mat, int di, int dj){
        boolean hay = false;
        if(esValida(i, j, mat.length)){
            if(mat[i][j] != ' '){
                hay = true;
            }else{
                hay = caminar(i+di, j + dj, mat, di, dj);
            }
        }
        return hay;
    }
    private boolean construiUnaSolucion(char[][] actual){
        return contarReinas(0, 0, actual) == actual.length;
    }
    private int contarReinas(int i, int j, char[][] actual){
        int ans = 0;
        if(i<actual.length){
            if(j < actual.length){
                if(actual[i][j] == 'R'){
                    ans = 1;
                }
                ans+=contarReinas(i, j+1, actual);
            }else{
                ans = contarReinas(i+1, 0, actual);
            }
        }
        return ans;
    }
    private void reinas(int i, int j, char[][] actual, ArrayList<char[][]> ans){
        if(i<actual.length){
            if(j<actual.length){//verificacion de validez de posicion
                //pregunto, la puedo colocar aqui?
                if(puedoColocarla(i,j, actual)){
                    //si es que puedo colocarla la coloco
                    actual[i][j] = 'R';
                    if(construiUnaSolucion(actual)){//pregunto si tengo una respuesta valida
                        ans.add(foto(actual));//le saco foto
                    }
                    reinas(i+1, 0, actual, ans);//y voy a buscar mas soluciones partiendo de que coloque esa reina
                    //despues de mandar a buscar una solucion, la quito, para decir no la coloque
                    actual[i][j] = ' ';
                }
                reinas(i, j+1, actual, ans);//busco una solucion sin haber colocado a esa reina
            }else{
                reinas(i+1, 0, actual, ans);//esto es solo para recorrer la matriz en caso de salirme de las columnas
            }
        }
    }
    
    private char[][] foto(char[][] mat){
        char[][] copia = new char[mat.length][mat.length];
        copiar(mat, copia, 0, 0);
        return copia;
    }
    private void copiar(char[][] mat, char[][] copia, int i, int j){
        if(i < mat.length){
            if(j < mat.length){
                copia[i][j] = mat[i][j];
                copiar(mat, copia, i, j+1);
            }else{
                copiar(mat, copia, i+1, 0);
            }
        }
    }
}
