package secretescapecodingchallenge

import grails.test.mixin.TestFor
import junit.framework.Test
import spock.lang.Specification

import static secretescapecodingchallenge.TestFixtures.ACCOUNT
import static secretescapecodingchallenge.TestFixtures.ACCOUNTS
import static secretescapecodingchallenge.TestFixtures.ACCOUNTS
import static secretescapecodingchallenge.TestFixtures.ACCOUNT_TRANSACTION
import static secretescapecodingchallenge.TestFixtures.ACCOUNT_TRANSACTION_LIST
import static secretescapecodingchallenge.TestFixtures.HISTORY
import static secretescapecodingchallenge.TestFixtures.SOME_ACCOUNT_NAME

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AccountService)
class AccountServiceSpec extends Specification {

    Accounts accountsMock = Mock()
    AccountTransactionHistory accountTransactionHistoryMock = Mock()

    def setup() {
        service.accounts = accountsMock
        service.accountTransactionHistory = accountTransactionHistoryMock
    }

    def cleanup() {
    }

    void "getAccountList retrieves a list of accounts"() {
        given:
            1 * accountsMock.accountList >> ACCOUNTS
        expect:
            service.getAccountList() == ACCOUNTS
    }

    void "getAccountByName returns an account by name"(){
        given:
            1 * accountsMock.accountList >> ACCOUNTS
        expect:
            service.getAccountByName(SOME_ACCOUNT_NAME) == ACCOUNT
    }

    void "getTransactionsByName returns a list of transactions"(){
        given:
           1 * accountTransactionHistoryMock.getTransactionHistoryByName(SOME_ACCOUNT_NAME) >> ACCOUNT_TRANSACTION_LIST
        expect:
            service.getTransactionsByName(SOME_ACCOUNT_NAME) == ACCOUNT_TRANSACTION_LIST
    }

}
