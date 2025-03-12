import java.io.*;
import java.util.*;

public class PokemonDataReader {

    // Método para leer el archivo CSV y cargar los datos en un Map
    public static Map<String, Pokemon> loadPokemonsFromFile(String fileName) {
        Map<String, Pokemon> pokemonMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Leer la cabecera y saltarla
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Asumimos que las columnas son: Name, Pokedex Number, Type1, Type2, Classification, Height, Weight, Abilities, Generation, Legendary Status
                String name = data[0];
                int pokedexNumber = Integer.parseInt(data[1]);
                String type1 = data[2];
                String type2 = data[3];
                String classification = data[4];
                double height = Double.parseDouble(data[5]);
                double weight = Double.parseDouble(data[6]);
                List<String> abilities = Arrays.asList(data[7].split(" "));
                int generation = Integer.parseInt(data[8]);
                String legendaryStatus = data[9];

                // Crear un objeto Pokemon y agregarlo al Map
                Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, height, weight, abilities, generation, legendaryStatus);
                pokemonMap.put(name, pokemon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pokemonMap;
    }
}
