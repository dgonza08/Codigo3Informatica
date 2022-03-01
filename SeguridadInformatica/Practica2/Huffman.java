import java.util.List;

/**
 * Aqui se realizaran todas las operaciones necesarias para la realizacion del
 * algoritmo de Huffman
 */
public class Huffman {
    private int tipoRecorrido; // Si es binario 2, si es ternario 3 (0 equivaldria a nada)
    private List<Nodos> listaNodos;

    public Huffman(List<Nodos> listaNodos, int tipoRecorrido) {
        this.tipoRecorrido = tipoRecorrido;
        this.listaNodos = listaNodos;
    }

    public List<Nodos> getListaNodos() {
        return listaNodos;
    }

    public void setListaNodos(List<Nodos> listaNodos) {
        this.listaNodos = listaNodos;
    }

    public int getTipoRecorrido() {
        return tipoRecorrido;
    }

    public void setTipoRecorrido(int tipoRecorrido) {
        this.tipoRecorrido = tipoRecorrido;
    }

    public void recorrerHuffman(){

    }
}
