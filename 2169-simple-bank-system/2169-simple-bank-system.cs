public class Bank {
    private long[] balance; 
    public Bank(long[] balance) {
        this.balance = balance;
    }
    private bool IsValidAccount(int account)
    {
        return account >= 1 && account <= balance.Length;
    }
    public bool Transfer(int account1, int account2, long money) {
        if (!IsValidAccount(account1) || !IsValidAccount(account2))
            return false; // Invalid accounts

        if (balance[account1 - 1] < money)
            return false; // Not enough funds in account1

        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }
    
    public bool Deposit(int account, long money) {
        if (!IsValidAccount(account))
            return false; // Invalid account

        balance[account - 1] += money;
        return true;
    }
    
    public bool Withdraw(int account, long money) {
        if (!IsValidAccount(account))
            return false; // Invalid account

        if (balance[account - 1] < money)
            return false; // Not enough funds

        balance[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * bool param_1 = obj.Transfer(account1,account2,money);
 * bool param_2 = obj.Deposit(account,money);
 * bool param_3 = obj.Withdraw(account,money);
 */