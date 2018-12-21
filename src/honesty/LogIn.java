
package honesty;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class LogIn {

    User user=new User();
    Connection Connect = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;
    
    public LogIn() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost/SW?user=root");
            //Don't forget the db name
            statement = Connect.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void log_in()
    {  
          String mail,password;
          System.out.println("Enter your  E-mail :");
          Scanner ob1=new Scanner(System.in);
          mail=ob1.next() ;
          System.out.println("Enter your  Password :");
          Scanner ob2=new Scanner(System.in);
          password=ob2.next() ;  
          search(mail ,password);
    }
    
    public void search(String email , String pass)
    {    
 
    
     
    String Query="select * from userinfo where email='" + email+ "' and password='" + pass+ "'";
    boolean Excists = false;
  try {
           // Connect.prepareStatement(Query).executeUpdate();
            resultSet = statement.executeQuery(Query);
            System.out.println("honesty.LogIn.search()");
      while (resultSet.next()){
            user.UserEmail=(resultSet.getString("email"));
            user.UserPassword= (resultSet.getString("password"));
            user.UserName= (resultSet.getString("username"));
            user.UserPhone= (resultSet.getInt("phone"));
            user.UserID= (resultSet.getInt("id"));
           System.out.println(user.UserName);
            Excists = true; 
            }    
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (Excists) {
            System.out.println(" success ") ;
            
        } else {
            System.out.println(" fail because you should make signup at first ") ;
        }
      
      
      
      
      /*if( user.password== pass && user.e_mail==email )
                System.out.println("Successfully log in");
            else 
                System.out.println(" Error log in !! ");
        } catch (Exception ex) {
            ex.printStackTrace();
            }*/ 
 }
}
