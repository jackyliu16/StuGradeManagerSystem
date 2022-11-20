import Tool.ResultSetOperation;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;

public class TestConnection {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/CourseDB";
    static final String USER = "root";
    static final String PWD = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Successfully connected to dataBase");
            conn = DriverManager.getConnection(DB_URL, USER, PWD);
            stmt = conn.createStatement();
            System.out.println("Choosefrom:query,insert,delete");
            String op = sc.nextLine();
            switch (op) {
                case "query":// 查询操作
                    System.out.println("Enter your query here:");
                    String sqlQuery = sc.nextLine();
                    ResultSet rs = stmt.executeQuery(sqlQuery);
                    ResultSetOperation.printResultSet(rs); // debug用的
                    ArrayList<ArrayList<String>> res = ResultSetOperation.convertResultSetIntoArrayList(rs); // 你们指定的输出格式
                    System.out.println(res);
                    break;

                case "insert":// 插入操作
                    System.out.println("Enter your insert:");
                    String sqlInsert = sc.nextLine();
                    stmt.executeUpdate(sqlInsert);
                    System.out.println("Success");
                    break;

                case "delete":// 删除操作
                    System.out.println("Enter your delete:");
                    String sqlDelete = sc.nextLine();
                    stmt.executeUpdate(sqlDelete);
                    System.out.println("Success");
                    break;
                default:
                    System.out.println("Unknown command!");
            }
            // rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se) {
                System.out.println("Failed to connect to DB!");
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("END");
    }
}
