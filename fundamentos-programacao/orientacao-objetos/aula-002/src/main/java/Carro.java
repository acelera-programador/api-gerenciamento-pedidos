public class Carro {
    String cor;
    String marca;
    int ano;


    public Carro(){
        this.cor = "Preto";
        this.marca = "Fiat";
        this.ano = 2020;
    }

    public Carro(String cor, String marca, int ano){
        this.cor = cor;
        this.marca = marca;
        this.ano = ano;
    }

    public void acelerar(){
        System.out.println("Carro da cor " + cor + " da marca " + marca + " e do ano " + ano + " acelerado");
    }
}
