package analiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Analizador
 */
public class Analizador {


    public int[] acha_sequencia(double[] probs, int[] valores){

        //cria um arraylist para armazenar a sequencia
        ArrayList<Integer> sequencia = new ArrayList<>();

        //cria um hashmap para armazenar os valores e suas probabilidades
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < probs.length; i++) {
            map.put(probs[i], valores[i]);
        }

        //cria hashmpap para armazenar o valor maximo e minimo
        Map<Double, int[]> mapa_prob = new HashMap<>();
        for (int i = 0; i < probs.length; i++) {
            mapa_prob.put(probs[i], new int[]{valores[i], i});
        }

        double prob_max = -1;
        int[] index_prob_max = null;
        
        //procura o valor maximo
        for (Map.Entry<Double, int[]> entry : mapa_prob.entrySet()) {
            if (entry.getKey() > prob_max) {
                prob_max = entry.getKey();
                index_prob_max = entry.getValue();
            }
        }

        double prob_min = Double.MAX_VALUE;
        int[] index_prob_min = null;
        
        //procura o valor minimo
        for (Map.Entry<Double, int[]> entry : mapa_prob.entrySet()) {
            if (entry.getKey() < prob_min) {
                prob_min = entry.getKey();
                index_prob_min = entry.getValue();
            }
        }
    
        int valor_max = -1;
        int[] index_valor_max = null;

        //procura o valor maximo
        for (Map.Entry<Double, int[]> entry : mapa_prob.entrySet()) {
            // Ignora os prêmios já selecionados
            if (entry.getValue()[1] == index_prob_max[1] || entry.getValue()[1] == index_prob_min[1]) {
                continue;
            }

            if (entry.getValue()[0] > valor_max) {
                valor_max = entry.getValue()[0];
                index_valor_max = entry.getValue();
            }
        }

        int[] indicesToAdd;
        
        // Adiciona os índices na sequência
        if (index_valor_max != null && index_valor_max[1] != index_prob_min[1]) {
            indicesToAdd = new int[]{index_prob_max[1], index_valor_max[1], index_prob_min[1]};
        } else {
            indicesToAdd = new int[]{index_prob_max[1], index_prob_min[1]};
        }


        for (int index : indicesToAdd) {
            if (!sequencia.contains(index)) {
                sequencia.add(index);
            }
        }

        // Adiciona os índices que faltam
        if (sequencia.size() < probs.length) {
            for (int i = 0; i < probs.length; i++) {
                if (!sequencia.contains(i)) {
                    sequencia.add(sequencia.size() - 1, i);
                    break;
                }
            }
        }
       
        //retorna a sequencia em um array de inteiros
        return sequencia.stream().mapToInt(i -> i).toArray();
    }
}
