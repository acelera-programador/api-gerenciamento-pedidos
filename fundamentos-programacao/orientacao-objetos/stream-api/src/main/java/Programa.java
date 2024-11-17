public class Programa {

    public static void main(String[] args) {

        // (parametros) -> expresao ou meu bloco de codigo

        Operacao soma = Integer::sum;

        Operacao subtracao = (a, b) -> a - b;

        System.out.println("O resultado da soma é " + soma.executar(1, 2));
        System.out.println("O resultado da sub é " + subtracao.executar(1, 2));

    }

}
