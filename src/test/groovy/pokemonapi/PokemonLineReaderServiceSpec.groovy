package pokemonapi

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class PokemonLineReaderServiceSpec extends Specification implements ServiceUnitTest<PokemonLineReaderService> {

    void 'reader can build pokemon from csv line with pokemon with all attributes'() {
        when:
        final Pokemon pokemon = service.readPokemonFromCsvLine('1,Bulbasaur,Grass,Poison,318,45,49,49,65,65,45,1,False')

        then:
        pokemon.number == 1
        pokemon.name == 'Bulbasaur'
        pokemon.type1 == PokemonType.Grass
        pokemon.type2 == PokemonType.Poison
        pokemon.total == 318
        pokemon.hp == 45
        pokemon.attack == 49
        pokemon.defense == 49
        pokemon.spAtl == 65
        pokemon.spDef == 65
        pokemon.speed == 45
        pokemon.generation == 1
        !pokemon.legendary
    }

    void 'reader can build pokemon from csv line with pokemon without type2 attribute'() {
        when:
        final Pokemon pokemon = service.readPokemonFromCsvLine('7,Squirtle,Water,,314,44,48,65,50,64,43,1,False')

        then:
        pokemon.number == 7
        pokemon.name == 'Squirtle'
        pokemon.type1 == PokemonType.Water
        pokemon.type2 == null
        pokemon.total == 314
        pokemon.hp == 44
        pokemon.attack == 48
        pokemon.defense == 65
        pokemon.spAtl == 50
        pokemon.spDef == 64
        pokemon.speed == 43
        pokemon.generation == 1
        !pokemon.legendary
    }

    void 'reader can build pokemon from csv line with legendary pokemon'() {
        when:
        final Pokemon pokemon = service.readPokemonFromCsvLine('144,Articuno,Ice,Flying,580,90,85,100,95,125,85,1,True')

        then:
        pokemon.number == 144
        pokemon.name == 'Articuno'
        pokemon.type1 == PokemonType.Ice
        pokemon.type2 == PokemonType.Flying
        pokemon.total == 580
        pokemon.hp == 90
        pokemon.attack == 85
        pokemon.defense == 100
        pokemon.spAtl == 95
        pokemon.spDef == 125
        pokemon.speed == 85
        pokemon.generation == 1
        pokemon.legendary
    }

}
