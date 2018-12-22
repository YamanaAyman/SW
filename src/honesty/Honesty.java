
package honesty;
import java.util.Scanner;
import honesty.DBConnection;
import java.io.IOException;
public class Honesty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
         DBConnection conn = new DBConnection();
            conn.Connectiontomysql();
            int userid = 0;
            int input ;
            while (true)
            {
                while(true)
                {
                    System.out.println("***************** Honesty APP ****************");
                    System.out.println("1-LOGIN");
                    System.out.println("2-SIGNUP");
                   Scanner in=new Scanner(System.in) ;
                   input=in.nextInt();
                   if(input==1)
                   {
                       LogIn i=new LogIn();
                       userid=i.log_in();
                   }
                   if(input==2)
                   {
                      SignUp s= new SignUp();
                      s.signup();
                      s.save_info();
                   }
                   if(userid!=0)
                       break;
                }
                System.out.println("*************YOU ARE NOW LOGED IN***********");
                System.out.println("1-MAKE A POST");
                System.out.println("2-SEARCH ");
                System.out.println("3-DELETE POST");
                System.out.println("4-UPDATE POST");
                Scanner inn=new Scanner(System.in) ;
                 input=inn.nextInt();
                 if(input==1)
                 {
                     MakePost m= new MakePost();
                     m.make_post();
                     m.save_info(userid);
                 }
                 if(input==2)
                 {
                     Search s= new Search();
                     s.searchEnterData();
                     System.out.println("5-TO MAKE CONNECT");
                     System.out.println("0-TO END");
                     Scanner innn=new Scanner(System.in) ;
                     int inputt=innn.nextInt();
                     if (inputt==5)
                     {
                         Connect c= new Connect();
                          c.EnterDataConnect();
                     }
                     else 
                         break;
                     
                 }
                 if(input==3)
                 {
                     Delete d=new Delete();
                     d.DeletePost(userid);
                 }
                 if(input==4)
                 {
                     Update u= new Update();
                     u.UpdatePost(userid);
                 }
            }

    }
    
}
