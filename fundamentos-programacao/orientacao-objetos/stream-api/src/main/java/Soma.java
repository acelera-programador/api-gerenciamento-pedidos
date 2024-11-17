import java.util.Arrays;
import java.util.List;

public class Soma {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(10, 30, 50, 60);

        int soma = numeros.stream().reduce(0, Integer::sum);


        System.out.println(soma);


    }

}
