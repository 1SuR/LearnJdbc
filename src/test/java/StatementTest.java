import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class StatementTest {
    @Test
    public void test_Statement(){

        try {
            Properties properties=new Properties();
            InputStream inputStream= StatementTest.class.getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            Class.forName(properties.getProperty("driver"));

            Connection connection= DriverManager.getConnection
                    (properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));

            Statement sta=connection.createStatement();

            String sql="select *from admin";
            ResultSet res;
            res=sta.executeQuery(sql);
            while (res.next()){
                String id=res.getString("adminId");
                String name= res.getString("adminName");
                String pass=res.getString("passWord");

                System.out.println(id+" "+name+" "+pass);

            }

            res.close();
            sta.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    @Test
    public void test_PrepareStatement(){
        String adminName="苏";
        String password="0713";
        try {
            Properties properties=new Properties();
            InputStream inputStream= StatementTest.class.getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            Class.forName(properties.getProperty("driver"));

            Connection connection= DriverManager.getConnection
                    (properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));

            String sql="select * from admin where adminName=? and password=?";
            PreparedStatement pst=connection.prepareStatement(sql);

            pst.setString(1,adminName);
            pst.setString(2,password);

            ResultSet res;

            res=pst.executeQuery();

            while (res.next()){

                String id=res.getString("adminId");
                String name= res.getString("adminName");
                String pass=res.getString("passWord");

                System.out.println(id+" "+name+" "+pass);

            }

            res.close();
            pst.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
