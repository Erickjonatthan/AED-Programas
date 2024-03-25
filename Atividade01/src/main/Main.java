import java.util.*;

import analiz.Analizador;

public class Main {
    public static void main(String[] args) {

        Analizador analizador = new Analizador();

        double[] probabilities = { 0.5, 0.9, 0.2, 0.6 };
        int[] prizes = { 3, 1, 4, 1 };

        // cria um map para associar as probabilidades aos prêmios
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < probabilities.length; i++) {
            map.put(probabilities[i], prizes[i]);
        }

        int[] resultado = analizador.acha_sequencia(probabilities, prizes);

        // cria um novo map para associar as probabilidades aos prêmios, mas na ordem do
        // resultado
        Map<Double, Integer> new_map = new LinkedHashMap<>();
        for (int i : resultado) {
            double key = probabilities[i];
            new_map.put(key, map.get(key));
        }

        // cria dois arrays para passar para a função calcularFormula
        double[] new_probabilities = new_map.keySet().stream().mapToDouble(Double::doubleValue).toArray();
        int[] new_prizes = new_map.values().stream().mapToInt(Integer::intValue).toArray();

        double valor = calcularFormula(new_probabilities, new_prizes);

        System.out.println("Resultado: " + Arrays.toString(resultado));
        System.out.println("Valor: " + valor);
    }

    public static double calcularFormula(double[] p, int[] d) {
        double resultado = 0;
        double somaD = 0;
        double produtoP = p[0];

        for (int i = 1; i < p.length; i++) {
            somaD += d[i - 1];
            double termoAtual = produtoP * (1 - p[i]) * somaD;
            resultado += termoAtual;
            produtoP *= p[i];
        }

        somaD += d[p.length - 1];
        resultado += produtoP * somaD;

        return resultado;
    }
}