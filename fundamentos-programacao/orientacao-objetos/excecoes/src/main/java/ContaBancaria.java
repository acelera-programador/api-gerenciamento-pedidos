public class ContaBancaria {

    private double saldo;

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if(valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        this.saldo -= valor;
    }

}
