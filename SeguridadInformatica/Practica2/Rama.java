import java.util.List;

/**
 * Clase encargada de realizar todas las operaciones referentes a los caminos
 * que se seguirian en el arbol del algoritmo de Huffman
 * 
 * Probar a ver si se puede hacer una lista de listas
 * Creo que no es necesario hacer eso anterior
 * Quizas no haga falta crear esta clase tampoco
 * 
 * @author David Gonzalez Alvarez
 * @version 1.0
 * 
 */
public class Rama {
    private List<Nodos> listaNodos;
    private Huffman huffman;

    /**
     * Constructor de la clase Rama
     * 
     * @param huffman
     */
    public Rama(Huffman huffman) {
        this.listaNodos = huffman.getListaNodos();
        this.huffman = huffman;
    }

    /**
     * Metodo que nos devuelve el camino que seguiremos en el arbol
     * 
     * @return listaNodos del camino seguido
     */
    public List<Nodos> getListaNodos() {
        return listaNodos;
    }

    /**
     * Metodo que nos permite cambiar la lista de nodos que seguiremos
     * 
     * @param listaNodos
     */
    public void setListaNodos(List<Nodos> listaNodos) {
        this.listaNodos = listaNodos;
    }

    /**
     * Metodo que nos permite obtener el objeto Huffman donde realizaremos
     * las operaciones
     * 
     * @param huffman
     */
    public Huffman getHuffman() {
        return huffman;
    }

    /**
     * Metodo que nos permite cambiar el objeto Huffman donde realizaremos
     * las operaciones
     * 
     * @param huffman
     */
    public void setHuffman(Huffman huffman) {
        this.huffman = huffman;
    }
}
