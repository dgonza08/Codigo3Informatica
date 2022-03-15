import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Practica1 {
    private static int SALIDA = 0;

    public static void main(String[] args) throws FileNotFoundException {
        File archivo = new File("datos_prueba.txt");
        Scanner sc = new Scanner(archivo);

        String cadena = "";
        int contadorSaltosLinea = -1;

        while (sc.hasNext()) {
            cadena += sc.nextLine();
            contadorSaltosLinea++;
        }

        float total = cadena.length();

        HashMap<Character, Float> mapa = new HashMap<Character, Float>();
        for (int j = 0; j < cadena.length(); j++) {
            Character caracter = cadena.charAt(j);
            Float contador = 0f;
            for (int k = 0; k < cadena.length(); k++) {
                if (caracter == cadena.charAt(k)) {
                    contador++;
                }
                mapa.put(caracter, contador);
            }
            if (caracter == ' ') {
                mapa.put(caracter, contador += (contadorSaltosLinea * 2));
            }
        }

        // CUESTIONARIO 1
        System.out.println("Alfabeto:");
        for(Character clave:mapa.keySet()){
            System.out.print(clave+" ");
        }

        System.out.println("\nMapa de caracteres: " + mapa + "\n");

        System.out.println("Total de caracteres: " + total + "\n");
        System.out.println("Saltos de linea: " + contadorSaltosLinea + "\n");

        // Frecuencia absoluta d
        System.out.println("La frecuencia absoluta de d es: " + mapa.get('d') + "\n");

        // Probabilidad de d
        System.out.println("La probabilidad de d es: " + mapa.get('d') / (total + (contadorSaltosLinea * 2)) + "\n");

        HashMap<Character, Float> mapaInformacion = new HashMap<Character, Float>();
        // Cantidad de informacion de los caracteres
        for (Character clave : mapa.keySet()) {
            float valor = mapa.get(clave);
            mapaInformacion.put(clave, -new Operaciones().log(valor / (total + (contadorSaltosLinea * 2)), 2));
        }

        System.out.println("Mapa de informacion: " + mapaInformacion + "\n");

        HashMap<Character, Float> mapaProbabilidadEmision = new HashMap<Character, Float>();
        for (Character clave : mapa.keySet()) {
            float valor = mapa.get(clave);
            mapaProbabilidadEmision.put(clave, valor / (total + (contadorSaltosLinea * 2)));
        }

        // Calculo de la entropia de la fuente
        float entropia = 0f;
        for (Character clave : mapaProbabilidadEmision.keySet()) {
            float probabilidadDeEmision = mapaProbabilidadEmision.get(clave);
            entropia += (probabilidadDeEmision * mapaInformacion.get(clave));
        }
        System.out.println("Entropia de la fuente: " + entropia + "\n");

        UserComparator comparator = new UserComparator(mapaProbabilidadEmision);
        Map<Character, Float> mapaOrdenado = new TreeMap<Character, Float>(comparator);

        for (Character clave : mapaProbabilidadEmision.keySet()) {
            Float valor = mapaProbabilidadEmision.get(clave);
            mapaOrdenado.put(clave, valor);
            System.out.println("Caracter: " + clave + " - Probabilidad emision: " + valor);
        }

        System.out.println("\nTamanyo del mapa ordenado: " + mapaOrdenado.size() + "\n");

        mapaOrdenado.forEach((clave, valor) -> {
            if (SALIDA < 4) {
                System.out.println(clave + " - Frecuencia: " + mapa.get(clave)
                        + " - Probabilidad de emision: " + valor);
            }
            SALIDA++;
        });

        sc.close();
    }
}