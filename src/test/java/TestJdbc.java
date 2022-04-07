import Util.DBUtil;
import org.junit.Test;

import java.sql.*;

public class TestJdbc {
    @Test
    public void test1(){
         PreparedStatement preparedStatement =null;
        ResultSet res=null;
        Connection connection=DBUtil.getConnection();
        System.out.println(connection);
        DBUtil.close(res,preparedStatement,connection);
    }
    //增加记录
    @Test
    public void test2(){
        Connection connection=null;
        PreparedStatement preparedStatement =null;
        ResultSet res=null;
        String sql="insert into admin values(?,?,?)";

        try {
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,"3");
            preparedStatement.setString(2,"容");
            preparedStatement.setString(3,"0713");

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(res,preparedStatement,connection);
        }
    }
    //更改
    @Test
    public void test3(){
        Connection connection=null;
        PreparedStatement preparedStatement =null;
        ResultSet res=null;
        String sql="update admin set password=? where adminid=?";
        try {
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,"0712");
            preparedStatement.setString(2,"3");

            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(res,preparedStatement,connection);
        }
    }
    //查询
    @Test
    public void test(){
        Connection connection=null;
        PreparedStatement preparedStatement =null;
        ResultSet res=null;
        String sql="select *from admin";
        try {
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);

            res= preparedStatement.executeQuery(sql);
            while (res.next()){
                String id=res.getString(1);
                String name=res.getString(2);
                String password=res.getString(3);
                System.out.println(id+" "+name+" "+password);
            }


            //删除
            String sql1="delete from admin where adminid=?";
            preparedStatement=connection.prepareStatement(sql1);
            preparedStatement.setString(1,"3");
            preparedStatement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(res,preparedStatement,connection);
        }
    }
}

