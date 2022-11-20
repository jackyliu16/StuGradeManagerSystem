
/*
 * @File:   DataControlCenter.java
 * @Desc:
 * @Author: jacky
 * @Repo:   https://github.com/jackyliu16
 * @Date:   2022/11/18 下午11:07
 * @Version:0.0
 * @reference:
 *      basic mysql operation: https://blog.csdn.net/zollty/article/details/7291896#:~:text=%E4%B8%80%E8%88%AC%E7%94%A8%E6%B3%95%EF%BC%9AStatement%20stmt%20%3D%20conn.createStatement%20%28%29%3B,%E9%AB%98%E7%BA%A7%E7%94%A8%E6%B3%95%EF%BC%9AStatement%20stmt%20%3D%20conn.createStatement%20%28ResultSet.TYPE_SCROLL_SENSITIVE%2C%20ResultSet.CONCUR_READ_ONLY%29%3B
 *
 */

import Tool.LogLevel;
import Tool.Logger;

import java.sql.*;
import java.util.ArrayList;

public class DataControlCenter {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/CourseDB";
    static final String USER = "root";
    static final String PWD = "123456";
    static final Logger log = new Logger(LogLevel.Debug);
    static Connection conn = null;

    DataControlCenter() {
        try {
            Class.forName(JDBC_DRIVER);
            // Driver Class Create Connect Object
            conn = DriverManager.getConnection(DB_URL, USER, PWD);
            // Create an implementation method object should include in each Query
            log.info("Connection Success");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<String>> getStudentCourseGrade(String student_id) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format(
                    "SELECT Student.StuNo, Student.StuName, Learn.Grade " +
                            "FROM Student, ExClass, Learn " +
                            "WHERE Student.StuNo = Learn.StuNo AND Learn.ExClassNo = ExClass.ExClassNo AND Student.StuNo = '%s';", student_id);
            log.info(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
//            ResultSetOperation.printResultSet(rs);
            rs.close();
            stmt.close();
            log.info("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // do nothing
        return res;
    }

    public static void main(String[] args) {
        DataControlCenter dcc  = new DataControlCenter();
        dcc.getStudentCourseGrade("20200740001");
    }
}
