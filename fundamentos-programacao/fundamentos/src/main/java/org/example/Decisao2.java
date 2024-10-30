package org.example;

public class Decisao2 {

    public static void main(String[] args) {
        // Algoritmo - nota >= 90 aprovado com louvor
        // nota >= 70 aprovado
        // nota < 70 reprovado

        int nota = 98;

        if(nota >= 90){
            System.out.println("Aprovado com louvor");
        }else if(nota >= 70){
            System.out.println("Aprovado");
        }else{
            System.out.println("Reprovado");
        }
    }
}
