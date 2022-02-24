import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Practica1 {
    public static void main(String[] args) throws FileNotFoundException {
        File archivo = new File("/home/drox/repositorios/Codigo3Informatica/SeguridadInformatica/Practica1/datos_1Original.txt");
        Scanner sc = new Scanner(archivo);

        String cadena = "";

        while (sc.hasNext()) {
            cadena += sc.nextLine();
        }

        float total = cadena.length();

        int contadorSaltosLinea = 0;
        while(sc.hasNextLine()) {
            contadorSaltosLinea++;
            sc.nextLine();
        }

        HashMap<Character, Float> mapa = new HashMap<Character, Float>();
        for (int j = 0; j < cadena.length(); j++) {
            Character caracter = cadena.charAt(j);
            Float contador = 0f;
            for (int k = 0; k < cadena.length(); k++) {
                if (caracter == cadena.charAt(k)) {
                    contador++;
                } else if (caracter == ' '+' ') {
                    contador += 2;
                }
                mapa.put(caracter, contador);
            }
        }

        System.out.println("Mapa es: \n" + mapa + "\n");

        // Frecuencia absoluta d
        System.out.println("La frecuendia absoluta de d es: " + mapa.get('d'));

        // Probabilidad de d
        System.out.println("La probabilidad de d es: " + mapa.get('d') / (total + (contadorSaltosLinea * 2)));

        sc.close();
    }
}