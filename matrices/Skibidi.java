package matrices;
public class Skibidi
{
    public int buscar(int x, int y, int n){
        return buscar(x, y, n, 1, 1, 1, (int)Math.pow(4, n));
    }

    private int buscar(int x, int y, int n, int xesq, int yesq, int mini, int maxi){
        int buscado;
        if(n == 0){
            buscado = mini;
        }else{
            int cantidad = (int)Math.pow(4, n-1);
            int despl = 1<<(n-1);
            int xinia = xesq;
            int yinia = yesq;
            int xfina = xinia + despl - 1;
            int yfina = yinia + despl - 1;
            int xinib = xfina + 1;
            int yinib = yfina + 1;
            int xfinb = xinib + despl - 1;
            int yfinb = yinib + despl - 1;
            int xinic = xesq + despl;
            int yinic = yesq;
            int xfinc = xinic + despl - 1;
            int yfinc = yinic + despl - 1;
            int xinid = xesq;
            int yinid = yesq + despl;
            int xfind = xinid + despl - 1;
            int yfind = yinid + despl - 1;
            int miniA = mini;
            int maxiA = mini + cantidad - 1;
            int miniB = maxiA + 1;
            int maxiB = miniB + cantidad - 1;
            int miniC = maxiB + 1;
            int maxiC = miniC + cantidad - 1;
            int miniD = maxiC + 1;
            int maxiD = miniD + cantidad - 1;
            if(dentro(x, xinia, xfina) && dentro(y, yinia, yfina)){
                buscado = buscar(x, y, n-1, xinia, yinia, miniA, maxiA); 
            }else if(dentro(x, xinib, xfinb) && dentro(y, yinib, yfinb)){
                buscado = buscar(x, y, n-1, xinib, yinib, miniB, maxiB); 
            }else if(dentro(x, xinic, xfinc) && dentro(y, yinic, yfinc)){
                buscado = buscar(x, y, n-1, xinic, yinic, miniC, maxiC); 
            }else{
                buscado = buscar(x, y, n-1, xinid, yinid, miniD, maxiD);
            }
        }
        return buscado;
    }

    private boolean dentro(int x, int a, int b){
        return a<=x && x<=b;
    }
}
