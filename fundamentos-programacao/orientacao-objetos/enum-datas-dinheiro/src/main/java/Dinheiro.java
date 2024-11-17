import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class Dinheiro {

    public static void main(String[] args) {

        BigDecimal valor1 = new BigDecimal("10.25");
        BigDecimal valor2 = new BigDecimal("5.75");

        BigDecimal divisao = valor1.divide(valor2, 2, RoundingMode.HALF_UP);
        System.out.println(divisao);

        Currency moeda = Currency.getInstance("BRL");
        System.out.println(moeda.getSymbol());


    }

}
