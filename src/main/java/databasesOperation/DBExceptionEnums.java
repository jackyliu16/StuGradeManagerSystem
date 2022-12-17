package databasesOperation;
/*
 * @File:   DatabaseExceptionEnums.java
 * @Desc:
 * @Author: jacky
 * @Repo:   https://github.com/jackyliu16
 * @Date:   2022/12/16 下午4:48
 * @Version:0.0
 * @Reference:
 *      1. https://www.cnblogs.com/xinzhisoft/p/10108211.html
 */

public enum DatabaseExceptionEnums {
//    PARAMETER_ABNORMALITY("0000", "Parameter is not legal"),
    PARAMETER_LENGTH_INCORRECT("0001", "Parameter length incorrect"),
    PARAMETER_TYPE_INCORRECT("0002", "Parameter type incorrect");

    private final String ecode;
    private final String emsg;
    DatabaseExceptionEnums(String ecode, String emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public String getEcode() {
        return ecode;
    }

    public String getEmsg() {
        return emsg;
    }

    public static DatabaseExceptionEnums statOf(String ecode) {
        for (DatabaseExceptionEnums state: values()) {
            return state;
        }
        return null;
    }
}
