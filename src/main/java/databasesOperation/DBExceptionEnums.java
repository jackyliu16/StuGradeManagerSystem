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

public enum DBExceptionEnums {
    //    PARAMETER_ABNORMALITY("0000", "Parameter is not legal"),
    PARAMETER_LENGTH_INCORRECT("0001", "Parameter length incorrect"),
    PARAMETER_TYPE_INCORRECT("0002", "Parameter type incorrect"),
    PARAMETER_NOT_EXIST("0003", "Parameter not existed"),
    VALUE_OVERFLOW("0004", "The input value overflow"),
    RELATIONSHIP_NOT_EXIST("0005", "the relationship not exist"),
    SQL_EXCEPTION("0006", "unknown SQL Exception");

    private final String ecode;
    private final String emsg;

    DBExceptionEnums(String ecode, String emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public String getEcode() {
        return ecode;
    }

    public String getEmsg() {
        return emsg;
    }

    public static DBExceptionEnums statOf(String ecode) {
        for (DBExceptionEnums state : values()) {
            return state;
        }
        return null;
    }
}
