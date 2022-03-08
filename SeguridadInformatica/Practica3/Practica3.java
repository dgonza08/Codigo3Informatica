import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Dividiremos el intervalo de 0 a 1 en n intervalos de igual longitud.
 */
public class Practica3{
    public static void main(String[] args) {
        String fuenteInicial = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ .";
        String[] fuenteSplit = fuenteInicial.split("");
        List<String> fuente = new LinkedList<>();

        Operaciones op = new Operaciones();
        op.rellenarLista(fuenteSplit, fuente);

        HashMap<String, Integer> mapa = op.frecuencia(fuente);

        for (String key : mapa.keySet()) {
            System.out.println(key + ": " + mapa.get(key));
        }

        int n = mapa.size();
        System.out.println("\nN: " + n + "\n");

        HashMap<String, Double> segmentos = op.dividirSegmentos(mapa, n);

        for (String key : segmentos.keySet()) {
            System.out.println(key + ": " + segmentos.get(key));
        }
    }
}