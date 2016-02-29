package secretescapecodingchallenge

import grails.test.mixin.TestFor
import junit.framework.Test
import spock.lang.Specification

import static secretescapecodingchallenge.TestFixtures.ACCOUNT1
import static secretescapecodingchallenge.TestFixtures.ACCOUNT2

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(TransactionService)
class TransactionServiceSpec extends Specification {

    public static final double AMOUNT = 50
    SEMailService seMailServiceMock = Mock(SEMailService)

    def setup() {
        service.seMailService = seMailServiceMock
    }

    def cleanup() {
    }

    void "pay deduct from fromAccount and add to toAccount and send mail to both account holders"() {
        given:
            def account1PreviousBalance = ACCOUNT1.balance
            def account2PreviousBalance = ACCOUNT2.balance

        and:
            2 * seMailServiceMock.mailTo(_)

        when:
            service.pay(ACCOUNT1, ACCOUNT2, AMOUNT)

        then:
            ACCOUNT1.balance == (account1PreviousBalance - AMOUNT)
            ACCOUNT2.balance == (account2PreviousBalance + AMOUNT)

    }
}
