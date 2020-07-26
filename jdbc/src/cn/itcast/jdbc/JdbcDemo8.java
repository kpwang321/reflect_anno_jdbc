package cn.itcast.jdbc;

import cn.itcast.domain.Account;
import cn.itcast.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author kpwang
 * @create 2020-07-27 1:39
 * 执行DDL语句
 */
public class JdbcDemo8 {

    public  boolean login(String username,String password) {
        Connection conn=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            conn = JdbcUtils.getConnection();
            String sql="SELECT * FROM T_USER where username= '"+username+"' and password='"+password+"' ";
            System.out.println(sql);
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            JdbcUtils.closeConnection(resultSet,statement,conn);
        }
    }
    public  boolean login2(String username,String password) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn = JdbcUtils.getConnection();
            String sql="SELECT * FROM T_USER where username= ? and password=?";
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            JdbcUtils.closeConnection(rs,ps,conn);
        }
    }

    public static void main(String[] args) {
        JdbcDemo8 j=new JdbcDemo8();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        if(j.login2(username,password)){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
}
