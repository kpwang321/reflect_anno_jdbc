package cn.itcast.jdbc;

import cn.itcast.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author kpwang
 * @create 2020-07-27 3:15
 * 事务操作
 *
 */
public class JdbcDemo9 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps1=null;
        PreparedStatement ps2=null;
        try {
            conn = JdbcUtils.getConnection();
            String sql1="update account set balance=balance-? where id=?";
            String sql2="update account set balance=balance+? where id=?";
            conn.setAutoCommit(false);
            ps1 = conn.prepareStatement(sql1);
            ps2 = conn.prepareStatement(sql2);
            ps1.setDouble(1,500);
            ps1.setInt(2,1);
            ps2.setDouble(1,500);
            ps2.setInt(2,3);
            ps1.executeUpdate();
            int i=1/0;
            ps2.executeUpdate();
            conn.commit();//提交事务
        }  catch (Exception e){
            e.printStackTrace();
            try {
                if (conn!=null){
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally {
            JdbcUtils.closeConnection(ps1,conn);
            JdbcUtils.closeConnection(ps1,null);

        }

    }
}
