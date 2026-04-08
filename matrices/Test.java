package matrices;

public class Test
{
    public static void main(String[] args){
        Trifuerza t = new Trifuerza();
        char[][] mat = t.dibujar(5);
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
