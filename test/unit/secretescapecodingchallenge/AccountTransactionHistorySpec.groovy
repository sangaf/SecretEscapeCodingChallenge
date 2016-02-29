package secretescapecodingchallenge

import grails.test.mixin.TestFor
import spock.lang.Specification

import static secretescapecodingchallenge.TestFixtures.ACCOUNT_TRANSACTION_LIST
import static secretescapecodingchallenge.TestFixtures.HISTORY
import static secretescapecodingchallenge.TestFixtures.SOME_ACCOUNT_NAME

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(AccountTransactionHistory)
class AccountTransactionHistorySpec extends Specification {

    AccountTransactionHistory accountTransactionHistory = new AccountTransactionHistory()

    def setup() {
    }

    def cleanup() {
    }

    void "getTransactionHistoryByName returns a list of transactions of the account"() {
        given:
            accountTransactionHistory.transactionHistory = HISTORY
        expect:
            accountTransactionHistory.getTransactionHistoryByName(SOME_ACCOUNT_NAME) == ACCOUNT_TRANSACTION_LIST
    }

    void "initilize method set the value of transactionHistory property"(){
        when:
            accountTransactionHistory.initialize([HISTORY])
        then:
            accountTransactionHistory.transactionHistory == HISTORY

    }
}
