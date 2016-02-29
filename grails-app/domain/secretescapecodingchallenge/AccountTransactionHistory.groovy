package secretescapecodingchallenge

class AccountTransactionHistory {

    Map<String, List<AccountTransaction>> transactionHistory

    List<AccountTransaction> getTransactionHistoryByName(String name){
        transactionHistory.get(name.toLowerCase())
    }

    void initialize(List<Map<String, List<AccountTransaction>>> history){
        transactionHistory = new HashMap<String, List<AccountTransaction>>()
        history.each { Map entry ->
            entry.each {k, v ->
                transactionHistory.put(k, v)
            }

        }
    }


}
