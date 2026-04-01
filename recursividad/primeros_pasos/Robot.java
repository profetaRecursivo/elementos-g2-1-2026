package primeros_pasos;
import java.util.ArrayList;

public class Robot
{
    public String vista(int nivel){
        String res;
        if(nivel == 1){
            res = "(-.-)";
        }else{
            res = "(-." + vista(nivel-1) + ".-)"; 
        }
        return res;
    }
    private boolean esLetra(char c){
        boolean esMayuscula = 'A' <= c && c<='Z';
        boolean esMinuscula = 'a' <= c && c<='z';
        boolean esLetra = esMayuscula || esMinuscula;
        return esLetra;
    }
    public ArrayList<String> separarIterativo(String cad){
        ArrayList<String> palabras = new ArrayList<String>();
        String actual = "";
        for(int i = 0; i<cad.length(); i++){
            if(esLetra(cad.charAt(i))){
                actual+=cad.charAt(i);
            }else{
                palabras.add(actual);
                actual = "";
            }
        }
        palabras.add(actual);
        return palabras;
    }
    public ArrayList<String> separar(String cad){
        ArrayList<String> separado = separar(0, "", new ArrayList<String>(), cad);
        return separado;
    }
    
    public ArrayList<String> separar(int i, String actual, ArrayList<String> palabras, String cad){
        if(!(i<cad.length())){
            palabras.add(actual);
        }else{
            if(esLetra(cad.charAt(i))){
                actual+=cad.charAt(i);
            }else{
                palabras.add(actual);
                actual = "";
            }
            separar(i+1, actual, palabras, cad);
        }
        return palabras;
    }
}
