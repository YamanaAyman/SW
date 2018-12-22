
package honesty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class MakePost {
    
    User obj1=new User();
    Item obj2=new Item();
    Connection Connect = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;
    
    public MakePost()
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
    
 public void make_post()
 {
     int choose;
     System.out.println("******************Make Post*******************");
     System.out.println("Enter your post :");
     Scanner ob=new Scanner(System.in);
     obj2.Description=ob.nextLine();
     System.out.println("Enter number of item's Category :");
     System.out.println("1-Accessories ** 2-Bags ** 3-Electronics ** 4-Personal belongings ** 5-others ");
     Scanner ob2=new Scanner(System.in);
     choose=ob2.nextInt();
        switch (choose) {
            case 1:
                obj2.Category="Accessories";
                break;
            case 2:
                obj2.Category="Bags";
                break;
            case 3:
                obj2.Category="Electronics";
                break;
            case 4:
                obj2.Category="Personal belongings";
                break;
            case 5:
                obj2.Category="others";
                break;
            default:
                break;
        }
     System.out.println("Enter item's color :");
     Scanner ob1=new Scanner(System.in);
     obj2.color=ob1.nextLine();
     System.out.println("Enter item's location :");
     Scanner ob3=new Scanner(System.in);
     obj2.Locationfoundeditem=ob3.nextLine();
      System.out.println("Enter The day on which you found item :");
     Scanner ob4=new Scanner(System.in);
     obj2.Date_day=ob4.nextInt();
    System.out.println("Enter The month on which you found item :");
     Scanner ob5=new Scanner(System.in);
     obj2.Date_month=ob5.nextInt();     
    
 }
   public void save_info(int userid) throws IOException 
 {
        
        obj2.Item_ID=getIDAndSaveID();
        String Query = "INSERT INTO iteminfo(category,color,location,dateday,datemonth,id,description,userid) VALUES(?,?,?,?,?,?,?,?)";
        obj2.user_id=userid;
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(Query)) {
            pstmt.setString(1, obj2.Category);
            pstmt.setString(2, obj2.color);
            pstmt.setString(3, obj2.Locationfoundeditem);
            pstmt.setInt(4, obj2.Date_day);
            pstmt.setInt(5, obj2.Date_month);
            pstmt.setInt(6, obj2.Item_ID);
            pstmt.setString(7, obj2.Description);
            pstmt.setInt(8,obj2.user_id );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 }
   public int getIDAndSaveID() throws IOException
   {
       int id=0;
       ////////////////////////* get from file *////////////////////////////////
        try    
                    {
                        String pointer="";
                        File fileName =new File("Item_ID.txt");
                        FileReader fileReader =  new FileReader(fileName);
                        BufferedReader bufferedReader =  new BufferedReader(fileReader);
                        while((pointer = bufferedReader.readLine()) != null)
                        {  
                            id = Integer.parseInt(pointer); 
                            //System.out.println("POinter "+pointer );
                        }
                    }
                catch (Exception ex)
                      {
                        System.out.println("*-*Error Message");
                      }
       
       ////////////////////////* put from file *////////////////////////////////
          id++;
        try    
               {
                   FileWriter FOut =new FileWriter("Item_ID.txt");
                 
                       String COMPRESSION=""+(id);
                       FOut.write(COMPRESSION);
                       FOut.write("\n");  
                       FOut.close();
               }
               catch (Exception ex)
               {
                   System.out.println("Error Message");
               }
       return id;
   }
    
}

