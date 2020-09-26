class BankAccount {
    private double balance;
    private boolean isOpen;

    public BankAccount() {
        balance = 0; 
    }
    public void open() {
       isOpen = true;
    }
    public synchronized void deposit(double amount) throws BankAccountActionInvalidException {
        if (!isOpen)
            throw new BankAccountActionInvalidException("Account closed");
        if (amount > 0)
            balance += amount;
        else
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
    }
    public synchronized void withdraw(double amount) throws BankAccountActionInvalidException {
        if (!isOpen)
            throw new BankAccountActionInvalidException("Account closed");
        if (amount <= 0)
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        if (balance >= amount)
            balance -= amount;
        else
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
    }
    public synchronized double getBalance() throws BankAccountActionInvalidException {
        if (!isOpen)
            throw new BankAccountActionInvalidException("Account closed");
        return balance;
    }
    public void close() {
        isOpen = false;
    }
}