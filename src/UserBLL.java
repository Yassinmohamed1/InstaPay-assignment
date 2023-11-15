public class UserBLL {

private  UserDLL User;
public  UserBLL()
{
    User=new UserDLL();
}

    public  void  SignUP(User user){
        User.InsertUser(user);
    }

    public  boolean  SignIn(String UserName,String Password){

var LoginInfo= User.GetLoginInfo(UserName,Password);
if (LoginInfo.Password==Password){
    return  true;
}
return  false;

    }
}
