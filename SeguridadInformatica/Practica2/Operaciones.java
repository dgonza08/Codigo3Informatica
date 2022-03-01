import java.util.ArrayList;
import java.util.List;

public class Operaciones {
    public Operaciones() {

    }

    public List<Integer> rellenarListaFrecuenciasEnteros(List<Float> lista) {
        List<Integer> listaFrecuenciasEnteros = new ArrayList<Integer>();
        for (Float f : lista) {
            listaFrecuenciasEnteros.add((int) (f * 100));
        }
        return listaFrecuenciasEnteros;
    }

    public List<Nodos> rellenarListaNodos(List<Integer> listaFrecuencias, List<Float> listaProbabilidades) {
        List<Nodos> listaNodos = new ArrayList<Nodos>();
        
        // Como lo hemos rellenado de la misma manera no hace falta hacer un doble bucle
        // esta ordenado igual, y tiene el mismo tamanyo
        for (int i = 0; i < listaFrecuencias.size(); i++) {
            Nodos nodo = new Nodos(listaFrecuencias.get(i), listaProbabilidades.get(i));
            listaNodos.add(nodo);
        }
        return listaNodos;
    }
}
