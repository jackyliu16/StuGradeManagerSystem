package databasesOperation;

import tool.LogLevel;
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

    public static void main(String[] args)  {
        log.setLogLevel(LogLevel.Debug);
        DataControlCenter dcc = new DataControlCenter();
        try {
            dcc.checkStudentPwd("20200740029", "123456");
        } catch (DBException e) {
            System.out.println(e.getErrorMsg());
            System.out.println(e.getErrorDetail());
            System.out.println(e.getMessage());
        }
        System.out.println("END");
    }
}
