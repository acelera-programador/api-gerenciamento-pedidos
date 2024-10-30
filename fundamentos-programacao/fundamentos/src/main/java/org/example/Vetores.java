package org.example;

public class Vetores {

    public static void main(String[] args) {

        int[][] idades = new int[2][2];

        idades[0][0] = 10;
        idades[0][1] = 20;
        idades[1][0] = 30;
        idades[1][1] = 40;

       for(int i = 0; i < idades.length; i++){
            for(int j = 0; j < idades[i].length; j++){
                System.out.println("Idade: " + idades[i][j]);
            }
       }







    }

}
