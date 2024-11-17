public class Moto extends Veiculo {

    public Moto(String cor, String marca) {
        super(cor, marca, 2);
    }

    @Override
    public void mover(){
        System.out.println("Esse metodo é um metodo da classe moto " + super.cor);
    }

    public void mover(String mensagem){
        this.mover();
        System.out.println(mensagem);
    }

}


