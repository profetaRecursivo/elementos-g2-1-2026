package matrices;
import java.util.Scanner;

public class SkibidiTable
{
    public long buscar(long x, long y, long n){
        long esqSupIzqX = 1, esqSupIzqY = 1;
        long miniElem = 1;
        long res = buscar(x, y, n, esqSupIzqX, esqSupIzqY, miniElem);
        return res;
    }

    private long buscar(long x, long y, long n, long esqSupIzqX, long esqSupIzqY, long miniElem){
        long res;
        if(n == 0){
            res = miniElem;
        }else{
            long dimension = (long)Math.pow(2, n-1);
            long cantidadPorSubMatriz = (long)(Math.pow(2, n-1)*Math.pow(2, n-1));
            //para A
            long esqSupXA = esqSupIzqX;
            long esqSupYA = esqSupIzqY;
            long esqInfDerXA = esqSupXA + dimension - 1;
            long esqInfDerYA = esqSupYA + dimension - 1;
            long minElemA = miniElem; 
            //para B
            long esqSupXB = esqSupIzqX + dimension;
            long esqSupYB = esqSupIzqY + dimension;
            long esqInfDerXB = esqSupXB + dimension - 1;
            long esqInfDerYB = esqSupYB + dimension - 1;
            long minElemB = minElemA + cantidadPorSubMatriz;
            //para C
            long esqSupXC = esqSupIzqX + dimension;
            long esqSupYC = esqSupIzqY;
            long esqInfDerXC = esqSupXC + dimension - 1;
            long esqInfDerYC = esqSupYC + dimension - 1;
            long minElemC = minElemB + cantidadPorSubMatriz;
            //para D
            long esqSupXD = esqSupIzqX;
            long esqSupYD = esqSupIzqY + dimension;
            long esqInfDerXD = esqSupXD + dimension - 1;
            long esqInfDerYD = esqSupYD + dimension - 1;
            long minElemD = minElemC + cantidadPorSubMatriz;
            if(esqSupXA <= x && x<= esqInfDerXA && esqSupYA <= y && y<= esqInfDerYA){
                res = buscar(x, y, n-1, esqSupXA, esqSupYA, minElemA);
            }else if(esqSupXB <= x && x<= esqInfDerXB && esqSupYB <= y && y<= esqInfDerYB){
                res = buscar(x, y, n-1, esqSupXB, esqSupYB, minElemB);
            }else if(esqSupXC <= x && x<= esqInfDerXC && esqSupYC <= y && y<= esqInfDerYC){
                res = buscar(x, y, n-1, esqSupXC, esqSupYC, minElemC);
            }else{
                res = buscar(x, y, n-1, esqSupXD, esqSupYD, minElemD);
            }
        }
        return res;
    }

    public Posicion buscar(long d, long n){
        long esqSupIzqX = 1, esqSupIzqY = 1;
        long minElem = 1;
        long maxElem = (long)(Math.pow(2, n) * Math.pow(2, n));
        Posicion res = buscarP(d, n, esqSupIzqX, esqSupIzqY, minElem, maxElem);
        return res;
    }

    private Posicion buscarP(long d, long n, long esqSupIzqX, long esqSupIzqY, long minElem, long maxElem){
        Posicion res;
        if(n == 0){
            res = new Posicion(esqSupIzqX, esqSupIzqY);
        }else{
            long dimension = (long)Math.pow(2, n-1);
            long cantidadPorSubMatriz = (long)(Math.pow(2, n-1)*Math.pow(2, n-1));
            //para A
            long esqSupXA = esqSupIzqX;
            long esqSupYA = esqSupIzqY;
            long minElemA = minElem; 
            long maxElemA = minElemA + cantidadPorSubMatriz - 1;
            //para B
            long esqSupXB = esqSupIzqX + dimension;
            long esqSupYB = esqSupIzqY + dimension;
            long minElemB = minElemA + cantidadPorSubMatriz;
            long maxElemB = minElemB + cantidadPorSubMatriz  - 1;
            //para C
            long esqSupXC = esqSupIzqX + dimension;
            long esqSupYC = esqSupIzqY;            
            long minElemC = minElemB + cantidadPorSubMatriz;
            long maxElemC = minElemC + cantidadPorSubMatriz - 1;
            //para D
            long esqSupXD = esqSupIzqX;
            long esqSupYD = esqSupIzqY + dimension;
            long minElemD = minElemC + cantidadPorSubMatriz;
            long maxElemD = minElemD + cantidadPorSubMatriz - 1;
            if(minElemA<= d && d<=maxElemA){
                res = buscarP(d, n-1, esqSupXA, esqSupYA, minElemA, maxElemA);
            }else if(minElemB<= d && d<=maxElemB){
                res = buscarP(d, n-1, esqSupXB, esqSupYB, minElemB, maxElemB);
            }else if(minElemC<= d && d<=maxElemC){
                res = buscarP(d, n-1, esqSupXC, esqSupYC, minElemC, maxElemC);
            }else{
                res = buscarP(d, n-1, esqSupXD, esqSupYD, minElemD, maxElemD);
            }
        }
        return res;
    }
    public static void main(String[] args){
        SkibidiTable solver = new SkibidiTable();
        Scanner sc = new Scanner(System.in);
        long testCases = sc.nextLong();
        for(long tc = 0; tc<testCases; tc++){
            long n = sc.nextLong();
            long q = sc.nextLong();
            for(long query = 0; query < q; query++){
                String tipo = sc.next();
                if(tipo.equals("->")){
                    long x = sc.nextLong();
                    long y = sc.nextLong();
                    System.out.println(solver.buscar(x, y, n));
                }else{
                    long d = sc.nextLong();
                    Posicion res = solver.buscar(d, n);
                    System.out.println(res.getX() + " " + res.getY());
                }
            }
        }
    }
    class Posicion
    {
        private long x;
        private long y;

        public Posicion(long x, long y){
            this.x = x;
            this.y = y;
        }

        public long getX(){
            return x;
        }

        public long getY(){
            return y;   
        }
    }
}