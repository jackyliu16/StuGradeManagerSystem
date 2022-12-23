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
    // TODO Error type are not necessarily classified correctly.
    PARAMETER_LENGTH_INCORRECT("0001", "Parameter length incorrect"), //　参数长度不正确
    PARAMETER_TYPE_INCORRECT("0002", "Parameter type incorrect"),   //　参数中有不合法内容
    PARAMETER_NOT_EXIST("0003", "Parameter not existed"),      //　参数不存在
    VALUE_OVERFLOW("0004", "The input value overflow"),   //　数值范围溢出
    RELATIONSHIP_NOT_EXIST("0005", "the relationship not exist"), //  关系不存在
    // 出现参数完整性冲突问题
    INTEGRITY_VIOLATION("0006", "a kind of integrity violation like when insert a exist primary key"),
    SQL_EXCEPTION("0007", "unknown SQL Exception");

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
