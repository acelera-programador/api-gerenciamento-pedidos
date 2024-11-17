import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        List<String> letras = Arrays.asList("A", "B", "C", "D", "E", "F", "G");

        long quantidade =  letras.stream().filter(letra -> letra.equals("A") ||
                        letra.equals("B"))
                .count();

        System.out.println(quantidade);

    }

}
