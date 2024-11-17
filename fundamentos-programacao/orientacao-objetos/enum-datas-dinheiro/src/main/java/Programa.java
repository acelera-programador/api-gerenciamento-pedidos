public class Programa {

    public static void main(String[] args) {


        for(DiaDaSemana dia : DiaDaSemana.values()) {
            System.out.println(dia.getDiaFormatado() + " - posicao " + dia.ordinal());
        }



    }

}
