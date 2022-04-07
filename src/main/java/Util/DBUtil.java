package Util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    public static Connection getConnection(){
        Connection con=null;
        Properties properties=new Properties();
        try{
        InputStream inputStream=DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(inputStream);

        Class.forName(properties.getProperty("driver"));
            con=DriverManager.getConnection
                    (properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    //关闭资源
    public static void close(ResultSet rs, PreparedStatement pst, Connection con) {
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(pst!=null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pst = null;
        }
        if(con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con = null;
        }
    }
}
