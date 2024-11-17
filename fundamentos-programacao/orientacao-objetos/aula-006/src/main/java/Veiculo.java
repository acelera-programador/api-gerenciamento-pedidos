public class Veiculo {

    protected String cor;
    private String marca;
    private Integer quantidadeDeRodas;

    public Veiculo(String cor, String marca, Integer quantidadeDeRodas) {
        this.cor = cor;
        this.marca = marca;
        this.quantidadeDeRodas = quantidadeDeRodas;
    }

    public void mover(){
        System.out.println("Mover Veiculo da cor " + this.cor + " com a marca " + this.marca
        + " com " + this.quantidadeDeRodas + " rodas.");
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getQuantidadeDeRodas() {
        return quantidadeDeRodas;
    }

    public void setQuantidadeDeRodas(Integer quantidadeDeRodas) {
        this.quantidadeDeRodas = quantidadeDeRodas;
    }
}
