package Memoria;
public class Robot
{
    public void imprimir(int[][] mat){
        
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void algo(){
        int[][] mat = new int[3][3];
        modificar(mat);
        int x = 10;
        modificar(x);
        System.out.println(x);
        imprimir(mat);
    }
    public void modificar(int[][] grilla){
        grilla[1][1] = 1;
    }
    public void modificar(int x){
        x = 1000;
    }
    
    
    
    public void reasignacion(){
        int[][] mat = new int[3][3];
        mat[1][1] = 1;
        modificarR(mat);
        imprimir(mat);
    }
    public void modificarR(int[][] mat){
        mat = new int[100][100];
    }
    
    
    public void superficial(){
        int[][] mat = new int[3][3];
        mat[1][1] = 10;
        int[][] otro = copiar(mat);
        otro[2][2] = 9999;
        imprimir(mat);
    }
    
    public int[][] copiar(int mat[][]){
        int res[][] = new int[3][3];
        for(;;){
             for(;;){
                res[i][j] = mat[i][j];    
            }   
        }
        return res;
    }
}