package org.example;

public class Calculadora {

    public int soma(int a, int b){
        int resultado = a + b;
        return resultado;
    }

    public void imprimeResultado(int resultado){
        System.out.println("Resultado: " + resultado);
    }

    public int fatorial(int numero){
        if(numero == 1 || numero == 0){
            return 1;
        }
        return numero * fatorial(numero - 1);
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.fatorial(5);
        calculadora.imprimeResultado(resultado);

        //  5 - 5 * 4 * 3 * 2 * 1

    }

}
