package cn.itcast.datasource.druid;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author kpwang
 * @create 2020-07-27 18:22
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pst=null;
        try {
            conn = JDBCUtils.getConnection();
            String sql="insert into account values(null,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,"kpwang");
            pst.setDouble(2,2000);
            int row = pst.executeUpdate();
            if (row>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pst,conn);
        }
    }
}
