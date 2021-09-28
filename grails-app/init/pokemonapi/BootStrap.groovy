package pokemonapi

class BootStrap {

    PokemonFileReaderService pokemonFileReaderService
    PokemonFileWriterService pokemonFileWriterService

    def init = { servletContext ->
        pokemonFileReaderService.readPokemonsFromCsvResource()
    }

    def destroy = {
        pokemonFileWriterService.writeCsvResourceFromPokemons()
    }

}
