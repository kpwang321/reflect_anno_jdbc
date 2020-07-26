package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author kpwang
 * @create 2020-07-27 1:22
 */
public class JdbcDemo2 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.5.102:33306/db3?characterEncoding=utf8",
                    "root",
                    "root");
            //定义sql
            String sql="insert into account values(null,'linzhiling',1500)";
            statement = conn.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
            if (row>0){
                System.out.println("添加成功！");
            }else {
                System.out.println("添加失败！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (statement!=null){
                    statement.close();
                }
                if (conn!=null){
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
