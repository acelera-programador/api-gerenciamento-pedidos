public class Pessoa {

    private String nome;
    private int idade;
    private String endereco;

    public void imprimeInformacoes(){
        System.out.println("Nome: " + nome + " - Idade: " + idade);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getEndereco(){
        return this.endereco;
    }


}
