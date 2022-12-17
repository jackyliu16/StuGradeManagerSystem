package databasesOperation;
/*
 * @File:   DBException.java
 * @Desc:
 * @Author: jacky
 * @Repo:   https://github.com/jackyliu16
 * @Date:   2022/12/16 下午5:00
 * @Version:0.0
 * @Reference:
 *      1. https://www.cnblogs.com/xinzhisoft/p/10108211.html
 */

public class DBException extends Exception implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private DBExceptionEnums exceptionEnums;
    private String errorDetail;

    public DBException(DBExceptionEnums exceptionEnums, String errorDetail) {
        this.exceptionEnums = exceptionEnums;
        this.errorDetail = errorDetail;
    }

    public DBException(DBExceptionEnums exceptionEnums) {
        this.exceptionEnums = exceptionEnums;
    }

    public DBExceptionEnums getExceptionEnums() {
        return exceptionEnums;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public static boolean checkIfExceptionInCollections(DBException exception, DBExceptionEnums... enums) {
        for (DBExceptionEnums aException : enums) {
            if (exception.exceptionEnums == aException) {
                return true;
            }
        }
        return false;
    }
}

class Test1 {
    public static void main(String[] args) {
        DataControlCenter dcc = new DataControlCenter();
        try {
            dcc.checkIfStudentInExCourse("20200740001", "00000001");
        } catch (DBException e) {
            if (e.getExceptionEnums() == DBExceptionEnums.SQL_EXCEPTION) {
                System.out.println("something happen");
            } else {
                System.out.println(e.getErrorDetail());
            }
        }

    }
}