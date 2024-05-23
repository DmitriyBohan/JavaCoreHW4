public class Account {

     double balance;

    /**
     * конструктор создания счета с проверкой  */
    public Account(double initialBalance) throws IllegalArgumentException {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным ");
        }
        this.balance = initialBalance;
    }

    /**
     * метод внесения депозита с проверкой на отрицательное значение
     */
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма депозита не может быть отрицательной.");
        }
        balance += amount;
    }

    /**
     * метод вывода средств с счета с проверкой на отрицатльный остаток
     * */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств. Текущий баланс: " + balance);
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
