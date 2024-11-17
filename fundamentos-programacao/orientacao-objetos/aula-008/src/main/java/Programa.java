public class Programa {

    public static void main(String[] args) {

        Conta poupanca = new ContaPoupanca();
        poupanca.depositar(30);
        poupanca.sacar(50);

        Conta corrente = new ContaCorrente();
        corrente.depositar(50);
        corrente.sacar(60);


    }

}
