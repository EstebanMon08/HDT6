import java.util.*;

public class PokemonFactory {

    // Método Factory para crear la implementación de Map
    public static Map<String, Pokemon> createMap(int mapChoice) {
        switch (mapChoice) {
            case 1:
                return new HashMap<>();  // HashMap
            case 2:
                return new TreeMap<>();  // TreeMap, ordena por la clave
            case 3:
                return new LinkedHashMap<>();  // LinkedHashMap, mantiene el orden de inserción
            default:
                throw new IllegalArgumentException("Invalid map choice");
        }
    }
}

