public class Account {

     double balance;

    public Account(double initialBalance) throws IllegalArgumentException {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным ");
        }
        this.balance = initialBalance;
    }




}
