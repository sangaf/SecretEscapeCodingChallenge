package secretescapecodingchallenge

class TransactionController {

    AccountService accountService
    TransactionService transactionService


    def showPay(){
        render(view:"pay", model:[accounts:accountService.getAccountList()])
    }


    def payToAccount(Pay command) {
        if(command.hasErrors()){
            command.errors.reject("blank", "Every field is required")
            return render(view:"pay", model:[accounts:accountService.getAccountList(), command:command])
        }
        Account from = accountService.getAccountByName(command.accountFrom)
        Account to = accountService.getAccountByName(command.accountTo)

        try {
            transactionService.pay(from, to, command.amount)
            return render(view:"pay", model: buildSuccessModel(command, from, to))
        } catch (InsufficientBalanceException ex) {
            command.errors.reject("insufficient.balance", "Not enough balance in ${command.accountFrom}'s account")
            return render(view:"pay", model:[accounts:accountService.getAccountList(), command:command])
        }

    }

    private LinkedHashMap<String, Object> buildSuccessModel(Pay command, Account from, Account to) {
        [accounts: accountService.getAccountList(), command: command, transactionSuccessful: true, fromBalance: from.balance, toBalance: to.balance]
    }
}
