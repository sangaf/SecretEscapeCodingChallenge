package secretescapecodingchallenge

import org.springframework.stereotype.Controller

@Controller
class TransactionInfoController {

    AccountService accountService

    def showTransaction() {
        render(view:"transaction", model:[accounts: accountService.accountList])
    }

    def submitAccount(){
        render(view:"transaction", model: buildModelForSubmit(params.accountName))
    }

    private LinkedHashMap<String, Object> buildModelForSubmit(String accountName) {
        [accounts: accountService.accountList,
         accountHistory: accountService.getTransactionsByName(accountName),
         account: accountService.getAccountByName(accountName)]
    }

}
