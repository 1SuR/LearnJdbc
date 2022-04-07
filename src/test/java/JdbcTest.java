import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcTest {
    @Test
    public void TestJdbc1(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/elm","root","071399");
            System.out.println(con);
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void TestJdbc2(){
        try{
            Driver driver=new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Properties properties=new Properties();
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/elm","root","071399");
            System.out.println(connection);
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Test
    public void test3(){
         try{
             Properties properties=new Properties();
             InputStream inputStream=JdbcTest.class.getResourceAsStream("jdbc.properties");
             properties.load(inputStream);

             Class.forName(properties.getProperty("driver"));
             Connection con=
             DriverManager.getConnection
                     (properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));

             System.out.println(con);
             con.close();
         }
         catch (Exception e){
             e.printStackTrace();
         }
    }
}
