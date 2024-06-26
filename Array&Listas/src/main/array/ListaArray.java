package array;

import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar{

    private int[] array;
    private int indice_fim;

    public ListaArray() {
        array = new int[1];
        indice_fim = 0;
    }

    @Override
    public boolean buscaElemento(int valor) {
        for (int i = 0; i < indice_fim; i++) {
            if(array[i] == valor)
                return true;
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        for (int i = 0; i < indice_fim; i++) {
            if(i == valor)
                return array[i];
        }
        return -1;
    }

    @Override
    public int minimo() {
        int minimo = array[0];
        for (int i = 0; i < indice_fim; i++) {
            if(array[i] < minimo)
                minimo = array[i];
        }
        return minimo;
    }

    @Override
    public int maximo() {
        int maximo = array[0];
        for (int i = 0; i < indice_fim; i++) {
            if(array[i] > maximo)
                maximo = array[i];
        }
        return maximo;
    }

    @Override
    public int predecessor(int valor) {
      for (int i = 0; i < indice_fim; i++) {
            if(array[i] == valor)
                return array[i - 1];
        }
        return -1;
    }

    @Override
    public int sucessor(int valor) {
        for (int i = 0; i < indice_fim; i++) {
            if(array[i] == valor)
                return array[i + 1];
        }
        return -1;
    }

    @Override
    public void insereElemento(int valor) {
        redimensionaArray();
        array[indice_fim] = valor;
        indice_fim++;
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        redimensionaArray();
        for (int i = indice_fim; i > buscaIndice; i--) {
            array[i] = array[i-1];
        }
        array[buscaIndice] = valor;
        indice_fim++;
    }

    
    @Override
    public void insereInicio(int valor) {
        redimensionaArray();
        for (int i = indice_fim; i > 0; i--) {
            array[i] = array[i-1];
        }
        array[0] = valor;
        indice_fim++;
    }

    @Override
    public void insereFim(int valor) {
        redimensionaArray();
        array[indice_fim] = valor;
        indice_fim++;
    }
    
    @Override
    public void remove(int valor) {
        for (int i = 0; i < indice_fim; i++) {
            if (array[i] == valor) {
                for (int j = i; j < indice_fim - 1; j++) {
                    array[j] = array[j+1];
                }
                indice_fim--;
                break;
            }
        }
        
    }
    
    @Override
    public void removeIndice(int indice) {
        for (int i = indice; i < indice_fim - 1; i++) {
            array[i] =array[i + 1];
        }
        indice_fim--;
    }

    @Override
    public void removeInicio() {
        for (int i = 0; i < indice_fim; i++) {
            if(array[i] == array[0])
            removeIndice(i);
        }
        
    }

    @Override
    public void removeFim() {
        for (int i = 0; i < indice_fim; i++) {
            if(array[i] == array[indice_fim - 1])
                removeIndice(i);
        }
    }
    //função que caso o array esteja cheio, ele dobra o tamanho do array
    private void redimensionaArray() {
        if(indice_fim == array.length){
                int[] novoArray = new int[array.length * 2];
                for (int i = 0; i < array.length; i++) {
                    novoArray[i] = array[i];
                }
                array = novoArray;
            }
    }
}
