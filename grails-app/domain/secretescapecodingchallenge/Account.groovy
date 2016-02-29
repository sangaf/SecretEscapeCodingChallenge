package secretescapecodingchallenge

class Account {

    String name
    String email
    Double balance

    void addToBalance(Double amount){
        balance += amount
    }

    void deductFromBalance(Double amount){
        balance -= amount
    }


}
