public class ContaCorrente implements Conta {

    @Override
    public void depositar(double valor) {
        System.out.println("Depositando " + valor + " na conta corrente");
    }

    @Override
    public void sacar(double valor) {
        System.out.println("Sacando " + valor + " na conta corrente");
    }
}
