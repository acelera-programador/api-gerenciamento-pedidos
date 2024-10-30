package org.example;

public class Operadores {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;


        //Aritmeticos
        int soma = a + b;   //15
        int subtracao = a - b;  //5
        int multiplicacao = a * b;  //50
        int divisao = a / b;   //2
        int resto = a % b; //0


        //Relacionais

        int x = 15;
        int y = 15;

        boolean igual = (x == y); System.out.println(igual);
        boolean diferente = (x != y); System.out.println(diferente);
        boolean maior = (x > y); System.out.println(maior);
        boolean menor = (x < y); System.out.println(menor);
        boolean maiorOuIgual = (x >= y); System.out.println(maiorOuIgual);
        boolean menorOuIgual = (x <= y); System.out.println(menorOuIgual);


        String nome = "Joao";
        String nomeComSobrenome = nome + " Silveira Costa";

        System.out.println(nomeComSobrenome);





    }
}
