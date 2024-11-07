public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }
    public int somar(int a, int b, int c) {
        return a + b + c;
    }
    public double somar(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        double soma = calculadora.somar(10d, 20d);




        System.out.println(soma);
    }

}
