import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exemplo1 {

    public static void main(String[] args) {
        //Exemplo 1: Filtrar e Coletar Nomes que Começam com Letra Específica

        List<String> nomes = Arrays.asList("Alice", "Ana", "Bruno", "Carlos");

        List<String> nomesFiltrados = nomes.stream().filter(nome -> nome.startsWith("A"))
                .collect(Collectors.toList());


        nomesFiltrados.forEach(nome -> System.out.println(nome));


    }

}
