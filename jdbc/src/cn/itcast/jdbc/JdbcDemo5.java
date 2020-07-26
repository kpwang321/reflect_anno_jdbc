package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author kpwang
 * @create 2020-07-27 1:39
 * 执行DDL语句
 */
public class JdbcDemo5 {

    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.5.102:33306/db3?characterEncoding=utf8",
                    "root",
                    "root");
            String sql="CREATE TABLE sutdent (id int,name VARCHAR (20))";
            statement = conn.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);


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
