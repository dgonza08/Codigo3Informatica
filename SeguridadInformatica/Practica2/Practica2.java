import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author David Gonzalez Alvarez
 *
 *         Intentar separar la implementacion de la vista y la vista de la
 *         logica
 * 
 */
public class Practica2 {
    public static void main(String[] args) throws FileNotFoundException {
        File archivo = new File("datos_2.txt");
        Scanner sc = new Scanner(archivo);

        // ! PARA EL EJERCICIO 1
        List<Float> listaProbabilidades = new ArrayList<Float>();
        listaProbabilidades.add(0.3f);
        listaProbabilidades.add(0.2f);
        listaProbabilidades.add(0.1f);
        listaProbabilidades.add(0.1f);
        listaProbabilidades.add(0.05f);
        listaProbabilidades.add(0.05f);
        listaProbabilidades.add(0.05f);
        listaProbabilidades.add(0.05f);
        listaProbabilidades.add(0.05f);
        listaProbabilidades.add(0.05f);

        Operaciones operaciones = new Operaciones();
        List<Integer> listaFrecuencias = operaciones.rellenarListaFrecuenciasEnteros(listaProbabilidades);

        JOptionPane.showMessageDialog(null, listaFrecuencias,
                "Lista probabilidades enteros",
                JOptionPane.INFORMATION_MESSAGE);

        // ? A partir de aqui ya habra que empezar a hacer Huffman
        // * A traves de una variable saber si es binario o ternario

        List<Nodos> listaNodos = operaciones.rellenarListaNodos(listaFrecuencias, listaProbabilidades);

        Huffman huffman = new Huffman(listaNodos, 2);

        // ! PARA EL EJERCICIO 2
        List<Integer> listaFrecuencias2 = new ArrayList<Integer>();
        listaFrecuencias.add(27);
        listaFrecuencias.add(16);
        listaFrecuencias.add(4);
        listaFrecuencias.add(56);
        listaFrecuencias.add(22);
        listaFrecuencias.add(2);
        listaFrecuencias.add(78);
        listaFrecuencias.add(45);
        listaFrecuencias.add(36);
        listaFrecuencias.add(13);
        listaFrecuencias.add(12);
        listaFrecuencias.add(7);

        // ! PARA EL EJERCICIO 3
        int contadorSaltosLinea = -1;
        String cadena = "";

        while (sc.hasNext()) {
            cadena += sc.nextLine();
            contadorSaltosLinea++;
        }

        for (int i = 0; i < cadena.length(); i++) {
            System.out.print(cadena.charAt(i));
        }

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

    }
}