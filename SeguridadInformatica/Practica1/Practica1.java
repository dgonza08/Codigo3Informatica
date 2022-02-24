import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Practica1 {
    public static void main(String[] args) throws FileNotFoundException {
        File archivo = new File("/home/drox/repositorios/Codigo3Informatica/SeguridadInformatica/Practica1/datos_1.txt");
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
            if(caracter == ' '){
                mapa.put(caracter, contador += (contadorSaltosLinea * 2));
            }
        }

        System.out.println("Mapa de caracteres: " + mapa + "\n");


        System.out.println("Total de caracteres: " + total + "\n");
        System.out.println("Saltos de linea: " + contadorSaltosLinea);
        
        // Frecuencia absoluta d
        System.out.println("La frecuendia absoluta de d es: " + mapa.get('d'));

        // Probabilidad de d
        System.out.println("La probabilidad de d es: " + mapa.get('d') / (total + (contadorSaltosLinea * 2)));

        // Calculo de la entropia de los caracteres

        sc.close();
    }
}