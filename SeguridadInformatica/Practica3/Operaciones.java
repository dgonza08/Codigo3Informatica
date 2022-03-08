import java.util.HashMap;
import java.util.List;

public class Operaciones {
    public Operaciones() {
    }

    public void rellenarLista(String[] fuenteSplit, List<String> fuente) {
        for (int i = 0; i < fuenteSplit.length; i++) {
            fuente.add(fuenteSplit[i]);
        }
    }

    public HashMap<String, Integer> frecuencia(List<String> fuente) {
        HashMap<String, Integer> frecuencias = new HashMap<>();
        for (int i = 0; i < fuente.size(); i++) {
            if (frecuencias.containsKey(fuente.get(i))) {
                frecuencias.put(fuente.get(i), frecuencias.get(fuente.get(i)) + 1);
            } else {
                frecuencias.put(fuente.get(i), 1);
            }
        }
        return frecuencias;
    }

    public HashMap<String, Double> dividirSegmentos(HashMap<String, Integer> mapa, int n) {
        HashMap<String, Double> segmentos = new HashMap<>();
        double tamanyoIntervalo = (double) 1 / n;
        double aux = 0.0;

        for (String key : mapa.keySet()) {
            segmentos.put(key, aux);
            aux = segmentos.get(key) + tamanyoIntervalo;
        }
        return segmentos;
    }
}
