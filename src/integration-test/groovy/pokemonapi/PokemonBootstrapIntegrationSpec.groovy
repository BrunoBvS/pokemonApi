package pokemonapi

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class PokemonBootstrapIntegrationSpec extends Specification {

    void 'boot should load every pokemon from original csv resource'() {
        expect:
        Pokemon.count == 800
    }

}
