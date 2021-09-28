package pokemonapi

import grails.testing.gorm.DomainUnitTest
import org.springframework.validation.ObjectError
import spock.lang.Specification
import spock.lang.Unroll

class PokemonSpec extends Specification implements DomainUnitTest<Pokemon> {

    void 'pokemon is valid'() {
        when: 'creating a valid pokemon'
        final Pokemon pokemon = getValidPokemon()

        then: 'Object is valid'
        final boolean isValid = pokemon.validate()
        isValid
    }

    @Unroll
    void 'pokemon is invalid when #property is less then #minimumValue'() {
        when: 'Creating an invalid pokemon'
        final Pokemon pokemon = getValidPokemon()
        pokemon[property] = minimumValue - 1

        then: 'Object is invalid'
        final boolean isValid = pokemon.validate()
        !isValid

        and: 'Object has expected error'
        pokemon.errors.getAllErrors().any { ObjectError objectError ->
            return objectError.toString().startsWith(expectedError)
        }

        where:
        property     | minimumValue || expectedError
        'number'     | 1            || "Field error in object 'pokemonapi.Pokemon' on field 'number': rejected value [0];"
        'total'      | 180          || "Field error in object 'pokemonapi.Pokemon' on field 'total': rejected value [179];"
        'hp'         | 1            || "Field error in object 'pokemonapi.Pokemon' on field 'hp': rejected value [0];"
        'attack'     | 5            || "Field error in object 'pokemonapi.Pokemon' on field 'attack': rejected value [4];"
        'defense'    | 5            || "Field error in object 'pokemonapi.Pokemon' on field 'defense': rejected value [4];"
        'spAtl'      | 10           || "Field error in object 'pokemonapi.Pokemon' on field 'spAtl': rejected value [9];"
        'spDef'      | 20           || "Field error in object 'pokemonapi.Pokemon' on field 'spDef': rejected value [19];"
        'speed'      | 5            || "Field error in object 'pokemonapi.Pokemon' on field 'speed': rejected value [4];"
        'generation' | 1            || "Field error in object 'pokemonapi.Pokemon' on field 'generation': rejected value [0];"
    }

    @Unroll
    void 'pokemon is invalid when #property is bigger then #maximumValue'() {
        when: 'Creating an invalid pokemon'
        final Pokemon pokemon = getValidPokemon()
        pokemon[property] = maximumValue + 1

        then: 'Object is invalid'
        final boolean isValid = pokemon.validate()
        !isValid

        and: 'Object has expected error'
        pokemon.errors.getAllErrors().any { ObjectError objectError ->
            return objectError.toString().startsWith(expectedError)
        }

        where:
        property     | maximumValue || expectedError
//        'number'     | 721          || "Field error in object 'pokemonapi.Pokemon' on field 'number': rejected value [722];"
        'total'      | 780          || "Field error in object 'pokemonapi.Pokemon' on field 'total': rejected value [781];"
        'hp'         | 255          || "Field error in object 'pokemonapi.Pokemon' on field 'hp': rejected value [256];"
        'attack'     | 190          || "Field error in object 'pokemonapi.Pokemon' on field 'attack': rejected value [191];"
        'defense'    | 230          || "Field error in object 'pokemonapi.Pokemon' on field 'defense': rejected value [231];"
        'spAtl'      | 194          || "Field error in object 'pokemonapi.Pokemon' on field 'spAtl': rejected value [195];"
        'spDef'      | 230          || "Field error in object 'pokemonapi.Pokemon' on field 'spDef': rejected value [231];"
        'speed'      | 180          || "Field error in object 'pokemonapi.Pokemon' on field 'speed': rejected value [181];"
//        'generation' | 6            || "Field error in object 'pokemonapi.Pokemon' on field 'generation': rejected value [7];"
    }

    @Unroll
    void 'pokemon is invalid when #property is null'() {
        when: 'Creating an invalid pokemon'
        final Pokemon pokemon = getValidPokemon()
        pokemon[property] = null

        then: 'Object is invalid'
        final boolean isValid = pokemon.validate()
        !isValid

        and: 'Object has expected error'
        pokemon.errors.getAllErrors().any { ObjectError objectError ->
            return objectError.toString().startsWith(expectedError)
        }

        where:
        property    || expectedError
        'name'      || "Field error in object 'pokemonapi.Pokemon' on field 'name': rejected value [null];"
        'type1'     || "Field error in object 'pokemonapi.Pokemon' on field 'type1': rejected value [null];"
        'legendary' || "Field error in object 'pokemonapi.Pokemon' on field 'legendary': rejected value [null];"
    }

    void 'pokemon is valid when type2 is null'() {
        when: 'Creating an invalid pokemon'
        final Pokemon pokemon = getValidPokemon()
        pokemon.type2 = null

        then: 'Object is valid'
        final boolean isValid = pokemon.validate()
        isValid
    }

    void 'pokemon is invalid when name is blank'() {
        when: 'Creating an invalid pokemon'
        final Pokemon pokemon = getValidPokemon()
        pokemon.name = ''

        then: 'Object is invalid'
        final boolean isValid = pokemon.validate()
        !isValid

        and: 'Object has expected error'
        pokemon.errors.getAllErrors().any { ObjectError objectError ->
            return objectError.toString().startsWith(expectedError)
        }

        where:
        expectedError = "Field error in object 'pokemonapi.Pokemon' on field 'name': rejected value [];"
    }

    @Unroll
    void 'pokemon is invalid when #property is not a valid enum value ("#invalidValue")'() {
        when: 'Creating an invalid pokemon'
        final Pokemon pokemon = getValidPokemon()
        pokemon[property] = invalidValue

        then: 'raises an enum exception'
        final IllegalArgumentException iag = thrown(IllegalArgumentException)
        iag.message == expectedExceptionMessage

        where:
        property | invalidValue   || expectedExceptionMessage
        'type1'  | ''             || "No enum constant pokemonapi.PokemonType."
        'type1'  | 'SuperPokemon' || "No enum constant pokemonapi.PokemonType.SuperPokemon"
        'type2'  | ''             || "No enum constant pokemonapi.PokemonType."
        'type2'  | 'HyperPokemon' || "No enum constant pokemonapi.PokemonType.HyperPokemon"
    }

    void "pokemon is invalid when total doesn't match the sum of attributes"() {
        when: 'Creating a pokemon'
        final Pokemon pokemon = getValidPokemon()
        and: 'with all valid attributes'
        pokemon.hp = 1
        pokemon.attack = 5
        pokemon.defense = 5
        pokemon.spAtl = 10
        pokemon.spDef = 20
        pokemon.speed = 5
        and: "valid total, but than doesn't match the sum of the other attributes"
        pokemon.total = 780

        then: 'Object is invalid'
        final boolean isValid = pokemon.validate()
        !isValid

        and: 'Object has expected error'
        pokemon.errors.getAllErrors().any { ObjectError objectError ->
            return objectError.toString().startsWith(expectedError)
        }

        where:
        expectedError = "Field error in object 'pokemonapi.Pokemon' on field 'total': rejected value [780]"
    }

    private static Pokemon getValidPokemon() {
        return new Pokemon(
                number: 1,
                name: 'Bulbasaur',
                type1: 'Grass',
                type2: 'Poison',
                total: 318,
                hp: 45,
                attack: 49,
                defense: 49,
                spAtl: 65,
                spDef: 65,
                speed: 45,
                generation: 1,
                legendary: false
        )
    }

}
