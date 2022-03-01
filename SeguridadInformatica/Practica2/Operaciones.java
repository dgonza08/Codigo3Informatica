import java.util.LinkedList;
import java.util.List;

/**
 * Clase encargada de realizar las operaciones que no tengan que ver
 * directamente
 * con el algoritmo de Huffman
 * 
 * @author David Gonzalez Alvarez
 * @version 1.0
 */
public class Operaciones {
    public Operaciones() {

    }

    /**
     * Cambiamos la lista de probabilidades que nos dan por frecuencias
     * en enteros simples, multiplicando la probabilidad que nos dan
     * por 100
     * 
     * @param lista
     * @return lista de frecuencias enteras
     */
    public List<Integer> rellenarListaFrecuenciasEnteros(List<Float> lista) {
        List<Integer> listaFrecuenciasEnteros = new LinkedList<Integer>();
        for (Float f : lista) {
            listaFrecuenciasEnteros.add((int) (f * 100));
        }
        return listaFrecuenciasEnteros;
    }

    /**
     * Cambiamos la lista de nodos que nos dan por frecuencias
     * en enteros simples
     * 
     * @param lista Nodos
     * @return lista de frecuencias enteras
     */
    public List<Integer> rellenarListaFrecuenciasEnterosNodos(List<Nodos> lista) {
        List<Integer> listaFrecuenciasEnteros = new LinkedList<Integer>();
        for (Nodos n : lista) {
            listaFrecuenciasEnteros.add((n.getFrecuencia()));
        }
        return listaFrecuenciasEnteros;
    }

    /**
     * Rellena la lista con cada uno de los nodos del arbol que queremos
     * crear para aplicar Huffman
     * 
     * @param listaFrecuencias
     * @param listaProbabilidades
     * @return lista de cada uno de los nodos del arbol
     */
    public List<Nodos> rellenarListaNodos(List<Integer> listaFrecuencias, List<Float> listaProbabilidades) {
        List<Nodos> listaNodos = new LinkedList<Nodos>();

        // Como lo hemos rellenado de la misma manera no hace falta hacer un doble bucle
        // esta ordenado igual, y tiene el mismo tamanyo
        for (int i = 0; i < listaFrecuencias.size(); i++) {
            Nodos nodo = new Nodos(listaFrecuencias.get(i), listaProbabilidades.get(i));
            listaNodos.add(nodo);
        }
        return listaNodos;
    }
}
