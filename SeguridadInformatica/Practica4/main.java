import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Operaciones op = new Operaciones();
        File f = new File("./datos.txt");
        Scanner sc = new Scanner(f);

        String linea = "";
        while (sc.hasNextLine()) {
            linea = sc.nextLine();
        }

        String[] datos = linea.split("");

        HashMap<String, Long> mapa = new HashMap<String, Long>();
        for (int j = 0; j < datos.length; j++) {
            String caracter = datos[j];
            long valor = j;
            for (int k = 0; k < datos.length; k++) {
                mapa.put(caracter, valor);
            }
        }

        double longMinima = Math.ceil(op.log(mapa.size(), 2)); // se redondea hacia arriba

        System.out.println("Longitud minima: " + longMinima);

        HashMap<String, String> mapaBinario= new HashMap<String, String>();

        for (String key : mapa.keySet()) {
            mapaBinario.put(key, op.toBinario(mapa.get(key)));
        }

        for (String key : mapaBinario.keySet()) {
            double anyadir = longMinima - mapaBinario.get(key).length();
            for (int i = 0; i < anyadir; i++) {
                mapaBinario.put(key, "0" + mapaBinario.get(key));
            }
        }

        for(String key : mapaBinario.keySet()){
            System.out.println(key + ": " + mapaBinario.get(key));
        }

        String cadena = "c!";
        String[] cadenaSplit = cadena.split("");

        String codificacion = "";

        for (int i = 0; i < cadenaSplit.length; i++) {
            for(String key: mapaBinario.keySet()){
                if (key.equals(cadenaSplit[i])) {
                    codificacion += mapaBinario.get(key);
                } 
            }
        }
        System.out.println("Codificacion lineal: " + codificacion);
    }
}