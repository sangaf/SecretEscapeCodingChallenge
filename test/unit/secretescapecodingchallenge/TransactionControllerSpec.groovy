package secretescapecodingchallenge

import grails.test.mixin.TestFor
import org.springframework.validation.Errors
import spock.lang.Specification

import static secretescapecodingchallenge.TestFixtures.*

@TestFor(TransactionController)
class TransactionControllerSpec extends Specification {

    public static final String FROM = 'from'
    public static final String TO = 'to'
    public static final double AMOUNT = 50
    AccountService accountServiceMock = Mock(AccountService)
    TransactionService transactionServiceMock = Mock(TransactionService)
    Pay commandMock = Mock(Pay)


    def setup() {
        controller.accountService = accountServiceMock
        controller.transactionService = transactionServiceMock
    }

    def cleanup() {
    }

    void "showPay renders pay view with list of accounts"() {
        when:
            1 * accountServiceMock.accountList >> ACCOUNTS
            controller.showPay()
        then:
            view == "/transaction/pay"
            model.accounts == ACCOUNTS
    }

    void "payToAccount do transaction"(){
        given:
            1 * commandMock.hasErrors() >> false
            1 * commandMock.accountFrom >> FROM
            1 * commandMock.accountTo >> TO
            1 * commandMock.amount >> AMOUNT
        and:
            1 * accountServiceMock.getAccountByName(FROM) >> ACCOUNT1
            1 * accountServiceMock.getAccountByName(TO) >> ACCOUNT2
            1 * accountServiceMock.getAccountList() >> ACCOUNTS
        and:
            1 * transactionServiceMock.pay(ACCOUNT1, ACCOUNT2, AMOUNT)

        when:
            controller.payToAccount(commandMock)

        then:
            view == "/transaction/pay"
            model.accounts == ACCOUNTS
            model.command == commandMock
            model.transactionSuccessful == true
            model.fromBalance == ACCOUNT1.balance
            model.toBalance == ACCOUNT2.balance

    }

    void "payToAccount do transaction throws insufficient func exception"(){
        given:
            1 * commandMock.hasErrors() >> false
            2 * commandMock.accountFrom >> FROM
            1 * commandMock.accountTo >> TO
            1 * commandMock.amount >> AMOUNT
        and:
            Errors errorsMock = Mock(Errors)
            1 * commandMock.getErrors() >> errorsMock
        and:
            1 * accountServiceMock.getAccountByName(FROM) >> ACCOUNT1
            1 * accountServiceMock.getAccountByName(TO) >> ACCOUNT2
            1 * accountServiceMock.getAccountList() >> ACCOUNTS
        and:
            1 * transactionServiceMock.pay(ACCOUNT1, ACCOUNT2, AMOUNT) >> {throw new InsufficientBalanceException()}

        when:
            controller.payToAccount(commandMock)

        then:
            view == "/transaction/pay"
            model.accounts == ACCOUNTS
            model.command == commandMock
        and:
            1 * errorsMock.reject("insufficient.balance", "Not enough balance in ${FROM}'s account")


    }

    def "payToAccount renders pay view with only accountlist and command"(){
        given:
            1 * commandMock.hasErrors() >> true
        and:
            Errors errorsMock = Mock(Errors)
            1 * commandMock.getErrors() >> errorsMock
            1 * errorsMock.reject("blank", "Every field is required")
        and:
            1 * accountServiceMock.getAccountList() >> ACCOUNTS
            0 * _
        when:
            controller.payToAccount(commandMock)
        then:
            view == "/transaction/pay"
            model.accounts == ACCOUNTS
            model.command == commandMock
    }

}
