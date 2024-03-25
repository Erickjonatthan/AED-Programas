package ordenadores;
public class OrdenarPorInsercao implements Ordenador{

    @Override
    public int[] ordene(int[] array) {

        int j;
        int chave;
        int i;

        for (j = 1; j < array.length; j++) {
            chave = array[j];
            for (i = j - 1; (i >= 0) && (array[i] > chave); i--) {
                array[i + 1] = array[i];
            }
            array[i + 1] = chave;
        }

        return array;
    }
    
}
