package cn.itcast.jdbc;

import cn.itcast.domain.Account;
import cn.itcast.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-27 1:39
 * 执行DDL语句
 */
public class JdbcDemo7 {

    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            conn = JdbcUtils.getConnection();
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



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(resultSet,statement,conn);
        }
    }
}
