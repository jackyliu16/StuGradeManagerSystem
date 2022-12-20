package databasesOperation;
/*
 * @File:   ValidityOfParameters.java
 * @Desc:
 * @Author: jacky
 * @Repo:   https://github.com/jackyliu16
 * @Date:   2022/12/16 下午5:22
 * @Version:0.0
 */


import tool.Logger;

// NOTE the different between check specific type and normal is weather need to keep complete correct
// NOTE now the return value haven't been used
public class ValidityOfParameters {
    static final Logger log = Logger.INSTANCE;

    public static boolean check_stu_id(String id) throws DBException {
        log.debug(String.format("now checking stu id : %s", id));
        check_char11_num(id);
        DataControlCenter dcc = new DataControlCenter();
        // TODO check if student existed (return DBException.PAR...NOT_EXIST)
        return true;
    }

    public static boolean check_tech_id(String id) throws DBException {
        log.debug(String.format("now checking tech id : %s", id));
        // TODO imitate check_stu_id complete it.
        return true;
    }

    public static boolean check_admin_id(String id) throws DBException {
        log.debug(String.format("now checking admin id : %s", id));
        // TODO imitate check_stu_id complete it.
        return true;
    }

    public static boolean check_course(String id) throws DBException {
        log.debug(String.format("now checking course id : %s", id));
        check_char8_num(id);
        // TODO if course exist
        return true;
    }

    public static boolean check_ex_course(String id) throws DBException {
        log.debug(String.format("now checking ex course id : %s", id));
        check_char8_num(id);
        // TODO if ex course exist
        return true;
    }

    public static boolean check_major(String id) throws DBException {
        log.debug(String.format("now checking major: %s", id));
        check_char4_num(id);
        // TODO check if majorNo is correct
        return true;
    }

    public static boolean check_dept(String id) throws DBException {
        log.debug(String.format("now checking dept: %s", id));
        check_char4_num(id);
        // TODO check if this DeptNo is existed
        return true;
    }

    // NOTE only analyzer if number length and it's type is correct
    // if haven't num that means allow number + letter
    public static boolean check_char4_num(String id) throws DBException {
        log.debug(String.format("now checking char4: %s", id));
        if (id.length() != 11) {
            throw new DBException(DBExceptionEnums.PARAMETER_LENGTH_INCORRECT);
        }
        for (char aChar : id.toCharArray()) {
            if (aChar < '0' || aChar > '9') {
                throw new DBException(DBExceptionEnums.PARAMETER_TYPE_INCORRECT);
            }
        }
        return true;
    }

    public static boolean check_char8_num(String id) throws DBException {
        log.debug(String.format("now checking char8: %s", id));
        if (id.length() != 8) {
            throw new DBException(DBExceptionEnums.PARAMETER_LENGTH_INCORRECT);
        }
        for (char aChar : id.toCharArray()) {
            if (aChar < '0' || aChar > '9') {
                throw new DBException(DBExceptionEnums.PARAMETER_TYPE_INCORRECT);
            }
        }
        return true;
    }

    public static boolean check_char11_num(String id) throws DBException {
        log.debug(String.format("now checking char11: %s", id));
        if (id.length() != 11) {
            throw new DBException(DBExceptionEnums.PARAMETER_LENGTH_INCORRECT);
        }
        for (char aChar : id.toCharArray()) {
            if (aChar < '0' || aChar > '9') {
                throw new DBException(DBExceptionEnums.PARAMETER_TYPE_INCORRECT);
            }
        }
        return true;
    }

    public static Boolean check_char32(String str) throws DBException {
        log.debug(String.format("now checking char32: %s", str));
        if (str.length() > 32) {
            throw new DBException(DBExceptionEnums.PARAMETER_LENGTH_INCORRECT);
        }
        for (char aChar : str.toCharArray()) {
            if ((aChar >= '0' && aChar <= '9') || (aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z')) {
                throw new DBException(DBExceptionEnums.PARAMETER_TYPE_INCORRECT);
            }
        }
        return true;
    }
}
