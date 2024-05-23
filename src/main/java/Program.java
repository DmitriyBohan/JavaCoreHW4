/**
 * Уважаемые студенты. Внезапно, редактирование ДЗ не работает, возможно, это ошибка, в таком случае, озвучу текст ДЗ тут:
 * <p>
 * Создать программу управления банковским счетом (Account).
 * Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита и сумму снятия средств.
 * При этом она должна обрабатывать следующие исключительные ситуации:
 * <p>
 * Попытка создать счет с отрицательным начальным балансом должна вызывать исключение
 * IllegalArgumentException с соответствующим сообщением.
 * Попытка внести депозит с отрицательной суммой должна вызывать исключение
 * IllegalArgumentException с соответствующим сообщением.
 * Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать исключение
 * InsufficientFundsException с сообщением о недостаточных средствах и текущим балансом.
 * <p>
 * Продемонстрируйте работу вашего приложения:
 * Программа должна обрабатывать все исключения с помощью конструкции try-catch,
 * выводя соответствующие сообщения об ошибках.
 * <p>
 * 2*.
 * Создать несколько типов счетов, унаследованных от Account, например: CreditAcciunt, DebitAccount.
 * Создать класс (Transaction), позволяющий проводить транзакции между счетами (переводить сумму с одного счета на другой)
 * <p>
 * Класс Transaction должен возбуждать исключение в случае неудачной попытки перевести деньги с одного счета на другой.
 * <p>
 * Продемонстрируйте работу вашего приложения:
 * Программа должна обрабатывать все исключения с помощью конструкции try-catch,
 * выводя соответствующие сообщения об ошибках.
 * <p>
 * Достаточно выпонить только первую задачу, вторая задача является дополнительной.
 */

public class Program {
    public static void main(String[] args) {
        try {
            Account account = new Account(1000);
            System.out.println("Баланс счета: " + account.getBalance());

            account.deposit(250);
            System.out.println("Баланс после депозита: " + account.getBalance());

            account.withdraw(300);
            System.out.println("Баланс после снятия: " + account.getBalance());

            /**
             * обработка исключений
             * */
            try {
                Account negativeBalanceAccount = new Account(-100);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            try {
                account.deposit(-50);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            try {
                account.withdraw(1050);
            } catch (InsufficientFundsException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        }


        System.out.println("Задание №2");

        /**
         * Создаем кредитный и дебетовый счет */
        try {
            CreditAcciunt creditAccount = new CreditAcciunt(500);
            DebitAccount debitAccount = new DebitAccount(200);
            System.out.println("Баланс кредитного счета: " + creditAccount.getBalance());
            System.out.println("Баланс дебетового счета: " + debitAccount.getBalance());

            try {
                Transaction.transfer(creditAccount, debitAccount, 100);
                System.out.println("Баланс кредитного счета после перевода: " + creditAccount.getBalance());
                System.out.println("Баланс дебетового счета после перевода: " + debitAccount.getBalance());
            } catch (InsufficientFundsException e) {
                System.out.println("Ошибка транзакции: " + e.getMessage());
            }


            /**
             * обработка исключений
             * */
            try {
                Transaction.transfer(debitAccount, creditAccount, 1000);
            } catch (InsufficientFundsException e) {
                System.out.println("Ошибка транзакции: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        }
    }


}


