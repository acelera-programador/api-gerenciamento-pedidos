public class Programa {

    public static void main(String[] args) {

        Moto moto = new Moto("Preta", "Yamaha");
        moto.mover();

        System.out.println("-----------------");

        moto.mover("Executado com sucesso");
    }

}
