public class User {
    public  long UserId;
    public  String UserName;
    public  String FirstName;
    public  String SecondName;
    public  String PhoneNumber;
    public  String Password;

    public Account Account;


    public String get_UserName() {
        return UserName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void set_UserName(String userName) {
        UserName = userName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public Account get_Account() {
        return Account;
    }

    public void set_Account(Account account) {
        Account = account;
    }
    public long get_User_Id() {
        return UserId;
    }

    public void set_User_Id(long userId) {
        UserId = userId;
    }

    public String get_Phone_Number() {
        return PhoneNumber;
    }

    public void set_Phone_Number(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String get_Password() {
        return Password;
    }

    public void set_Password(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

}
