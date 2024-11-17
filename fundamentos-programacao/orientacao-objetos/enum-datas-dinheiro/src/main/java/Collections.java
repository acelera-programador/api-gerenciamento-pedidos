import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collections {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Jose");
        nomes.add("Maria");
        nomes.add("Pedro");
        nomes.add("Jose");


        System.out.println("Tamanho da lista " + nomes.size());

        for(String nome : nomes){
            System.out.println(nome);
        }

    }
}
