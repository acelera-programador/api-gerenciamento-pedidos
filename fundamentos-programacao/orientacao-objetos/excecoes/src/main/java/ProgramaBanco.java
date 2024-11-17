public class ProgramaBanco {

    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria();
        conta.setSaldo(1000);

        try {
            conta.sacar(1500);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Saldo da conta: " + conta.getSaldo());
    }

}
