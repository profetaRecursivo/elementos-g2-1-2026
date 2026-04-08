package matrices;


public class Prueba
{
    public static void main(String[] args){
        Zerpenski z = new Zerpenski();
        char[][] mat = z.dibujar(5);
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
