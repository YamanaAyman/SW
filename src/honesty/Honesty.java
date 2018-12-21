
package honesty;
import java.util.Scanner;
import honesty.DBConnection;
public class Honesty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         DBConnection conn = new DBConnection();
            conn.Connectiontomysql();
//            SignUp s= new SignUp();
//            s.signup();
//            s.save_info();
            LogIn in=new LogIn();
            in.log_in();
            //in.search("hh", "12");
    }
    
}
