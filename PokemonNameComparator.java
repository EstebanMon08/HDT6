import java.util.*;

public class PokemonNameComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon p1, Pokemon p2) {
        return p1.getName().compareTo(p2.getName());  // Ordena por nombre alfabéticamente
    }
}
