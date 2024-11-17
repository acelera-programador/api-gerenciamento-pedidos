public class ContaPoupanca implements Conta{

    @Override
    public void sacar(double valor) {
        System.out.println("Sacando " + valor + " da conta poupanca");
    }

    @Override
    public void depositar(double valor) {
        System.out.println("Depositar " + valor + " da conta poupanca");
    }
}
