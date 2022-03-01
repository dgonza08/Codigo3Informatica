import java.util.List;

/**
 * Probar a ver si se puede hacer una lista de listas 
 * Creo que no es necesario hacer eso anterior
 * Quizas no haga falta crear esta clase tampoco
 */
public class Rama {
    private List<Nodos> listaNodos;
    private Huffman huffman;

    public Rama(Huffman huffman) {
        this.listaNodos = huffman.getListaNodos();
        this.huffman = huffman;
    }
    
}
