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
     * @return void
     */
    public void recorrerHuffman() {
        Operaciones op = new Operaciones();
        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista = op.rellenarListaFrecuenciasEnterosNodos(listaNodos);
        int posicion = -1;
        int minimo1 = lista.get(0);
        int contador = 0;

        while (lista.size() != 1) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) < minimo1) {
                    minimo1 = lista.get(i);
                    posicion = i;
                }
            }

            if (contador == 0) {
                LinkedList<Integer> primerCodigo1 = new LinkedList<Integer>();
                this.listaNodos.get(posicion).setCodigo(primerCodigo1);
            }

            LinkedList<Integer> codigo1 = this.listaNodos.get(posicion).getCodigo();
            if (codigo1.size() == 0) {
                LinkedList<Integer> codigo1SiVacio = new LinkedList<Integer>();
                codigo1SiVacio.add(1);
                this.listaNodos.get(posicion).setCodigo(codigo1SiVacio);
            } else {
                codigo1.add(1);
                this.listaNodos.get(posicion).setCodigo(codigo1);
            }
            lista.remove(posicion);

            int minimo2 = lista.get(0);
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j) < minimo2) {
                    minimo2 = lista.get(j);
                    posicion = j;
                }
            }

            if (contador == 0) {
                LinkedList<Integer> primerCodigo2 = new LinkedList<Integer>();
                this.listaNodos.get(posicion).setCodigo(primerCodigo2);
            }
            
            LinkedList<Integer> codigo2 = this.listaNodos.get(posicion).getCodigo();
            if (codigo2.size() == 0) {
                LinkedList<Integer> codigo2SiVacio = new LinkedList<Integer>();
                codigo2SiVacio.add(0);
                this.listaNodos.get(posicion).setCodigo(codigo2SiVacio);
            } else {
                codigo2.add(0);
                this.listaNodos.get(posicion).setCodigo(codigo2);
            }
            lista.remove(posicion);

            lista.add(minimo1 + minimo2);
            contador++;
        }

        for (int k = 0; k < listaNodos.size(); k++) {
            op.switchCode(listaNodos.get(k));
        }
    }
}
