import secretescapecodingchallenge.Account
import secretescapecodingchallenge.AccountTransaction
import secretescapecodingchallenge.AccountTransactionHistory
import secretescapecodingchallenge.Accounts

class BootStrap {

    Accounts accounts
    AccountTransactionHistory accountTransactionHistory

    def init = { servletContext ->

        List<Account> accountList = [
                new Account(name:"Sanjida", email: "sanjida@email.com", balance: 200),
               new Account(name:"John", email: "john@email.com", balance: 200),
                new Account(name:"Marcos", email: "marcos@email.com", balance: 200)
        ]

        accounts.initializeAccounts(accountList)

        List<AccountTransaction> transaction1 = [
                new AccountTransaction(date: new Date().parse("dd.MM.yyy", '18.05.2015'), description: "Debenhams", amount: 120),
                new AccountTransaction(date: new Date().parse("dd.MM.yyy", '08.11.2014'), description: "Costa Coffee", amount: 10.89),
                new AccountTransaction(date: new Date().parse("dd.MM.yyy", '05.01.2013'), description: "Money Transfer", amount: 95)
        ]

        List<AccountTransaction> transaction2 = [
                new AccountTransaction(date: new Date().parse("dd.MM.yyy", '07.02.2012'), description: "Picture House", amount: 55),
                new AccountTransaction(date: new Date().parse("dd.MM.yyy", '30.05.2013'), description: "T-mobile", amount: 35.66),
                new AccountTransaction(date: new Date().parse("dd.MM.yyy", '28.02.2016'), description: "Waterstone", amount: 78.99)
        ]

        List<AccountTransaction> transaction3 = [
                new AccountTransaction(date: new Date().parse("dd.MM.yyy", '17.03.2015'), description: "Stratford Westfields", amount: 113.75),
                new AccountTransaction(date: new Date().parse("dd.MM.yyy", '06.06.2013'), description: "Build-A-Bear", amount: 65.45),
                new AccountTransaction(date: new Date().parse("dd.MM.yyy", '13.11.2015'), description: "Money Transfer", amount: 100)
        ]

        List<Map<String, List<AccountTransaction>>> history = [
                ["sanjida":transaction1],
                ["john":transaction2],
                ["marcos":transaction3]
        ]

        accountTransactionHistory.initialize(history)
    }

    def destroy = {
    }
}
