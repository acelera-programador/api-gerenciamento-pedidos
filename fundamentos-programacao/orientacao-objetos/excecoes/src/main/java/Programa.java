public class Programa {


    public static void main(String[] args) {

        try {
            int resultado = 10 / 2; // Gera uma ArithmeticException
            System.out.println(resultado);
        }catch (ArithmeticException e) {
            System.out.println("Nao é possivel dividir numero por zero");
        }finally {
            System.out.println("Finalizado");
        }




    }

}
