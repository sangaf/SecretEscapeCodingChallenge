package secretescapecodingchallenge

import grails.test.mixin.TestFor
import spock.lang.Specification

import static secretescapecodingchallenge.TestFixtures.ACCOUNTS

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Accounts)
class AccountsSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "initializeAccounts set value of accountList"() {
        given:
            domain.initializeAccounts(ACCOUNTS)
        expect:
            domain.accountList == ACCOUNTS
    }
}
