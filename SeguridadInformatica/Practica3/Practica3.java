import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Dividiremos el intervalo de 0 a 1 en n intervalos de igual longitud.
 */
public class Practica3{
    public static void main(String[] args) throws FileNotFoundException {
        File archivo = new File("CosaMisteriosa.txt");
        Scanner sc = new Scanner(archivo);
        int contadorSaltosLinea = 0;
        String fuenteInicial = "";
        while (sc.hasNext()) {
            fuenteInicial += sc.nextLine();
            contadorSaltosLinea++;
        }

        HashMap<Character, Float> mapa = new HashMap<Character, Float>();
        for (int j = 0; j < fuenteInicial.length(); j++) {
            Character caracter = fuenteInicial.charAt(j);
            Float contador = 0f;
            for (int k = 0; k < fuenteInicial.length(); k++) {
                if (caracter == fuenteInicial.charAt(k)) {
                    contador++;
                }
                mapa.put(caracter, contador);
            }
            if (caracter == ' ') {
                mapa.put(caracter, contador += (contadorSaltosLinea * 2));
            }
        }

        //String fuenteInicial = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ .";
        String[] fuenteSplit = fuenteInicial.split("");
        List<String> fuente = new LinkedList<>();

        Operaciones op = new Operaciones();
        op.rellenarLista(fuenteSplit, fuente);

        System.out.println("Tamanyo de la fuente: " + fuente.size());

        HashMap<String, Integer> mapa1 = op.frecuencia(fuente);

        double n = mapa1.size();

        HashMap<String, Double> segmentos = op.dividirSegmentos(mapa1, n);

        for (String key : segmentos.keySet()) {
            System.out.println(key + ": " + segmentos.get(key));
        }

        // Calculo de la entropia
        // Primera parte: Crear mapa de informacion y de probabilidad de emision 
        HashMap<String, Double> mapaInformacion = new HashMap<>();
        // Cantidad de informacion de los caracteres
        for (String clave : mapa1.keySet()) {
            double valor = mapa1.get(clave);
            mapaInformacion.put(clave, -new Operaciones().log(valor / (n), 2));
        }
        
        HashMap<String, Double> mapaProbabilidadEmision = new HashMap<>();
        for (String clave : mapa1.keySet()) {
            double valor = mapa1.get(clave);
            mapaProbabilidadEmision.put(clave, valor / fuente.size());
        }

        // Segunda parte: Calcular la entropia a traves del mapa de probabilidad de emision
        double entropia = 0f;
        for (String clave : mapaProbabilidadEmision.keySet()) {
            double probabilidadDeEmision = mapaProbabilidadEmision.get(clave);
            entropia += (probabilidadDeEmision * mapaInformacion.get(clave));
        }
        System.out.println("Entropia de la fuente: " + entropia + "\n");

        sc.close();
    }
}