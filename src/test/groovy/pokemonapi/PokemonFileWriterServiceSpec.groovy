package pokemonapi

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class PokemonFileWriterServiceSpec extends Specification implements ServiceUnitTest<PokemonFileWriterService> {

    def setup() {
        service.pokemonResourceService = new PokemonResourceService()
        service.pokemonLineWriterService = new PokemonLineWriterService()
    }

    void 'writer can build csv from list of pokemons'() {
        setup:
        final Pokemon pokemon1 = new Pokemon(
                number: 1,
                name: 'Bulbasaur',
                type1: PokemonType.Grass,
                type2: PokemonType.Poison,
                total: 318,
                hp: 45,
                attack: 49,
                defense: 49,
                spAtl: 65,
                spDef: 65,
                speed: 45,
                generation: 1,
                legendary: false,
        )
        final Pokemon pokemon7 = new Pokemon(
                number: 7,
                name: 'Squirtle',
                type1: PokemonType.Water,
                type2: null,
                total: 314,
                hp: 44,
                attack: 48,
                defense: 65,
                spAtl: 50,
                spDef: 64,
                speed: 43,
                generation: 1,
                legendary: false,
        )
        final Pokemon pokemon144 = new Pokemon(
                number: 144,
                name: 'Articuno',
                type1: PokemonType.Ice,
                type2: PokemonType.Flying,
                total: 580,
                hp: 90,
                attack: 85,
                defense: 100,
                spAtl: 95,
                spDef: 125,
                speed: 85,
                generation: 1,
                legendary: true,
        )
        final List<Pokemon> pokemons = [
                pokemon1,
                pokemon7,
                pokemon144,
        ]

        when:
        final String pokemonsCsvText = service.buildCsvTextFromPokemons(pokemons)

        then:
        pokemonsCsvText == '#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary\n' +
                '1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False\n' +
                '7,Squirtle,Water,,314,44,48,65,50,64,43,1,False\n' +
                '144,Articuno,Ice,Flying,580,90,85,100,95,125,85,1,True'
    }

}
