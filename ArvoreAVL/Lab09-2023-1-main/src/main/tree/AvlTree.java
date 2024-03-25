package tree;

import java.util.ArrayList;
import java.util.List;

import estrut.No;
import estrut.Tree;

public class AvlTree implements Tree{

    private No raiz;
    
    @Override
    public boolean buscaElemento(int valor) {
        return buscaElemento(this.raiz, valor);
    }
    
    private boolean buscaElemento(No no, int valor) {
        if (no == null) {
            return false;
        }
        if (valor == no.getValor()) {
            return true;
        }
        return valor < no.getValor() ? buscaElemento(no.getEsquerda(), valor) : buscaElemento(no.getDireita(), valor);
    }

    @Override
    public int minimo() {
        return minimo(this.raiz).getValor();
    }
    
    private No minimo(No no) {
        return no.getEsquerda() == null ? no : minimo(no.getEsquerda());
    }
    
    @Override
    public int maximo() {
        return maximo(this.raiz).getValor();
    }
    
    private No maximo(No no) {
        return no.getDireita() == null ? no : maximo(no.getDireita());
    }

    private No insereElemento(No no, int valor) {

        if (no == null) {
            return new No(valor);
        }
    
        if (valor < no.getValor()) {
            no.setEsquerda(insereElemento(no.getEsquerda(), valor));
        } else if (valor > no.getValor()) {
            no.setDireita(insereElemento(no.getDireita(), valor));
        } else {
            return no;
        }
    
        no.setAltura(1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita())));
    
        int balance = no.getFatorBalanceamento();
    
        if (balance > 1 && valor < no.getEsquerda().getValor()) {
            return rotacaoDireita(no);
        }
    
        if (balance < -1 && valor > no.getDireita().getValor()) {
            return rotacaoEsquerda(no);
        }
    
        if (balance > 1 && valor > no.getEsquerda().getValor()) {
            return rotacaoDuplaDireita(no);
        }
    
        if (balance < -1 && valor < no.getDireita().getValor()) {
            return rotacaoDuplaEsquerda(no);
        }
    
        return no;
    }

    @Override
    public void insereElemento(int valor) {
        this.raiz = insereElemento(this.raiz, valor);
    }

    @Override
    public void remove(int valor) {
        this.raiz = remove(this.raiz, valor);
    }

    private No remove(No no, int valor) {
        if (no == null) {
            return no;
        }
    
        if (valor < no.getValor()) {
            no.setEsquerda(remove(no.getEsquerda(), valor));
        } else if (valor > no.getValor()) {
            no.setDireita(remove(no.getDireita(), valor));
        } else {
            if ((no.getEsquerda() == null) || (no.getDireita() == null)) {
                No temp = null;
                if (temp == no.getEsquerda()) {
                    temp = no.getDireita();
                } else {
                    temp = no.getEsquerda();
                }
    
                if (temp == null) {
                    temp = no;
                    no = null;
                } else {
                    no = temp;
                }
            } else {
                No temp = minimo(no.getDireita());
                no.setValor(temp.getValor());
                no.setDireita(remove(no.getDireita(), temp.getValor()));
            }
        }
    
        if (no == null) {
            return no;
        }
    
        no.setAltura(Math.max(altura(no.getEsquerda()), altura(no.getDireita())) + 1);
    
        int balance = no.getFatorBalanceamento();
    
        if (balance > 1 && no.getEsquerda().getFatorBalanceamento() >= 0) {
            return rotacaoDireita(no);
        }
    
        if (balance > 1 && no.getEsquerda().getFatorBalanceamento() < 0) {
            return rotacaoDuplaDireita(no);
        }
    
        if (balance < -1 && no.getDireita().getFatorBalanceamento() <= 0) {
            return rotacaoEsquerda(no);
        }
    
        if (balance < -1 && no.getDireita().getFatorBalanceamento() > 0) {
            return rotacaoDuplaEsquerda(no);
        }
    
        return no;
    }

    @Override
    public int[] preOrdem() {
        List<Integer> lista = new ArrayList<>();
        preOrdem(this.raiz, lista);
        return lista.stream().mapToInt(i->i).toArray();
    }

    private void preOrdem(No no, List<Integer> lista) {
        if (no != null) {
            lista.add(no.getValor());
            preOrdem(no.getEsquerda(), lista);
            preOrdem(no.getDireita(), lista);
        }
    }

    @Override
    public int[] emOrdem() {
        List<Integer> lista = new ArrayList<>();
        emOrdem(this.raiz, lista);
        return lista.stream().mapToInt(i->i).toArray();
    }

    private void emOrdem(No no, List<Integer> lista) {
        if (no != null) {
            emOrdem(no.getEsquerda(), lista);
            lista.add(no.getValor());
            emOrdem(no.getDireita(), lista);
        }
    }

    @Override
    public int[] posOrdem() {
        List<Integer> lista = new ArrayList<>();
        posOrdem(this.raiz, lista);
        return lista.stream().mapToInt(i->i).toArray();
    }

    private void posOrdem(No no, List<Integer> lista) {
        if (no != null) {
            posOrdem(no.getEsquerda(), lista);
            posOrdem(no.getDireita(), lista);
            lista.add(no.getValor());
        }
    }

    // Método para realizar uma rotação à direita
    private No rotacaoDireita(No y) {
        No x = y.getEsquerda();
        No T2 = x.getDireita();

        // Realiza a rotação
        x.setDireita(y);
        y.setEsquerda(T2);

        // Atualiza as alturas
        y.setAltura(Math.max(altura(y.getEsquerda()), altura(y.getDireita())) + 1);
        x.setAltura(Math.max(altura(x.getEsquerda()), altura(x.getDireita())) + 1);

        // Retorna o novo nó raiz
        return x;
    }

    // Método para realizar uma rotação à esquerda
    private No rotacaoEsquerda(No x) {
        No y = x.getDireita();
        No T2 = y.getEsquerda();

        // Realiza a rotação
        y.setEsquerda(x);
        x.setDireita(T2);

        // Atualiza as alturas
        x.setAltura(Math.max(altura(x.getEsquerda()), altura(x.getDireita())) + 1);
        y.setAltura(Math.max(altura(y.getEsquerda()), altura(y.getDireita())) + 1);

        // Retorna o novo nó raiz
        return y;
    }

    // Método para realizar uma rotação dupla à direita
    private No rotacaoDuplaDireita(No y) {
        y.setEsquerda(rotacaoEsquerda(y.getEsquerda()));
        return rotacaoDireita(y);
    }

    // Método para realizar uma rotação dupla à esquerda
    private No rotacaoDuplaEsquerda(No y) {
        y.setDireita(rotacaoDireita(y.getDireita()));
        return rotacaoEsquerda(y);
    }

    private int altura(No N) {
        if (N == null)
            return 0;
        return N.getAltura();
    }


}