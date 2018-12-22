
package honesty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
    Item item=new Item();
    Connection Connect = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;
    
    public Delete() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost/SW?user=root");
            statement = Connect.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
      private Connection connect() {
        String url = "jdbc:mysql://localhost/SW?user=root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void DeletePost(int userID)
    {  
        String Query="select * from iteminfo where userid='" + userID+ "'" ;
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
          int choose;
        System.out.println("Enter PostID :");
        Scanner ob2=new Scanner(System.in);
        choose=ob2.nextInt();
         String Queryy = "DELETE FROM iteminfo WHERE id =? ";
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(Queryy)) {
            pstmt.setInt(1, choose);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
   }
}

