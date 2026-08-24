
public class ATMService {

    // OVERLOADING
    public void deposit(Account account, double amount) {

        account.deposit(amount);

        System.out.printf(
                "Deposited PHP %.2f%n",
                amount
        );
    }

    public void deposit(Account account,
                        double amount,
                        String note) {

        account.deposit(amount);

        System.out.printf(
                "Deposited PHP %.2f%n",
                amount
        );

        System.out.println("Note: " + note);
    }

    // VARARGS
    public double depositAll(Account account,
                             double... amounts) {

        double total = 0;

        for (double amount : amounts) {
            account.deposit(amount);
            total += amount;
        }

        return total;
    }

    // PASS-BY-VALUE DEMO
    public void tryToReplace(Account account) {

        account = new SavingsAccount(
                "XX-000",
                "Ghost Account",
                0,
                0
        );

        System.out.println(
                "Inside the method : " + account
        );

        /*
         * Java passes the object reference by value.
         * Reassigning this local parameter does not change
         * the account variable in main().
         */
    }

    public void addBonus(Account account, double bonus) {

        account.deposit(bonus);

        /*
         * The object's data is changed through the copied reference,
         * so the change is visible to the caller.
         */
    }

    // TRANSFER
    public void transfer(Account from,
                         Account to,
                         double amount)
            throws InsufficientFundsException {

        from.withdraw(amount);
        to.deposit(amount);
    }
}