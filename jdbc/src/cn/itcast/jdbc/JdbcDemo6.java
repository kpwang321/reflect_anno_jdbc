package cn.itcast.jdbc;

import cn.itcast.domain.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-27 1:39
 * 执行DDL语句
 */
public class JdbcDemo6 {

    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.5.102:33306/db3?characterEncoding=utf8",
                    "root",
                    "root");
            String sql="SELECT * FROM account ";
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            List<Account> list=new ArrayList<>();
            while (resultSet.next()){
                Account account=new Account();
                account.setId(resultSet.getInt(1));
                account.setName(resultSet.getString(2));
                account.setBalance(resultSet.getDouble(3));
                list.add(account);
            }
            System.out.println(list);



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
