package matrices;
public class Zerpenski
{
    public char[][] dibujar(int n){
        char[][] mat;
        if(n == 1){
            mat = new char[2][2];
            mat[0][0] = '*';
            mat[0][1] = '*';
            mat[1][1] = '*';
            mat[1][0] = ' ';
        }else{
            char[][] a = dibujar(n-1);
            char[][] b = dibujar(n-1);
            char[][] c = espacios(n-1);
            char[][] d = dibujar(n-1);
            mat = juntar(a, b, c, d);
        }
        return mat;
    }

    private char[][] espacios(int n){
        char[][] mat;
        if(n == 1){
            mat = new char[2][2];
            mat[0][0] = mat[0][1] = mat[1][0] = mat[1][1] = ' ';
            //solo con datos primitivos
        }else{
            char[][] a = espacios(n-1);
            char[][] b = espacios(n-1);
            char[][] c = espacios(n-1);
            char[][] d = espacios(n-1);
            mat = juntar(a, b, c, d);
        }
        return mat;
    }

    private char[][] juntar(char[][] a, char[][] b, char[][] c, char[][] d){
        int k = d.length;
        char[][] mat = new char[2*k][2*k];
        copiar(a, mat, 0, 0, k-1, k-1, 0, 0, 0, 0);
        copiar(b, mat, 0, k, k-1, 2*k - 1, 0, 0, 0, k);
        copiar(c, mat, k, 0, 2*k-1, k-1, 0, 0, k, 0);
        copiar(d, mat, k, k, 2*k-1, 2*k-1, 0, 0, k, k);
        return mat;
    }
    //for(int i = 0, p = fini; i<quien.length; i++, p++){
    //        for(int j = 0, q = cini; j<quien.length; j++, q++){
    //           donde[p][q] = quien[i][j];
    //        }
    
    //    }
    private void copiar(char[][] quien, char[][] donde, 
    int fini, int cini, int ffin, int cfin, int i, int j, int p, int q){
        if(i < quien.length){
            if(j < quien.length){
                donde[p][q] = quien[i][j];
                copiar(quien, donde, fini, cini, ffin, cfin, i, j+1, p, q+1);
            }else{
                copiar(quien, donde, fini, cini, ffin, cfin, i+1, 0, p+1, cini);
            }
        }        
    }
}
