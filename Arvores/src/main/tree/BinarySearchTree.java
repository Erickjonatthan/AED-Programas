package tree;

import java.util.ArrayList;
import java.util.List;

import estrut.No;
import estrut.Tree;

public class BinarySearchTree implements Tree{

    private No raiz;

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public No getRaiz() {
        return raiz;
    }

    public BinarySearchTree() {
        this.setRaiz(null);
    }
    
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
        return valor < no.getValor() ? buscaElemento(no.getEsquerda(), valor) : buscaElemento(no.getDireta(), valor);
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
        return no.getDireta() == null ? no : maximo(no.getDireta());
    }

    
    public void insereElemento(No no, int valor) {
        if(valor < no.getValor()){
            if(no.getEsquerda() == null){
                no.setEsquerda(new No(valor));
            }else{
                insereElemento(no.getEsquerda(), valor);
            }
        }else{
            if(no.getDireta() == null){
                no.setDireta(new No(valor));
            }else{
                insereElemento(no.getDireta(), valor);
            }
        }   
    }

    @Override
    public void insereElemento(int valor) {
        if(this.raiz == null){
            this.raiz = new No(valor);
        }else{
           insereElemento(this.raiz, valor);
        }
    }
    
    public void remove(No no, No pai, int valor) {
        if(no == null){
            return;
        }
        if(no.getValor() == valor){
            if(no.getDireta() == null && no.getEsquerda() == null){
                if(pai.getDireta() == no){
                    pai.setDireta(null);
                }else{
                    pai.setEsquerda(null);
                }
            }else if(no.getDireta() == null){
                if(pai.getDireta() == no){
                    pai.setDireta(no.getEsquerda());
                }else{
                    pai.setEsquerda(no.getEsquerda());
                }
            }else if(no.getEsquerda() == null){
                if(pai.getDireta() == no){
                    pai.setDireta(no.getDireta());
                }else{
                    pai.setEsquerda(no.getDireta());
                }
            }else{
                No sucessor = no.sucessor(no);
                no.setValor(sucessor.getValor());
                remove(no.getDireta(), no, sucessor.getValor());
            }
        }else if(valor < no.getValor()){
            remove(no.getEsquerda(), no, valor);
        }else{
            remove(no.getDireta(), no, valor);
        }
        
    }

    @Override
    public void remove(int valor) {
        if (this.raiz.getValor() == valor) {
            No aux = new No(0);
            aux.setDireta(this.raiz);
            remove(this.raiz, aux, valor);
            this.raiz = aux.getDireta();
        } else {
            remove(this.raiz, null, valor);
        }
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
            preOrdem(no.getDireta(), lista);
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
            emOrdem(no.getDireta(), lista);
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
            posOrdem(no.getDireta(), lista);
            lista.add(no.getValor());
        }
    }

}