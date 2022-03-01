import java.util.ArrayList;
import java.util.List;

public class Operaciones {
    public Operaciones(){

    }

    public List<Integer> rellenarListaFrecuenciasEnteros(List<Float> lista){
        List<Integer> listaFrecuenciasEnteros = new ArrayList<Integer>();
        for (Float f : lista) {
            listaFrecuenciasEnteros.add((int) (f * 100));
        }
        return listaFrecuenciasEnteros;
    }
}
