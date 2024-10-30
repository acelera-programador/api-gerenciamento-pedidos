package org.example;

public class RepeticaoComplementacao {

    public static void main(String[] args) {

        // Imprimir valores de 1 a 10 só que eu não quero imprimir o valor 5; ok
        // Criar uma estrutura que repita 100 vezes e nao imprima valores acima de 50;

        for(int x = 1; x <= 100 ; x++){
           if(x > 50)
               break;

            System.out.println(x);
        }


        System.out.println("Repeticao Complementacao");

        for(int x = 1; x <= 10 ; x++){
            for(int y = 1; y <= 10 ; y++){
                System.out.println("X = " + x + ", Y = " + y);
            }
        }



    }

}
