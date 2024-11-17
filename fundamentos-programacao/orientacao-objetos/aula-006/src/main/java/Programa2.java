public class Programa2 {

    public static void main(String[] args) {

        Veiculo carro = new Carro("Azul", "VW");
        Veiculo moto = new Moto("Preta", "Yamaha");

        fazerOVeiculoSeMover(carro);
        fazerOVeiculoSeMover(moto);
    }

    public static void fazerOVeiculoSeMover(Veiculo veiculo){
        veiculo.mover();
    }

}
