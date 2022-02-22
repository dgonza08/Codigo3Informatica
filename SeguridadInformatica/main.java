import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        File archivo = new File("/home/drox/repositorios/Codigo3Informatica/SeguridadInformatica/datos_1.txt");
        Scanner sc = new Scanner(archivo);

        String cadena = "";

        while (sc.hasNext()) {
            cadena += sc.nextLine();
        }

        float total = cadena.length();

        HashMap<Character, Float> mapa = new HashMap<Character, Float>();
        for (int j = 0; j < cadena.length(); j++) {
            Character caracter = cadena.charAt(j);
            Float contador = 0f;
            for (int k = 0; k < cadena.length(); k++) {
                if (caracter == cadena.charAt(k)) {
                    contador++;
                } else if (caracter == '\n') {
                    contador += 2;
                }
                mapa.put(caracter, contador);
            }
        }

        // Frecuencia absoluta d
        System.out.println("La frecuendia absoluta de d es: " + mapa.get('d'));
        
        //Probabilidad de d
        System.out.println("La probabilidad de d es: " + mapa.get('d') / total);

        sc.close();
    }
}