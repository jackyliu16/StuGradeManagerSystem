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

    /**
     * check if student id is existed, and it's format is correct
     *
     * @param id student id
     * @return haven't been use
     * @throws DBException DBExceptionEnums.PARAMETER_NOT_EXIST
     *                     DBExceptionEnums.PARAMETER_LENGTH_INCORRECT
     *                     DBExceptionEnums.PARAMETER_TYPE_INCORRECT
     */
    public static boolean check_stu_id(String id) throws DBException {
        boolean flag=false;
        log.debug(String.format("now checking stu id : %s", id));
        check_char11_num(id);
        DataControlCenter dcc = new DataControlCenter();
        flag=dcc.checkStudentId(id);
        if (flag==false)
        {
            throw new DBException(DBExceptionEnums.PARAMETER_NOT_EXIST);
        }
        // TODO check if student existed (return DBException.PAR...NOT_EXIST)
        return flag;
    }

    /**
     * check if teacher id is existed, and it's format is correct
     *
     * @param id teacher id
     * @return haven't been use
     * @throws DBException DBExceptionEnums.PARAMETER_NOT_EXIST
     *                     DBExceptionEnums.PARAMETER_LENGTH_INCORRECT
     *                     DBExceptionEnums.PARAMETER_TYPE_INCORRECT
     */
    public static boolean check_tech_id(String id) throws DBException {
        log.debug(String.format("now checking tech id : %s", id));
        DataControlCenter dcc = new DataControlCenter();
        boolean flag=false;
        flag=dcc.checkTeacherId(id);
        if(flag==false)
        {
            throw new DBException(DBExceptionEnums.PARAMETER_NOT_EXIST);
        }
        // TODO imitate check_stu_id complete it.
        return flag;
    }

    /**
     * check if admin id is existed, and it's format is correct
     *
     * @param id admin id
     * @return haven't been use
     * @throws DBException DBExceptionEnums.PARAMETER_NOT_EXIST
     *                     DBExceptionEnums.PARAMETER_LENGTH_INCORRECT
     *                     DBExceptionEnums.PARAMETER_TYPE_INCORRECT
     */
    public static boolean check_admin_id(String id) throws DBException {
        log.debug(String.format("now checking admin id : %s", id));
        // TODO imitate check_stu_id complete it.
        boolean flag=false;
        DataControlCenter dcc=new DataControlCenter();
        flag=dcc.checkAdminId(id);
        if(flag==false)
        {
            throw new DBException(DBExceptionEnums.PARAMETER_NOT_EXIST);
        }
        return true;
    }

    /**
     * check if the course id is existed, and it's format is correct
     *
     * @param id course
     * @return haven't been use
     * @throws DBException DBExceptionEnums.PARAMETER_NOT_EXIST
     *                     DBExceptionEnums.PARAMETER_LENGTH_INCORRECT
     *                     DBExceptionEnums.PARAMETER_TYPE_INCORRECT
     */
    public static boolean check_course(String id) throws DBException {
        log.debug(String.format("now checking course id : %s", id));
        check_char8_num(id);
        // TODO if course exist
        boolean flag=false;
        DataControlCenter dcc=new DataControlCenter();
        flag=dcc.checkifCourseExsist(id);
        if(flag==false)
        {
            throw new DBException(DBExceptionEnums.PARAMETER_NOT_EXIST);
        }
        return flag;
    }

    /**
     * check if the ＥxCourse id is existed, and it's format is correct
     *
     * @param id ExCourse
     * @return haven't been use
     * @throws DBException DBExceptionEnums.PARAMETER_NOT_EXIST
     *                     DBExceptionEnums.PARAMETER_LENGTH_INCORRECT
     *                     DBExceptionEnums.PARAMETER_TYPE_INCORRECT
     */
    public static boolean check_ex_course(String id) throws DBException {
        log.debug(String.format("now checking ex course id : %s", id));
        check_char8_num(id);
        // TODO if ex course exist
        DataControlCenter dcc=new DataControlCenter();
        boolean flag=false;
        flag=dcc.checkifCourseExsist(id);
        if(flag==false)
        {
            throw new DBException(DBExceptionEnums.PARAMETER_NOT_EXIST);
        }
        return flag;
    }

    /**
     * check if the major id is existed, and it's format is correct
     *
     * @param id major id
     * @return haven't been use
     * @throws DBException DBExceptionEnums.PARAMETER_NOT_EXIST
     *                     DBExceptionEnums.PARAMETER_LENGTH_INCORRECT
     *                     DBExceptionEnums.PARAMETER_TYPE_INCORRECT
     */
    public static boolean check_major(String id) throws DBException {
        log.debug(String.format("now checking major: %s", id));
        check_char4_num(id);
        // TODO check if majorNo is correct
        boolean flag=false;
        DataControlCenter dcc=new DataControlCenter();
        flag=dcc.checkifMajor(id);
        if(flag==false)
        {
            throw new DBException(DBExceptionEnums.PARAMETER_NOT_EXIST);
        }
        return flag;
    }

    /**
     * check if the dept id is existed, and it's format is correct
     *
     * @param id course
     * @return haven't been use
     * @throws DBException DBExceptionEnums.PARAMETER_NOT_EXIST
     *                     DBExceptionEnums.PARAMETER_LENGTH_INCORRECT
     *                     DBExceptionEnums.PARAMETER_TYPE_INCORRECT
     */
    public static boolean check_dept(String id) throws DBException {
        log.debug(String.format("now checking dept: %s", id));
        check_char4_num(id);
        // TODO check if this DeptNo is existed
        boolean flag=false;
        DataControlCenter dcc=new DataControlCenter();
        flag=dcc.checkifDept(id);
        if(flag==false)
        {
            throw new DBException(DBExceptionEnums.PARAMETER_NOT_EXIST);
        }
        return flag;
    }

    // NOTE only analyzer if number length and it's type is correct
    // if haven't num that means allow number + letter

    /**
     * check if string is formatting in length 4 and only contains numbers
     *
     * @param str the string want to check
     * @return haven't been use
     * @throws DBException DBExceptionEnums.PARAMETER_LENGTH_INCORRECT
     *                     DBExceptionEnums.PARAMETER_TYPE_INCORRECT
     */
    public static boolean check_char4_num(String str) throws DBException {
        log.debug(String.format("now checking char4: %s", str));
        if (str.length() != 4) {
            throw new DBException(DBExceptionEnums.PARAMETER_LENGTH_INCORRECT);
        }
        for (char aChar : str.toCharArray()) {
            if (aChar < '0' || aChar > '9') {
                throw new DBException(DBExceptionEnums.PARAMETER_TYPE_INCORRECT);
            }
        }
        return true;
    }

    /**
     * check if string is formatting in length 8 and only contains numbers
     *
     * @param str the string want to check
     * @return haven't been use
     * @throws DBException DBExceptionEnums.PARAMETER_LENGTH_INCORRECT
     *                     DBExceptionEnums.PARAMETER_TYPE_INCORRECT
     */
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

    /**
     * check if string is formatting in length 11 and only contain numbers
     *
     * @param str the string want to check
     * @return haven't been use
     * @throws DBException DBExceptionEnums.PARAMETER_LENGTH_INCORRECT
     *                     DBExceptionEnums.PARAMETER_TYPE_INCORRECT
     */
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

    /**
     * check if string is formatting in length 4 and not include any special character ( only include nums and letters )
     *
     * @param str the string want to check
     * @return haven't been use
     * @throws DBException DBExceptionEnums.PARAMETER_LENGTH_INCORRECT
     *                     DBExceptionEnums.PARAMETER_TYPE_INCORRECT
     */
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
