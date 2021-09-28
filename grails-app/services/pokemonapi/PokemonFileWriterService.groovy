package pokemonapi

class PokemonFileWriterService {

    def pokemonResourceService
    def pokemonLineWriterService

    def writeCsvResourceFromPokemons() {
        final List<Pokemon> pokemons = Pokemon.all
        final String pokemonsCsvText = buildCsvTextFromPokemons(pokemons)
        pokemonResourceService.getPokemonCsvFile().text = pokemonsCsvText
    }

    String buildCsvTextFromPokemons(final List<Pokemon> pokemons) {
        final List<String> pokemonCsvLines = pokemons.collect { final Pokemon pokemon ->
            final String pokemonCsvLine = pokemonLineWriterService.buildCsvLineFromPokemon(pokemon)
            return pokemonCsvLine
        }
        final String pokemonsCsvText = pokemonResourceService.CSV_HEADER + '\n' + pokemonCsvLines.join('\n')
        return pokemonsCsvText
    }

}
