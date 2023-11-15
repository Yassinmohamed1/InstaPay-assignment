public class AccountBLL {
    public  AccountDLL Account;

    public AccountBLL()
    {
        Account=new AccountDLL();
    }

public void  InsertAccount(Account account,long user_Id){
        account.UserId=user_Id;
        Account.InsertAccount(account);
}

public  Account GetAccount(long account_id){
        return Account.RetrieveAccount(account_id);
}

public Double GetBalance(long user_Id){
        return Account.GetBalance(user_Id);
}

    public boolean TransferToAnotherAccount(long SenderAccountId,long ReceiverAccountId,double Balance){
        return Account.TransferToAnotherAccount(SenderAccountId,ReceiverAccountId,Balance);
    }

}
