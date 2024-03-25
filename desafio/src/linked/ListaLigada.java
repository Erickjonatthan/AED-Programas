package linked;

import cliente.Cliente;


public class ListaLigada {
    private No cabeca;

    public ListaLigada() {
        
    }


    public boolean buscaElemento(Cliente valor) {
        No atual = this.cabeca;

        while (atual != null) {
            if (atual.getValor() == valor) {
                return true;
            }
            
            atual = atual.getProximo();
        }
        
        return false;
    }

    public Cliente buscaIndice(int indice) {
        No atual = this.cabeca;
        int posicao = 0;
        while(atual != null){
            if(posicao == indice){
                return atual.getValor();
            }
            atual = atual.getProximo();
            posicao++;
        }     
        return null;

    }


    public void insereElemento(Cliente valor) {
       if(this.cabeca == null){
            this.cabeca = new No(valor);
        }
        else{
            No n = new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
       }
    }

    public void insereElementoPosicao(Cliente valor, int buscaIndice) {
        No atual = this.cabeca;
        int indice = 0;
        if(buscaIndice == 0){
            insereInicio(valor);
            return;
        }
        else{
            while (atual != null) {
                if (indice == buscaIndice) {
                    No novo = new No(valor);
                    novo.setProximo(atual.getProximo());
                    atual.setProximo(novo);
                    return;
                }

                atual = atual.getProximo();
                indice++;
            }
    }
    }

    public void insereInicio(Cliente valor){

        if(this.cabeca == null){
            this.cabeca = new No(valor);
        }
        else{
            No n = new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
       }
    }

    public void insereFim(Cliente valor) {
        No novo = new No(valor);

        if (this.cabeca == null) {
            this.cabeca = novo;
        } else {
            No atual = this.cabeca;

            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }

            atual.setProximo(novo);
        }
    }

    public void remove(Cliente valor) {
       No atual = this.cabeca;
       if(atual.getValor() == valor){
            this.cabeca = atual.getProximo();
       }
       else{
            while (atual.getProximo() != null) {
                if(atual.getProximo().getValor() == valor){
                    atual.setProximo(atual.getProximo().getProximo());
                    return;
                }
                atual = atual.getProximo();
            }
                
            }
       }
    

    public void removeIndice(int indice) {
       Cliente valor = buscaIndice(indice);
       if(valor != null)
       remove(valor);
    }
    public void removeInicio() {
        if(this.cabeca != null){
            this.cabeca = this.cabeca.getProximo();
        }
        else{
            removeIndice(0);
        }
    }

    public void removeFim() {
        No atual = this.cabeca;
        if(atual == null){
            removeIndice(0);
        }
        int indice = 0;
        while(atual != null){
            atual = atual.getProximo();
            indice++;
        }
        removeIndice(indice-1);
    }


    public int size() {
        No atual = this.cabeca;
        int indice = 0;
        while(atual != null){
            atual = atual.getProximo();
            indice++;
        }
        return indice;
    }


}
