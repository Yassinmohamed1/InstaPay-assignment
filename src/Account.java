import javax.sql.DataSource;

public class Account {
    public String AccountNumber;
    public double Balance;
    public AccountType AccountType;
    public long UserId;
    public long Id;

    public AccountType getAccountType() {
        return AccountType;
    }

    public double getBalance() {
        return Balance;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public void setAccountType(AccountType accountType) {
        AccountType = accountType;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public long getUserId() {
        return UserId;
    }

    public long getId() {
        return Id;
    }
}
