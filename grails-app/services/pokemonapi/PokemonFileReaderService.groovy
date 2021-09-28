package pokemonapi

class PokemonFileReaderService {

    def pokemonResourceService
    def pokemonLineReaderService

    List<Pokemon> readPokemonsFromCsvResource() {
        final String pokemonsCsvText = pokemonResourceService.getPokemonCsvFile().text
        final List<Pokemon> pokemons = readPokemonsFromCsvText(pokemonsCsvText)
        pokemons.each { final Pokemon pokemon ->
            pokemon.save(failOnError: true)
        }
        return pokemons
    }

    List<Pokemon> readPokemonsFromCsvText(final String pokemonsCsvText) {
        final List<String> pokemonCsvLines = pokemonsCsvText.readLines()
        if (pokemonCsvLines.first().equals(pokemonResourceService.CSV_HEADER)) {
            pokemonCsvLines.pop()
        }
        final List<Pokemon> pokemons = pokemonCsvLines.collect { final String pokemonCsvLine ->
            final Pokemon pokemon = pokemonLineReaderService.readPokemonFromCsvLine(pokemonCsvLine)
            return pokemon
        }
        return pokemons
    }

}
