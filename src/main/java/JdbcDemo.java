import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo {
    static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/elm";
    static final String USER="root";
    static final String PASS="071399";
    public static void main(String []args) {

        Connection con=null;
        Statement sta=null;
        ResultSet res=null;

        List<Admin> list=new ArrayList<>();

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(DB_URL,USER,PASS);

            sta=con.createStatement();

            String sql="select *from admin";

            res=sta.executeQuery(sql);
            while (res.next()){
                String id= res.getString("adminId");
                String name= res.getNString("adminName");
                String passWord=res.getNString("passWord");

                Admin admin=new Admin();


                admin.setAdminId(id);
                admin.setAdminName(name);
                admin.setPassWord("passWord");

                list.add(admin);

            }

            for (Admin a:list) {
                System.out.println(a.getAdminId()+" "+a.getAdminName()+" "+a.getPassWord());
            }

            res.close();
            sta.close();
            con.close();

        }catch (SQLException sqlExceptione){
            sqlExceptione.printStackTrace();
        }catch (Exception exception ){
            exception.printStackTrace();
        }
        finally {
           try {
               if (sta!=null)
                   sta.close();
           }catch (SQLException se){
               se.printStackTrace();
           }
           try {
               if (con!=null)
                   con.close();
           }catch (SQLException se){
               se.printStackTrace();
           }
        }
    }
}
