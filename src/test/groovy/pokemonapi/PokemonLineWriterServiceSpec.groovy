package pokemonapi

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class PokemonLineWriterServiceSpec extends Specification implements ServiceUnitTest<PokemonLineWriterService> {

    void 'writer can build csv line for pokemon with all attributes'() {
        when:
        final Pokemon pokemon = new Pokemon(
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

        then:
        service.buildCsvLineFromPokemon(pokemon) == '1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False'
    }

    void 'writer can build csv line for pokemon without type2 attribute'() {
        when:
        final Pokemon pokemon = new Pokemon(
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

        then:
        service.buildCsvLineFromPokemon(pokemon) == '7,Squirtle,Water,,314,44,48,65,50,64,43,1,False'
    }

    void 'writer can build csv line for legendary pokemon'() {
        when:
        final Pokemon pokemon = new Pokemon(
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

        then:
        service.buildCsvLineFromPokemon(pokemon) == '144,Articuno,Ice,Flying,580,90,85,100,95,125,85,1,True'
    }

}
