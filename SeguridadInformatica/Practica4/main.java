import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class main{
    public static void main(String[] args) throws FileNotFoundException {
        Operaciones op = new Operaciones();
        File f = new File("./datos.txt");
        Scanner sc = new Scanner(f);

        String linea = "";
        while(sc.hasNextLine()){
            linea = sc.nextLine();
        }

        String[] datos = linea.split("");
        for (int i = 0; i < datos.length; i++) {
            System.out.println(datos[i]);
        }

        HashMap<String, Float> mapa = new HashMap<String, Float>();
        for (int j = 0; j < datos.length; j++) {
            String caracter = datos[j];
            Float contador = 0f;
            for (int k = 0; k < datos.length; k++) {
                if (caracter == datos[k]) {
                    contador++;
                }
                mapa.put(caracter, contador);
            }
        }

    }
}