public class Transaction {
    public static void transfer(Account fromAccount, Account toAccount, double amount) throws InsufficientFundsException, IllegalArgumentException {
        fromAccount.withdraw(amount);
        try {
            toAccount.deposit(amount);
        } catch (IllegalArgumentException e) {
            /* Если трансфер не прошел , возвращаем деньги обратно*/
            fromAccount.deposit(amount);
            throw new RuntimeException("Не удалось перевести деньги: " + e.getMessage());
        }
    }
}