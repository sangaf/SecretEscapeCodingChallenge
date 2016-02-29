package secretescapecodingchallenge

import grails.validation.Validateable

@Validateable
class Pay {

    String accountFrom
    String accountTo
    Double amount

    static constraints = {
        accountFrom (blank:false)
        accountTo (blank: false)
        amount (blank:false)
    }
}
