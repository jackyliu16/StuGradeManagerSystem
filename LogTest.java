
/*
 * @File:   LogTest.java
 * @Desc:
 * @Author: jacky
 * @Repo:   https://github.com/jackyliu16
 * @Date:   2022/11/18 下午11:37
 * @Version:0.0
 */

//import java.util.logging.Logger;
//public class LogTest {
//    static String strClassName = LogTest.class.getName();
//    static Logger logger = Logger.getLogger(strClassName);
//
//    public static double division(int value1, int value2) {
//        double res = 0;
//        try {
//            res = value1 / value2;
//        } catch (ArithmeticException e) {
//            logger.warning("divider shouldn't been 0");
//            e.printStackTrace();
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(division(5, 0));
//    }
//
//}

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//
//public class LogTest {
//    private static Logger log = LogManager.getLogger(LogTest.class);
//
//    public static void main(String[] args) {
//        BasicConfigurator.configure();
//        log.info("test run");
//    }
//}