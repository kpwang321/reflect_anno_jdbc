package cn.itcast.jdbcTemplate;

import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author kpwang
 * @create 2020-07-27 18:33
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //创建JDBCTemplate对象
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql="update account set balance=5000 where id=?";
        int row = template.update(sql, 3);
        System.out.println(row);
    }
}
