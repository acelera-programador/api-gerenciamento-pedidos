package br.com.aceleraprogramador.modelo;

public class Produto {
    private String nome;
    private float preco;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco(){
        return this.preco;
    }
}
