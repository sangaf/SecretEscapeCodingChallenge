package secretescapecodingchallenge

class TestFixtures {
    static final String SOME_ACCOUNT_NAME = "someAccountName"
    static final def ACCOUNT = new Account(name:SOME_ACCOUNT_NAME, email:"some@email.com",balance: 200)
    static final def ACCOUNT1 = new Account(name:"Sanjida", email: "sanjida@email.com", balance: 200)
    static final def ACCOUNT2 = new Account(name:"John", email: "john@email.com", balance: 200)
    static final def ACCOUNT3 = new Account(name:"Marcos", email: "marcos@email.com", balance: 200)

    static final def ACCOUNT_TRANSACTION = new AccountTransaction(date: new Date().parse("dd.MM.yyy", '18.05.2015'), description: "Debenhams", amount: 120)
    static final def ACCOUNT_TRANSACTION_LIST = [ACCOUNT_TRANSACTION]

    static final  Map<String, List<AccountTransaction>> HISTORY = [(SOME_ACCOUNT_NAME.toLowerCase()): ACCOUNT_TRANSACTION_LIST]


    static final List<Account> ACCOUNTS = [
            ACCOUNT, ACCOUNT1, ACCOUNT2, ACCOUNT3
    ]
}
