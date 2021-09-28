package pokemonapi

class PokemonLineWriterService {

    String buildCsvLineFromPokemon(final Pokemon pokemon) {
        final List csvColumns = [
                pokemon.number,
                pokemon.name,
                pokemon.type1,
                pokemon.type2 ?: '',
                pokemon.total,
                pokemon.hp,
                pokemon.attack,
                pokemon.defense,
                pokemon.spAtl,
                pokemon.spDef,
                pokemon.speed,
                pokemon.generation,
                pokemon.legendary.toString().capitalize(),
        ]

        return csvColumns.join(',')
    }

}
