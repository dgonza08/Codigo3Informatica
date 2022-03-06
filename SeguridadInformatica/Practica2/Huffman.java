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
    // private int tipoRecorrido; // Si es binario 2, si es ternario 3 (0
    // equivaldria a nada)
    private LinkedList<Nodos> listaNodos;
    private Nodos raizReal;

    /**
     * Constructor de la clase Huffman
     * 
     * @param listaNodos
     */
    public Huffman(LinkedList<Nodos> listaNodos) {
        this.listaNodos = listaNodos;
    }

    /**
     * Metodo que devuelve la raiz real del arbol
     * 
     * @return raizReal
     */
    public Nodos getRaizReal() {
        return this.raizReal;
    }

    /**
     * Metodo que devuelve la raiz real del arbol
     * 
     * @param raizReal
     */
    public void setRaizReal(Nodos raizReal) {
        this.raizReal = raizReal;
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
     * Se encarga de la realizacion del algoritmo de Huffman recorriendo
     * el arbol entero.
     * 
     * ! PROBLEMAS EN LA ASIGNACION DEL CODIGO DE CADA UNO DE LOS NODOS PRINICIPALES
     * ? QUIZAS EL PROBLEMA ES POR HACERLO RECURSIVAMENTE
     * 
     * @return void
     */
    public void recorrerHuffman(Nodos raiz) {
        if (raiz == null) {
            return;
        }

        if (raiz.getCodigo() == null) {
            raiz.setCodigo(new LinkedList<>());
        }
        
        if (raiz.getIzquierda() != null) {
            LinkedList<Integer> listaNuevaCodigosIzquierda = raiz.getCodigo();
            listaNuevaCodigosIzquierda.add(1);
            raiz.getIzquierda().setCodigo(listaNuevaCodigosIzquierda);
            recorrerHuffman(raiz.getIzquierda());
        }
        
        if (raiz.getDerecha() != null) {
            LinkedList<Integer> listaNuevaCodigosDerecha = raiz.getCodigo();
            listaNuevaCodigosDerecha.add(0);
            raiz.getDerecha().setCodigo(listaNuevaCodigosDerecha);
            recorrerHuffman(raiz.getDerecha());
        }
    }

    /**
     * Metodo que crea el arbol que vamos a recorrer posteriormente
     * ulitizo el algoritmo de huffman para crearlo
     * 
     * @return Nodo final del arbol
     */
    public Nodos crearArbol() {
        Operaciones op = new Operaciones();
        LinkedList<Nodos> listaNodosComprobar = new LinkedList<Nodos>();
        op.rellenarListaNodosComprobar(listaNodosComprobar, this.listaNodos);
        Nodos ultimoNodo = new Nodos();
        LinkedList<Nodos> listaNodosFinal = new LinkedList<Nodos>();
        op.rellenarListaNodosComprobar(listaNodosFinal, this.listaNodos); // Aqui se guardarian todos los nodos del
                                                                          // arbol

        while (listaNodosComprobar.size() > 1) {

            Nodos minimo1 = op.encontrarMinimo(listaNodosComprobar);
            listaNodosComprobar.remove(minimo1);
            Nodos minimo2 = op.encontrarMinimo(listaNodosComprobar);
            listaNodosComprobar.remove(minimo2);

            Nodos nuevoNodo = new Nodos();
            nuevoNodo.setFrecuencia(minimo1.getFrecuencia() + minimo2.getFrecuencia());
            listaNodosFinal.add(nuevoNodo);
            listaNodosComprobar.add(nuevoNodo);

            if (minimo1.getFrecuencia() < minimo2.getFrecuencia()) {
                Nodos auxiliar = new Nodos();
                auxiliar = minimo1;
                minimo1 = minimo2;
                minimo2 = auxiliar;
            }

            nuevoNodo.setIzquierda(minimo1);
            nuevoNodo.setDerecha(minimo2);
            ultimoNodo = nuevoNodo;
        }
        return ultimoNodo;
    }
}
