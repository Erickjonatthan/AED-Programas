package cliente;

public class Cliente {
    String nome;
    Boolean papelada;
    
    public Cliente(String nome) {
        this.nome = nome;
        this.papelada = true;
    }

    public Boolean getPapelada() {
        return papelada;
    }
    public void setPapelada(Boolean papelada) {
        this.papelada = papelada;
    }
    public String getNome() {
        return nome;
    }
}
