package honesty;

public class User {
    String UserName ;
    String UserPassword;
    String UserEmail;
    int UserPhone;
    int UserID=0;
    public static int counter=0;
    public User()
    {
        counter++;
        this.UserID=counter;
    }
    
}
