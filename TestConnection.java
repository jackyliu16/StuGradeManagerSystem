/*
 * @File:   TestConnection.java
 * @Desc:
 * @Author: jacky
 * @Date:   2022/11/18 上午10:53
 * @Version:0.0
 */

import Tool.ResultSetOperation;

import java.sql.*;
import java.util.ArrayList;

public class TestConnection {

//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL      = "jdbc:mysql://localhost:3306/CourseDB";
    static final String USER        = "root";
    static final String PWD         = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt  = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connect to DataBases");
            conn = DriverManager.getConnection(DB_URL, USER, PWD);
            stmt = conn.createStatement();//statement是sql语句？connnet创建的

            String sql = "select * from Course";//瞎玩的
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetOperation.printResultSet(rs);      // using for debug
            ArrayList<ArrayList<String>> res = ResultSetOperation.convertResultSetIntoArrayList(rs); // using for output
            System.out.println(res);//怎么样把多个查询的结果输出？
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (stmt != null)
                    stmt.close();
            }
            catch (SQLException se)
            {
                // do nothing
            }
            try
            {
                if (conn != null)
                    conn.close();
            }
            catch (SQLException se)
            {
                se.printStackTrace();
            }
        }
        System.out.println("END");
    }
}
