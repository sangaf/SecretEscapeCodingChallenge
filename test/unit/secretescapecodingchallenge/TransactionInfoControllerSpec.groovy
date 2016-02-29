package secretescapecodingchallenge

import grails.test.mixin.TestFor
import spock.lang.Specification

import static secretescapecodingchallenge.TestFixtures.*
import static secretescapecodingchallenge.TestFixtures.ACCOUNTS
import static secretescapecodingchallenge.TestFixtures.SOME_ACCOUNT_NAME

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TransactionInfoController)
class TransactionInfoControllerSpec extends Specification {

    AccountService accountServiceMock = Mock()


    def setup() {
        controller.accountService = accountServiceMock
    }

    def cleanup() {
    }

    void "show transation displays transaction view"() {
        given:
            1 * accountServiceMock.getAccountList() >> ACCOUNTS
        when:
           controller.showTransaction()
        then:
            view == '/transaction/transaction'

            model.accounts == ACCOUNTS
    }

    void "submit builds model with transaction history and account"(){
        given:
            params.accountName = SOME_ACCOUNT_NAME
            1 * accountServiceMock.getTransactionsByName(SOME_ACCOUNT_NAME) >> ACCOUNT_TRANSACTION_LIST
            1 * accountServiceMock.getAccountByName(SOME_ACCOUNT_NAME) >>  ACCOUNT
            1 * accountServiceMock.getAccountList() >> ACCOUNTS
        when:
            controller.submitAccount()
        then:
            view == "/transaction/transaction"
            model.accounts == ACCOUNTS
            model.accountHistory == ACCOUNT_TRANSACTION_LIST
            model.account == ACCOUNT
    }
}
