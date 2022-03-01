import java.util.List;

/**
 * Clase encargade de realizar todas las operaciones necesarias para la
 * realizacion del
 * algoritmo de Huffman
 * 
 * @author David Gonzalez Alvarez
 * @version 1.0
 * 
 */
public class Huffman {
    private int tipoRecorrido; // Si es binario 2, si es ternario 3 (0 equivaldria a nada)
    private List<Nodos> listaNodos;

    /**
     * Constructor de la clase Huffman
     * 
     * @param tipoRecorrido
     * @param listaNodos
     */
    public Huffman(List<Nodos> listaNodos, int tipoRecorrido) {
        this.tipoRecorrido = tipoRecorrido;
        this.listaNodos = listaNodos;
    }

    /**
     * Metodo que nos devuelve la lista de nodos del arbol
     * 
     * @return listaNodos
     */
    public List<Nodos> getListaNodos() {
        return listaNodos;
    }

    /**
     * Metodo que nos permite cambiar la lista de nodos del arbol
     * 
     * @param listaNodos
     */
    public void setListaNodos(List<Nodos> listaNodos) {
        this.listaNodos = listaNodos;
    }

    /**
     * Metodo que nos permite obtener el tipo de recorrido que seguiremos
     * 
     * @return tipoRecorrido
     */
    public int getTipoRecorrido() {
        return tipoRecorrido;
    }

    /**
     * Metodo que nos permite cambiar el tipo de recorrido que seguiremos
     * 
     * @param tipoRecorrido
     */
    public void setTipoRecorrido(int tipoRecorrido) {
        this.tipoRecorrido = tipoRecorrido;
    }

    /**
     * Se encarga de la realizacion del algoritmo de Huffman recorriendo
     * el arbol entero.
     * 
     * @return void
     */
    public void recorrerHuffman() {

    }
}
