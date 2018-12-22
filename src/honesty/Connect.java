
package honesty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Connect {
    
    User user=new User();
    Item item=new Item();
    Connection Connect = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;
    
    public Connect() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost/SW?user=root");
            statement = Connect.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void EnterDataConnect()
    {  
          int PostID;
          System.out.println("Enter Post ID :");
          Scanner ob1=new Scanner(System.in);
          PostID=ob1.nextInt();  
          GetInfo(PostID);
    }
    
    public void GetInfo(int PostID)
    {
        String Query="select * from iteminfo where id='" + PostID+ "'" ;
        boolean Excists = false;
        try {
            resultSet = statement.executeQuery(Query);    
            while (resultSet.next()){
            item.Category=(resultSet.getString("category"));
            item.color= (resultSet.getString("color"));
            item.Locationfoundeditem= (resultSet.getString("location"));
            item.Date_day= (resultSet.getInt("dateday"));
            item.Date_month= (resultSet.getInt("datemonth"));
            item.Item_ID= (resultSet.getInt("id"));
            item.Description= (resultSet.getString("description"));
            item.user_id= (resultSet.getInt("userid"));
            Excists = true; 
            }    
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (Excists) {
            System.out.println(" success ") ;
            AnswerQuestion();
            
        } else {
            System.out.println(" invalid input ") ;
        }
 }
    public boolean AnswerQuestion()
    {
        boolean Flag = false;
        Item obj2= new Item();
        System.out.println("*******Please Answer this Question :");
            System.out.println("Enter item's color :");
            Scanner ob1=new Scanner(System.in);
            obj2.color=ob1.nextLine();
             System.out.println("Enter The day on which you found item :");
            Scanner ob4=new Scanner(System.in);
            obj2.Date_day=ob4.nextInt();
           System.out.println("Enter The month on which you found item :");
            Scanner ob5=new Scanner(System.in);
            obj2.Date_month=ob5.nextInt();
            
            if((item.color.equals(obj2.color))&&(item.Date_day==obj2.Date_day)&&(item.Date_month==obj2.Date_month))
            {
                Flag=true;
                ViewUserInfo();
            }
            else
                System.out.println("Incorrect Answer");
            
     
            return Flag ;
    }
    public void ViewUserInfo()
    {
         String Query="select * from userinfo where id='" + item.user_id+ "'" ;
        boolean Excists = false;
        try {
            resultSet = statement.executeQuery(Query);    
            while (resultSet.next()){
            user.UserEmail=(resultSet.getString("email"));
            user.UserPassword= (resultSet.getString("password"));
            user.UserName= (resultSet.getString("username"));
            user.UserPhone= (resultSet.getInt("phone"));
            user.UserID= (resultSet.getInt("id"));
            Excists = true; 
            }    
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (Excists) {
            System.out.println("Person's info: ");
            System.out.println("Person's Name: "+user.UserName);
            System.out.println("Person's Phone: "+user.UserPhone);
            
            
        } else {
            System.out.println(" Error ") ;
        }
    }
    
}



    

