package pokemonapi

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource

class PokemonResourceService {

    static final CSV_HEADER = '#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary'

    @Value("classpath:pokemon.csv")
    Resource pokemonCsvResource

    File getPokemonCsvFile() {
        return pokemonCsvResource.getFile()
    }

}
