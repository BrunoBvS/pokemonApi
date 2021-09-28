package pokemonapi

import grails.rest.Resource

@Resource(uri = "/pokemon", readOnly = false, formats = ['json'])
class Pokemon {

    int number
    String name
    PokemonType type1
    PokemonType type2
    int total
    int hp
    int attack
    int defense
    int spAtl
    int spDef
    int speed
    int generation
    Boolean legendary

    static constraints = {
        number min: 1/*, max: 721*/
        name nullable: false, blank: false
        type1 nullable: false, blank: false
        type2 nullable: true, blank: false
        total min: 180, max: 780, validator: { int total, Pokemon pokemon ->
            return total == pokemon.hp + pokemon.attack + pokemon.defense + pokemon.spAtl + pokemon.spDef + pokemon.speed
        }
        hp min: 1, max: 255
        attack min: 5, max: 190
        defense min: 5, max: 230
        spAtl min: 10, max: 194
        spDef min: 20, max: 230
        speed min: 5, max: 180
        generation min: 1/*, max: 6*/
        legendary nullable: false
    }

}