import java.util.Map;
import java.util.HashMap;

public class MapCollection {

    public static void main(String[] args) {
        Map<String, Integer> mapDasIdades = new HashMap<>();
        mapDasIdades.put("Joao", 10);
        mapDasIdades.put("Maria", 20);




        for(Map.Entry<String, Integer> entry : mapDasIdades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }

}
