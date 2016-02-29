package secretescapecodingchallenge


class AccountService {

    static transactional = false

    Accounts accounts
    AccountTransactionHistory accountTransactionHistory

    List<Account> getAccountList() {
        accounts.accountList
    }

    Account getAccountByName(String name){
        accounts.accountList.find {it.name == name}
    }

    List<AccountTransaction> getTransactionsByName(String name){
        accountTransactionHistory.getTransactionHistoryByName(name)
    }


}
