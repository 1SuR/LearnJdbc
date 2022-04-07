import org.junit.Test;
import java.io.*;
import java.sql.*;
import java.util.*;
public class StreamTest {
    @Test
    public void test(){
        try {
            Properties properties=new Properties();
            InputStream inputStream=StreamTest.class.getResourceAsStream("jdbc.properties");
            properties.load(inputStream);

            Class.forName(properties.getProperty("driver"));
            Connection con=DriverManager.getConnection
                    (properties.getProperty("url"),properties.getProperty
                            ("user"),properties.getProperty("password"));

            //Create a Statement object and build table
            Statement sta=con.createStatement();


            File f=new File("XML_Data.xml");
            long file_length=f.length();
            FileInputStream fileInputStream=new FileInputStream(f);

            String sql="insert into admin values(?,?)";
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setInt(1,100);
            pst.setAsciiStream(2,fileInputStream,(int)file_length);
            pst.execute();
            fileInputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
