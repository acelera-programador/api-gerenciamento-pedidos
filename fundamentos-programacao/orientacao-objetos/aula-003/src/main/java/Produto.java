import java.io.Serializable;

public class Produto implements Serializable {

    private String nome;
    private float preco;

    public Produto(){
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public float getPreco(){
        return this.preco;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }

}
