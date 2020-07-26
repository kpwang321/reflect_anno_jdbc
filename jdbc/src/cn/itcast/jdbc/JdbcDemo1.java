package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author kpwang
 * @create 2020-07-26 20:10
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1导入驱动jar包  mysql-connector-java-5.1.37-bin.jar
        //2注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3获取连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.5.102:33306/db3?characterEncoding=utf8",
                "root",
                "root");
        //4定义sql
        //String sql="update account set balance=1500 where id=1";
        String sql="update account set balance=1500 ";
        //5获取执行sql的对象Statement
        Statement stmt = conn.createStatement();
        //6执行sql
        int count = stmt.executeUpdate(sql);
        //7处理结果
        System.out.println(count);
        //8释放资源
        stmt.close();
        conn.close();

    }
}
