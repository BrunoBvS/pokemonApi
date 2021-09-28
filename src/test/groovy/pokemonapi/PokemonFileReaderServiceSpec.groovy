package pokemonapi

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class PokemonFileReaderServiceSpec extends Specification implements ServiceUnitTest<PokemonFileReaderService> {

    def setup() {
        service.pokemonResourceService = new PokemonResourceService()
        service.pokemonLineReaderService = new PokemonLineReaderService()
    }

    void 'reader can build list of pokemons from csv example'() {
        when:
        final List<Pokemon> pokemons = service.readPokemonsFromCsvText(pokemonsCsvText)

        then:
        pokemons.size() == 3
        pokemons[0].name == 'Bulbasaur'
        pokemons[1].name == 'Squirtle'
        pokemons[2].name == 'Articuno'

        where:
        pokemonsCsvText = '1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n' +
                '7,Squirtle,Water,,314,44,48,65,50,64,43,1,False\n' +
                '144,Articuno,Ice,Flying,580,90,85,100,95,125,85,1,True'
    }

}
