
/*
 * @File:   DataControlCenter.java
 * @Desc:
 * @Author: jacky
 * @Repo:   https://github.com/jackyliu16
 * @Date:   2022/11/18 下午11:07
 * @Version:0.0
 * @reference:
 *      basic mysql operation: https://blog.csdn.net/zollty/article/details/7291896#:~:text=%E4%B8%80%E8%88%AC%E7%94%A8%E6%B3%95%EF%BC%9AStatement%20stmt%20%3D%20conn.createStatement%20%28%29%3B,%E9%AB%98%E7%BA%A7%E7%94%A8%E6%B3%95%EF%BC%9AStatement%20stmt%20%3D%20conn.createStatement%20%28ResultSet.TYPE_SCROLL_SENSITIVE%2C%20ResultSet.CONCUR_READ_ONLY%29%3B
 *      doc :   https://blog.csdn.net/qq_60750453/article/details/121024414
 */

import Tool.LogLevel;
import Tool.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * a simple databases sql query provider for upper-level application
 * <p>
 * this implement will not provide any kinds of logic check of input, please make sure all input is legal.
 */
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

    /**
     * Gain all grade for all courses taken by the student
     *
     * @param student_id student ID
     * @return ArrayList<ArrayList < String>> for a table which show this
     */
    public ArrayList<ArrayList<String>> getStudentCourseGrade(String student_id) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format(
                    "SELECT Student.StuNo, Student.StuName, Learn.Grade " +
                            "FROM Student, ExClass, Learn " +
                            "WHERE Student.StuNo = Learn.StuNo AND Learn.ExClassNo = ExClass.ExClassNo AND Student.StuNo = '%s';",
                    student_id);
            log.info(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
            stmt.close();
            log.info("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     * Check if student In Course
     *
     * @param student_id Student ID
     * @param course_id  Course ID
     * @return ture => student in Course, false => student wasn't in the Course
     */
    public Boolean checkIfStudentInCourse(String student_id, String course_id) {
        boolean flag = false;
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format(
                    "SELECT * " +
                            "FROM Course, ExClass, Learn " +
                            "WHERE Course.CourseNo = ExClass.CourseNo AND ExClass.ExClassNo = Learn.ExClassNo " +
                            "AND Learn.StuNo = \"%s\" AND Course.CourseNo = \"%s\";", student_id, course_id);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
//            ResultSetOperation.printResultSet(rs);    // 不允许添加输出，这样会使迭代器运行到结尾
            if (rs.next()) {
                flag = true;
            }
            log.debug(String.format("flag is: %s", flag));
            rs.close();
            stmt.close();
            log.info("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    /**
     * check if student in the ExCourse
     *
     * @param student_id   student ID
     * @param ex_course_id The ExCourseNo
     * @return if student is in the ExClass(specific)
     */
    public Boolean checkIfStudentInExCourse(String student_id, String ex_course_id) {
        boolean flag = false;
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT * " +
                    "FROM Learn " +
                    "WHERE Learn.StuNo = '%s' AND Learn.ExClassNo = '%s';", student_id, ex_course_id);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
//            ResultSetOperation.printResultSet(rs);    // 不允许添加输出，这样会使迭代器运行到结尾
            if (rs.next()) {
                flag = true;
            }
            log.debug(String.format("flag is: %s", flag));
//            rs.close();
            stmt.close();
            log.info("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    /**
     * Adding a student into a ExCourse
     *
     * @param student_id  Student ID
     * @param ExCourse_id ExCourse ID that Student will be inserted into
     * @return success => true, failure => 0    # TODO if could convert it into a kind of exception?
     */
    public Boolean insertStudentIntoExCourse(String student_id, String ExCourse_id) {
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("insert into Learn values ('%s', '%s', null);", student_id, ExCourse_id);
            log.debug(String.format("sql: %s", sql));
            int rs = stmt.executeUpdate(sql);
            log.trace(String.format("rs: %s", rs));
            stmt.close();
            log.info("query success!");
            return rs == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * update a student grade in a ExCourse
     * anno: caller need to make sure the student is in the course before run this function
     *
     * @param student_id  studentNo
     * @param ExCourse_id The ExClassNo that student in
     * @param grade       double grade
     * @return true -> Succeed; false -> failure
     */
    public Boolean updateStudentExCourseGrade(String student_id, String ExCourse_id, double grade) {
        // if student is not in the class
        if (!checkIfStudentInExCourse(student_id, ExCourse_id)) {
            log.error(String.format("student %s not found in the course %s", student_id, ExCourse_id));
            return false;
        }
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "UPDATE Learn " +
                    "SET Grade='%s' WHERE StuNo='%s' AND ExClassNo = '%s';", grade, student_id, ExCourse_id);
            log.info(String.format("sql: %s", sql));
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                log.info("update query success!");
                return true;
            } else {
                log.error(String.format("update query failure: %s", sql));
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * a function just for test, it shouldn't been run directly or call by up-level application
     */
    public static void main(String[] args) {
        DataControlCenter dcc = new DataControlCenter();
//        System.out.println(dcc.checkIfStudentInCourse("20200740001", "00000001"));
        dcc.insertStudentIntoExCourse("20200740002", "00000004");
    }
}
