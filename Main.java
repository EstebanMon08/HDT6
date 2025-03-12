import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Leer los datos del archivo CSV
        Map<String, Pokemon> pokemonMap = PokemonDataReader.loadPokemonsFromFile("pokemons.csv");

        // Crear un Scanner para interactuar con el usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de MAP (1: HashMap, 2: TreeMap, 3: LinkedHashMap):");
        String selection = scanner.nextLine();
        
        Map<String, Pokemon> userPokemonMap = PokemonFactory.getMap(selection);

        // Ejemplo de agregar un Pokémon a la colección del usuario
        System.out.println("Ingrese el nombre del Pokémon para agregar a tu colección:");
        String pokemonName = scanner.nextLine();
        addPokemon(userPokemonMap, pokemonName, pokemonMap);

        // Mostrar los Pokémon por tipo1
        showPokemonsByType1(userPokemonMap);

        // Mostrar todos los Pokémon por tipo1
        showAllPokemonsByType1(pokemonMap);

        // Buscar Pokémon por habilidad
        System.out.println("Ingrese una habilidad para buscar Pokémon:");
        String ability = scanner.nextLine();
        showPokemonsByAbility(pokemonMap, ability);
    }

    public static void addPokemon(Map<String, Pokemon> userMap, String name, Map<String, Pokemon> allPokemons) {
        Pokemon pokemon = allPokemons.get(name);
        if (pokemon != null && !userMap.containsKey(name)) {
            userMap.put(name, pokemon);
            System.out.println(pokemon + " ha sido agregado a tu colección.");
        } else if (userMap.containsKey(name)) {
            System.out.println("Este Pokémon ya está en tu colección.");
        } else {
            System.out.println("Este Pokémon no se encuentra en los datos.");
        }
    }

    public static void showPokemonsByType1(Map<String, Pokemon> userMap) {
        userMap.values().stream()
            .sorted(Comparator.comparing(Pokemon::getType1))
            .forEach(pokemon -> System.out.println(pokemon.getName() + ": " + pokemon.getType1()));
    }

    public static void showAllPokemonsByType1(Map<String, Pokemon> pokemonMap) {
        pokemonMap.values().stream()
            .sorted(Comparator.comparing(Pokemon::getType1))
            .forEach(pokemon -> System.out.println(pokemon.getName() + ": " + pokemon.getType1()));
    }

    public static void showPokemonsByAbility(Map<String, Pokemon> pokemonMap, String ability) {
        pokemonMap.values().stream()
            .filter(pokemon -> pokemon.getAbilities().contains(ability))
            .forEach(pokemon -> System.out.println(pokemon.getName() + " has ability: " + ability));
    }
}
