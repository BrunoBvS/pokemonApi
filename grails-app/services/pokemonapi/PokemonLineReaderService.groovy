package pokemonapi

class PokemonLineReaderService {

    Pokemon readPokemonFromCsvLine(final String pokemonCsvLine) {
        final List<String> columns = pokemonCsvLine.split(',')

        final Pokemon pokemon = new Pokemon(
                number: columns[0].toInteger(),
                name: columns[1],
                type1: columns[2],
                type2: columns[3],
                total: columns[4].toInteger(),
                hp: columns[5].toInteger(),
                attack: columns[6].toInteger(),
                defense: columns[7].toInteger(),
                spAtl: columns[8].toInteger(),
                spDef: columns[9].toInteger(),
                speed: columns[10].toInteger(),
                generation: columns[11].toInteger(),
                legendary: columns[12].toBoolean(),
        )

        return pokemon
    }

}
