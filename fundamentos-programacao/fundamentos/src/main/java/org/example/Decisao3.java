package org.example;

public class Decisao3 {

    public static void main(String[] args) {

        int diaDeSemana = 1;

        String dia;

        switch (diaDeSemana) {
            case 1:
                dia = "Domingo";
                break;
            case 2:
                dia = "Segunda";
                break;
            case 3:
                dia = "Terça";
                break;
            default:
                dia = "Dia invalido";
        }

        System.out.println(dia);

    }
}
