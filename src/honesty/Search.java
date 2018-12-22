
package honesty;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Search {
    User user=new User();
    Item item=new Item();
    Connection Connect = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;
    
    public Search() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost/SW?user=root");
            statement = Connect.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void searchEnterData()
    {  
          String Category = null;
          int choose;
        System.out.println("Enter number of item's Category :");
        System.out.println("1-Accessories ** 2-Bags ** 3-Electronics ** 4-Personal belongings ** 5-others ");
        Scanner ob2=new Scanner(System.in);
        choose=ob2.nextInt();
        switch (choose) {
            case 1:
                Category="Accessories";
                break;
            case 2:
                Category="Bags";
                break;
            case 3:
                Category="Electronics";
                break;
            case 4:
                Category="Personal belongings";
                break;
            case 5:
                Category="others";
                break;
            default:
                break;
        }  
          search(Category);
    }
    
    public void search(String Category)
    {    
 
    
     
    String Query="select * from iteminfo where category='" + Category+ "'" ;
    boolean Excists = false;
    try {
            resultSet = statement.executeQuery(Query);
        System.out.println("/***************Posts*********************/");    
      while (resultSet.next()){
            item.Category=(resultSet.getString("category"));
            item.color= (resultSet.getString("color"));
            item.Locationfoundeditem= (resultSet.getString("location"));
            item.Date_day= (resultSet.getInt("dateday"));
            item.Date_month= (resultSet.getInt("datemonth"));
            item.Item_ID= (resultSet.getInt("id"));
            item.Description= (resultSet.getString("description"));
            item.user_id= (resultSet.getInt("userid"));
            System.out.print(item.Description+"  --> ID: ");
            System.out.println(item.Item_ID);
            Excists = true; 
            }    
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (Excists) {
            System.out.println(" success ") ;
            
        } else {
            System.out.println(" No Posts ") ;
        }
 }
}


