package matrices;

public class Trifuerza
{
    public char[][] dibujar(int nivel){
        char[][] mat;
        if(nivel == 1){
            mat = new char[2][2];
            mat[0][0] = mat[0][1] = mat[1][1] = '*';
            mat[1][0] = ' ';
        }else{
            char[][] A = dibujar(nivel-1);
            char[][] B = dibujar(nivel-1);
            char[][] C = espacios(nivel-1);
            char[][] D = dibujar(nivel-1);
            mat = juntar(A, B, C, D);
        }
        return mat;
    }

    private char[][] espacios(int nivel){
        char[][] mat;
        if(nivel == 1){
            mat = new char[2][2];
            mat[0][0] = mat[0][1] = mat[1][0] = mat[1][1] = ' ';
        }else{
            char[][] a = espacios(nivel-1);
            char[][] b = espacios(nivel-1);
            char[][] c = espacios(nivel-1);
            char[][] d = espacios(nivel-1);
            mat = juntar(a, b, c, d);
        }
        return mat;
    }

    private char[][] juntar(char[][]a, char[][] b, char[][] c, char[][] d){
        char[][] mat = new char[a.length*2][a.length*2];
        int mitad = a.length;
        copiar(a, mat,0, 0, mitad-1, mitad-1, 0, 0, 0, 0);
        copiar(b, mat, 0, mitad, mitad-1, mitad*2-1, 0, 0, 0, mitad);
        copiar(c, mat, mitad, 0, mitad*2-1, mitad-1,0,0, mitad, 0);
        copiar(d, mat, mitad, mitad, mitad*2-1, mitad*2-1,0,0, mitad, mitad);
        return mat;
    }

    private void copiar(char[][] quien, char[][]donde,
    int fini, int cini, int ffin, int cfin, 
    int i, int j, int p, int q){
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
