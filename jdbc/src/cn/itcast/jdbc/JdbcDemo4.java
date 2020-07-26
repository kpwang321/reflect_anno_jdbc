package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author kpwang
 * @create 2020-07-27 1:38
 */
public class JdbcDemo4 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.5.102:33306/db3?characterEncoding=utf8",
                    "root",
                    "root");
            String sql="delete from account where id=2";
            statement = conn.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
            if (row>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
