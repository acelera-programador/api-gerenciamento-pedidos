package org.example;

import java.util.Scanner;

public class ScannerIdade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] idades = new int[5];

        for(int i = 0; i < idades.length; i++){
            System.out.println("Por favor digite a idade da pessoa " + (i + 1) + ":");
            int idade = scanner.nextInt();
            idades[i] = idade;
        }

        for(int idade : idades){
            System.out.println("Idade: " + idade);
        }


    }
}
