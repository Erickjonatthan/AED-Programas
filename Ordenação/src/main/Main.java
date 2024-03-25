import ordenadores.OrdenarPorInsercao;
import ordenadores.OrdenarPorMerge;
import ordenadores.OrdenarPorSelecao;

public class Main {
    public static void main(String[] args) {
        int[] array = { 5, 3, 2, 4, 7, 1, 0, 6 };
        OrdenarPorInsercao o = new OrdenarPorInsercao();
        int[] arrayOrdenado = o.ordene(array);
        for (int i = 0; i < arrayOrdenado.length; i++) {
            System.out.println(arrayOrdenado[i]);
        }
        System.out.println("-----------");
        OrdenarPorSelecao s = new OrdenarPorSelecao();
        int[] arrayOrdenado2 = s.ordene(array);
        for (int i = 0; i < arrayOrdenado2.length; i++) {
            System.out.println(arrayOrdenado2[i]);
        }
        System.out.println("-----------");
        OrdenarPorMerge m = new OrdenarPorMerge();
        int[] arrayOrdenado3 = m.ordene(array);
        for (int i = 0; i < arrayOrdenado3.length; i++) {
            System.out.println(arrayOrdenado3[i]);
        }
        
    }
}
