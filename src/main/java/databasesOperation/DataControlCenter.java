package databasesOperation;
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

import tool.LogLevel;
import tool.Logger;

import java.sql.*;
import java.util.ArrayList;

//我们不负责权限管理，确保所有的输入都是合法的（默认用户会sql）

public class DataControlCenter {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/CourseDB";
    static final String USER = "root";
    static final String PWD = "root";
    static final Logger log = Logger.INSTANCE;
    static Connection conn = null;

    public DataControlCenter() {
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

// Check Function

    /**
     * Check If Student Pwd is Correct
     *
     * @param Student_id An input id which indicate as a student
     * @param password   the input password of student
     * @return Whether the authentication was successful
     */
    public Boolean checkStudentPwd(String Student_id, String password) {
        boolean flag = false;
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT * " +
                    "FROM Student " +
                    "WHERE StuNo=\"%s\" AND Pwd=\"%s\" ", Student_id, password);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            // ResultSetOperation.printResultSet(rs); // 不允许添加输出，这样会使迭代器运行到结尾
            if (rs.next()) {
                flag = true;
            }
            log.debug(String.format("flag is: %s", flag));
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    /**
     * Check If Teacher Pwd is Correct
     *
     * @param Tech_id  AN input id which indicate as a teacher
     * @param password the input password of teacher
     * @return Whether the authentication was successful
     */
    public Boolean checkTeacherPwd(String Tech_id, String password) {
        boolean flag = false;
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT * " +
                    "FROM Teacher " +
                    "WHERE TechNo=\"%s\" AND Pwd=\"%s\" ", Tech_id, password);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            // ResultSetOperation.printResultSet(rs); // 不允许添加输出，这样会使迭代器运行到结尾
            if (rs.next()) {
                flag = true;
            }
            log.debug(String.format("flag is: %s", flag));
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    /**
     * Check If Admin Pwd is Correct
     *
     * @param Admin_id AN input id which indicate as a admin
     * @param password the input password of teacher
     * @return Whether the authentication was successful
     */
    public Boolean checkAdminPwd(String Admin_id, String password) {
        boolean flag = false;
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT * " +
                    "FROM Admin " +
                    "WHERE ID=\"%s\" AND Password=\"%s\" ", Admin_id, password);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            // ResultSetOperation.printResultSet(rs); // 不允许添加输出，这样会使迭代器运行到结尾
            if (rs.next()) {
                flag = true;
            }
            log.debug(String.format("flag is: %s", flag));
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    /**
     * Check if student In Course
     *
     * @param student_id Student ID
     * @param course_id  Course ID
     * @return ture is student in Course, false is student wasn't in the Course
     */
    public Boolean checkIfStudentInCourse(String student_id, String course_id) {
        boolean flag = false;
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format(
                    "SELECT * " +
                            "FROM Course, ExClass, Learn " +
                            "WHERE Course.CourseNo = ExClass.CourseNo AND ExClass.ExClassNo = Learn.ExClassNo " +
                            "AND Learn.StuNo = \"%s\" AND Course.CourseNo = \"%s\";",
                    student_id, course_id);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            // ResultSetOperation.printResultSet(rs); // 不允许添加输出，这样会使迭代器运行到结尾
            if (rs.next()) {
                flag = true;
            }
            log.debug(String.format("flag is: %s", flag));
            rs.close();
            stmt.close();
            log.debug("query success!");
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
            // ResultSetOperation.printResultSet(rs); // 不允许添加输出，这样会使迭代器运行到结尾
            if (rs.next()) {
                flag = true;
            }
            log.info(String.format("flag is: %s", flag));
            // rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

// Get Function

    public String getStudentName(String student_id) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT Student.StuName " +
                    "FROM Student " +
                    "WHERE Student.StuNo = '%s' ", student_id);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayList(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res.isEmpty() ? "" : res.get(0).get(0);
    }

    public ArrayList<ArrayList<String>> getExClassGradeForStudent(String student_id, String ex_class_no) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT Student.StuNo, Student.StuName, Course.CourseName, Learn.Grade, ExClass.Year, ExClass.semester " +
                    "FROM Student, Learn, ExClass, Course " +
                    "WHERE Student.StuNo = Learn.StuNo AND Learn.ExClassNo = ExClass.ExClassNo AND ExClass.CourseNo = Course.CourseNo " +
                    "AND ExClass.ExClassNo = \"%s\" AND Student.StuNo = \"%s\" ;", ex_class_no, student_id);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayListWithColumnName(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     * Gain all grade for all courses taken by the student
     * <p>
     * caller need to make sure student ID is legal
     * </p>
     *
     * @param student_id student ID
     * @return a table which raw is each student and col is ExClassNo, CourseName, Grade, Year, Semester in
     * a Course;
     * if return empty means that there is something error in this function
     */
    public ArrayList<ArrayList<String>> getStudentCourseGrade(String student_id) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
//            String sql = String.format("" +
//                    "WITH b AS ( " +
//                    "   select ExClassNo, TechName from ( " +
//                    "       select ExClass.ExClassNo, Teaching.TechNo " +
//                    "       from ExClass LEFT JOIN Teaching ON Teaching.ExClassNo = ExClass.ExClassNo " +
//                    "   ) as a " +
//                    "   LEFT JOIN Teacher ON Teacher.TechNo = a.TechNo ORDER BY ExClassNo " +
//                    ") " +
//                    "SELECT ExClass.ExClassNo, Course.CourseName, Learn.Grade, ExClass.Year, ExClass.semester, b.TechName " +
//                    "FROM Student, Learn, ExClass, b, Course\n" +
//                    "WHERE Student.StuNo = Learn.StuNo AND ExClass.ExClassNo = Learn.ExClassNo AND ExClass.ExClassNo = b.ExClassNo AND ExClass.CourseNo = Course.CourseNo " +
//                    "AND Student.StuNo = \"%s\" ;", student_id);
            String sql = String.format("" +
                    "SELECT ExClass.ExClassNo, Course.CourseName, Learn.Grade, ExClass.Year, ExClass.semester, Teacher.TechName " +
                    "FROM ExClass, Course, Learn, Teacher, Teaching, Student " +
                    "WHERE Student.StuNo = Learn.StuNo AND Learn.ExClassNo = ExClass.ExClassNo " +
                    "AND ExClass.CourseNo = Course.CourseNo AND ExClass.ExClassNo = Teaching.ExClassNo " +
                    "AND Teaching.TechNo = Teacher.TechNo " +
                    "AND Student.StuNo = '%s' ", student_id);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayListWithColumnName(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     * get student course information by student id (without grade output)
     *
     * @param student_id
     * @return
     */
    public ArrayList<ArrayList<String>> getStudentExClassHistory(String student_id) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
//            String sql = String.format("" +
//                    "WITH b as ( " +
//                    "   WITH a AS (" +
//                    "SELECT Course.CourseName, Student.StuNo, Student.StuName, ExClass.ExClassNo " +
//                    "FROM Course, ExClass, Learn, Student " +
//                    "WHERE Course.CourseNo = ExClass.CourseNo AND ExClass.ExClassNo = Learn.ExClassNo AND Learn.StuNo = Student.StuNo " +
//                    "AND Student.StuNo = \"%s\" " +
//                    ")" +
//                    "SELECT a.CourseName, a.StuName, Teaching.TechNo " +
//                    "FROM a LEFT JOIN Teaching on a.ExClassNo = Teaching.ExClassNo " +
//                    ") " +
//                    "SELECT b.CourseName, b.StuName, Teacher.TechName " +
//                    "FROM Teacher LEFT JOIN b on Teacher.TechNo = b.TechNo ;" +
//                    "", student_id);
            String sql = String.format("" +
                    "SELECT ExClass.ExClassNo, Course.CourseName, ExClass.Year, ExClass.semester, Teacher.TechName " +
                    "FROM ExClass, Course, Learn, Teacher, Teaching, Student " +
                    "WHERE Student.StuNo = Learn.StuNo AND Learn.ExClassNo = ExClass.ExClassNo " +
                    "AND ExClass.CourseNo = Course.CourseNo AND ExClass.ExClassNo = Teaching.ExClassNo " +
                    "AND Teaching.TechNo = Teacher.TechNo " +
                    "AND Student.StuNo = '%s' ", student_id);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayListWithColumnName(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public ArrayList<ArrayList<String>> getStudentInfoBelongExCourse(String ex_course_id) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT Student.StuNo, Student.StuName, Student.MajorNo, Learn.ExClassNo, Learn.Grade " +
                    "FROM Student, Learn " +
                    "WHERE Student.StuNo=Learn.StuNo " +
                    "AND Learn.ExClassNo=\"%s\" ", ex_course_id);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayListWithColumnName(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public ArrayList<ArrayList<String>> getStudentInfo(String student_id) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT * " +
                    "FROM Student " +
                    "WHERE Student.StuNo=\"%s\" ", student_id);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayListWithColumnName(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public ArrayList<ArrayList<String>> getTeacherteachList(String teacher_id) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT Course.CourseName, ExClass.year, ExClass.Semester , ExClass.ExClassNo " +
                    "FROM Teacher,Teaching ,Course ,ExClass " +
                    " WHERE Teacher.TechNo=\"%s\" and Teacher.TechNo=Teaching.TechNo and " +
                    "Teaching.ExClassNo=ExClass.ExClassNo and ExClass.CourseNo=Course.CourseNo", teacher_id);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayListWithColumnName(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    public String getTeacherName(String teacher_id) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT techname " +
                    "FROM Teacher" +
                    " WHERE Teacher.TechNo=\"%s\" ", teacher_id);
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayList(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res.isEmpty() ?"" :res.get(0).get(0);
    }
    public ArrayList<ArrayList<String>> getStudentList() {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT student.StuNo , student.StuName , major.MajorName , department.DeptName " +
                    "FROM student , major , department " +
                    " WHERE student.majorNo=Major.MajorNo and major.DeptNo=department.DeptNo " +
                    "group by student.stuNo");
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayListWithColumnName(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public ArrayList<ArrayList<String>> getGradeList() {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT Learn.StuNo , Course.CourseName , ExClass.year , ExClass.semester ,  Learn.Grade " +
                    "FROM learn , ExClass , course " +
                    " WHERE learn.ExClassNo=ExClass.ExClassNo and ExClass.courseNo=course.courseNo " +
                    "order by Learn.ExClassNo");
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayListWithColumnName(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public ArrayList<ArrayList<String>> getTeacherList() {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT Teacher.TechNo , Teacher.TechName , Department.DeptName " +
                    "FROM Teacher , Department " +
                    " WHERE Teacher.DeptNo=Department.DeptNo ");
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayListWithColumnName(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public ArrayList<ArrayList<String>> getClassList() {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "SELECT Course.courseName , ExClass.year , ExClass.semester , teacher.TechName " +
                    "FROM Teacher , ExClass , course , teaching " +
                    " WHERE Teacher.TechNo=teaching.TechNo and teaching.ExClassNo=ExClass.ExClassNo and" +
                    " ExClass.courseNo=course.courseNo");
            log.debug(String.format("sql: %s", sql));
            ResultSet rs = stmt.executeQuery(sql);
            res = ResultSetOperation.convertResultSetIntoArrayListWithColumnName(rs);
            rs.close();
            stmt.close();
            log.debug("query success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    // Insert Function

    /**
     * Add a student into a ExCourse</br>
     *
     * will insert a empty relationship into database, which means that grade will
     * be 0
     *
     * @param student_id  Student ID
     * @param ExCourse_id ExCourse ID that Student will be inserted into
     * @return success => true, failure => 0
     *         TODO if could convert it into a kind
     *         of exception?
     */
    public Boolean insertStudentIntoExCourse(String student_id, String ExCourse_id) {
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("insert into Learn values ('%s', '%s', null);", student_id, ExCourse_id);
            log.debug(String.format("sql: %s", sql));
            int rs = stmt.executeUpdate(sql);
            log.trace(String.format("rs: %s", rs));
            stmt.close();
            log.debug("query success!");
            return rs == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean insertNewStudentUser(String StuNo, String StuName, String MajorNo, String Pwd) {
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("insert into Student values ('%s', '%s', '%s','%s');", StuNo, StuName, MajorNo, Pwd);
            log.debug(String.format("sql: %s", sql));
            int rs = stmt.executeUpdate(sql);
            log.trace(String.format("rs: %s", rs));
            stmt.close();
            log.debug("query success!");
            return rs == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public Boolean insertNewTeacherUser(String TechNo, String TechName, String DeptNo, String Pwd) {
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("insert into Student values ('%s', '%s', '%s','%s');", TechNo, TechName, DeptNo, Pwd);
            log.debug(String.format("sql: %s", sql));
            int rs = stmt.executeUpdate(sql);
            log.trace(String.format("rs: %s", rs));
            stmt.close();
            log.debug("query success!");
            return rs == 1;
        } catch (SQLException e) {
            return false;
        }
    }

// Update Function

    /**
     * update a student grade in a ExCourse</br>
     * <p>
     * anno: caller need to make sure the student is in the course before run this
     * function
     *
     * @param student_id  studentNo
     * @param ExCourse_id The ExClassNo that student in
     * @param grade       double grade
     * @return true then Succeed; false then failure
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
            log.debug(String.format("sql: %s", sql));
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                log.debug("update query success!");
                return true;
            } else {
                log.error(String.format("update query failure: %s", sql));
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean updateStudentPwd(String student_id, String old_password, String new_password) {
        // first check if student old password correct
        if (!checkStudentPwd(student_id, old_password)) {
            return false;
        }
        log.debug("student password check correct");
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "UPDATE Student " +
                    "SET Pwd=\"%s\" " +
                    "WHERE Student.StuNo=\"%s\" ", new_password, student_id);
            log.debug(String.format("sql: %s", sql));
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                log.debug("update query success!");
                return true;
            } else {
                log.error(String.format("update query failure: %s", sql));
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean updateTeacherPwd(String teacher_id, String old_password, String new_password) {
        // first check if student old password correct
        if (!checkTeacherPwd(teacher_id, old_password)) {
            return false;
        }
        log.debug("student password check correct");
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "UPDATE teacher " +
                    "SET Pwd=\"%s\" " +
                    "WHERE teacher.TechNo=\"%s\" ", new_password, teacher_id);
            log.debug(String.format("sql: %s", sql));
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                log.debug("update query success!");
                return true;
            } else {
                log.error(String.format("update query failure: %s", sql));
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean updateStudentMajor(String student_id, String major_id) {
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "UPDATE Student " +
                    "SET MajorNo='%s' " +
                    "WHERE Student.StuNo= '%s' ;", major_id, student_id);
            log.debug(String.format("sql: %s", sql));
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                log.debug("update query success!");
                return true;
            } else {
                log.error(String.format("update query failure: %s", sql));
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
// Delete Function

    public Boolean deleteStudentFromExCourse(String student_id, String ex_course_id) {
        // first check if student in Excourse
        if (!checkIfStudentInExCourse(student_id, ex_course_id)) {
            return false;
        }
        log.debug("student password check correct");
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "DELETE " +
                    "FROM Learn " +
                    "WHERE Learn.StuNo=\"%s\" AND Learn.ExClassNo=\"%s\" ", student_id, ex_course_id);
            log.debug(String.format("sql: %s", sql));
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                log.debug("update query success!");
                return true;
            } else {
                log.error(String.format("update query failure: %s", sql));
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Boolean deleteTeachingRelationship(String tech_no, String ex_class_no) {
        try (Statement stmt = conn.createStatement()) {
            String sql = String.format("" +
                    "DELETE " +
                    "FROM Teaching " +
                    "WHERE Teaching.TechNo = '%s' AND Teaching.ExClassNo = '%s' ", tech_no, ex_class_no);
            log.debug(String.format("sql: %s", sql));
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                log.debug("update query success!");
                return true;
            } else {
                log.error(String.format("update query failure: %s", sql));
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

class Test {
    static final Logger log = Logger.INSTANCE;

    private static void test_for_update_major() {
        DataControlCenter dcc = new DataControlCenter();
        dcc.updateStudentMajor("20200740012", "0002");
    }

    private static void test_for_delete_teaching() {
        DataControlCenter dcc = new DataControlCenter();
        dcc.deleteTeachingRelationship("20200010004", "00000004");
    }

    private static void test_for_password_update() {
        DataControlCenter dcc = new DataControlCenter();
        dcc.checkStudentPwd("20200740004", "123459");
        System.out.println(dcc.updateStudentPwd("20200740004", "123446", "123123"));
        dcc.checkStudentPwd("20200740004", "123123");
        System.out.println(dcc.updateStudentPwd("20200740004", "123459", "123123"));
        dcc.checkStudentPwd("20200740004", "123123");
        System.out.println(dcc.getTeacherteachList("20200010002"));
        System.out.println(dcc.getStudentList());
        System.out.println(dcc.getGradeList());
        System.out.println(dcc.getTeacherList());
        System.out.println(dcc.getClassList());
        System.out.println(dcc.getStudentExClassHistory("20200740002"));

        log.info("test password update complete! ");
        System.out.println(dcc.getTeacherName("20200010002"));
    }

    private static void test_for_ex_class_insert_delete() {
        log.setLogLevel(LogLevel.Info);
        //hello
        DataControlCenter dcc = new DataControlCenter();
        dcc.checkIfStudentInExCourse("20200740013", "00000001");
        dcc.deleteStudentFromExCourse("20200740013", "00000001");
        dcc.checkIfStudentInExCourse("20200740013", "00000001");
        dcc.insertStudentIntoExCourse("20200740013", "00000001");
        dcc.checkIfStudentInExCourse("20200740013", "00000001");
        log.info("test_for_ex_class_insert_delete complete!");
    }

    private static void test_for_get_information() {
        DataControlCenter dcc = new DataControlCenter();
        dcc.getStudentInfoBelongExCourse("00000001");
        System.out.println(dcc.getStudentInfo("20200740001"));
        log.info("finish");
    }

    private static void check_for_student_history() {
        DataControlCenter dcc = new DataControlCenter();
        System.out.println(dcc.getStudentExClassHistory("20200740001"));
    }

    private static void check_for_get_student_grade() {
        DataControlCenter dcc = new DataControlCenter();
        System.out.println(dcc.getStudentCourseGrade("20200740001"));
        System.out.println(dcc.getStudentCourseGrade("20200740029"));

    }

    private static void check_get_student_name_by_student_id() {
        DataControlCenter dcc = new DataControlCenter();
        System.out.println(dcc.getStudentName("20200740001"));
        System.out.println(dcc.getStudentName("20200740031"));
    }

    private static void check_get_student_exclass_grade() {
        DataControlCenter dcc = new DataControlCenter();
        System.out.println(dcc.getExClassGradeForStudent("20200740001", "00001015"));
        System.out.println(dcc.getExClassGradeForStudent("20200740001", "00000015"));
    }

    public static void main(String[] args) {
        log.setLogLevel(LogLevel.Debug);
        check_get_student_exclass_grade();
    }
}
