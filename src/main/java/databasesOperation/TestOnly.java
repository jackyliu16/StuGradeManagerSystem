package databasesOperation;

import tool.Logger;

public class TestOnly {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/CourseDB";
    static final String USER = "root";
    static final String PWD = "123456";
    static Logger log = Logger.INSTANCE;

    private static void log_test() {
        System.out.println("normal output");
        log.error("error message");
        log.warn("warning message");
        log.info("info message");
        log.debug("debug message");
        log.trace("trace message");
    }

    public static void main(String[] args) {
        DataControlCenter dcc = new DataControlCenter();
        dcc.insertStudentIntoExCourse("20200740029", "00000001");
    }
}
