package secretescapecodingchallenge


class TransactionService {

    static transactional = false

    SEMailService seMailService

    def pay(Account from, Account to, Double amount) throws InsufficientBalanceException{
        if(amount>from.balance){
            throw new InsufficientBalanceException()
        }

        to.addToBalance(amount)
        from.deductFromBalance(amount)
        seMailService.mailTo(mailToAccountTransferred(from, to, amount))
        seMailService.mailTo(mailToAccountReceived(from, to, amount))

    }

    Map mailToAccountTransferred(Account from, Account to, Double amount){
        [to: "${from.email}",
        subject: "Successfully transferred to ${to.name} £${amount}",
        body: "£${amount} has been trnsferrred to ${to.name}"]
    }

    Map mailToAccountReceived(Account from, Account to, Double amount){
        [to: "${to.email}",
         subject: "Successfully received £${amount} from ${from.name}",
         body: "£${amount} has been received from ${from.name}"]
    }
}
