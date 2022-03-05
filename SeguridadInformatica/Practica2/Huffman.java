import java.util.LinkedList;

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
    private LinkedList<Nodos> listaNodos;

    /**
     * Constructor de la clase Huffman
     * 
     * @param tipoRecorrido
     * @param listaNodos
     */
    public Huffman(LinkedList<Nodos> listaNodos, int tipoRecorrido) {
        this.tipoRecorrido = tipoRecorrido;
        this.listaNodos = listaNodos;
    }

    /**
     * Metodo que nos devuelve la lista de nodos del arbol
     * 
     * @return listaNodos
     */
    public LinkedList<Nodos> getListaNodos() {
        return listaNodos;
    }

    /**
     * Metodo que nos permite cambiar la lista de nodos del arbol
     * 
     * @param listaNodos
     */
    public void setListaNodos(LinkedList<Nodos> listaNodos) {
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
     * PROBLEMAS EN EL DISEÑO DEL ALGORITMO CON LA POSICION DE LAS LISTAS
     * 
     * @return void
     */
    public void recorrerHuffman(Nodos raiz) {
        if (raiz == null) {
            return;
        }
        LinkedList<Integer> listaNuevaCodigos = raiz.getCodigo();
        listaNuevaCodigos.add(1);
        raiz.getIzquierda().setCodigo(listaNuevaCodigos);
        recorrerHuffman(raiz.getIzquierda());

        listaNuevaCodigos = raiz.getCodigo();
        listaNuevaCodigos.add(0);
        raiz.getDerecha().setCodigo(listaNuevaCodigos);
        recorrerHuffman(raiz.getDerecha());
    }

    public Nodos crearArbol(){
        Operaciones op = new Operaciones();
        LinkedList<Nodos> listaNodosComprobar = new LinkedList<Nodos>();
        Nodos ultimoNodo = new Nodos();
        LinkedList<Nodos> listaNodosFinal = new LinkedList<Nodos>();
        listaNodosFinal = this.listaNodos; // Aqui se guardarian todos los nodos del arbol

        while (listaNodosComprobar.size() > 1){
            if(listaNodosComprobar.size() == 0){
                listaNodosComprobar = this.listaNodos;
            }

            Nodos minimo1 = op.encontrarMinimo(listaNodosComprobar);
            listaNodosComprobar.remove(minimo1);
            Nodos minimo2 = op.encontrarMinimo(listaNodosComprobar);
            listaNodosComprobar.remove(minimo2);

            Nodos nuevoNodo = new Nodos(minimo1.getFrecuencia() + minimo2.getFrecuencia());
            listaNodosFinal.add(nuevoNodo);
            listaNodosComprobar.add(nuevoNodo);

            nuevoNodo.setIzquierda(minimo1);
            nuevoNodo.setDerecha(minimo2);

            ultimoNodo = nuevoNodo;
        }
        return ultimoNodo;
    }
}
