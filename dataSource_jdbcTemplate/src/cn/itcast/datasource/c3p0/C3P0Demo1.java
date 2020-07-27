package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kpwang
 * @create 2020-07-27 17:46
 * c3p0的演示
 */
public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        //1创建数据库连接池对象
        DataSource ds=new ComboPooledDataSource();
        //2获取连接对象
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
