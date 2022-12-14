package tool;
/*
 * @File:   Logger.java
 * @Desc:
 * @Author: jacky
 * @Repo:   https://github.com/jackyliu16
 * @Date:   2022/11/19 下午4:49
 * @Version:0.0
 * @reference:
 *      the design of log level: https://github.com/LearningOS/rust-based-os-comp2022/blob/main/os2-ref/src/logging.rs
 *      singleton: https://www.cnblogs.com/cielosun/p/6582333.html
 */

// Reference from Rust Log
//enum LogLevel {
//    OFF,
//    Error,
//    Warn,
//    Info,
//    Debug,
//    Trace,
//}
public class LoggerOld {
    static LogLevel loglevel = null;

    public LoggerOld() {
        loglevel = LogLevel.Info;
    }

    public LoggerOld(LogLevel logLevel) {
        loglevel = logLevel;
    }

    // trying to use these function to compare between logLevel
    private static int level_into_num(LogLevel logLevel) {
        if (logLevel == LogLevel.OFF) {
            return 0;
        } else if (logLevel == LogLevel.Error) {
            return 1;
        } else if (logLevel == LogLevel.Warn) {
            return 2;
        } else if (logLevel == LogLevel.Info) {
            return 3;
        } else if (logLevel == LogLevel.Debug) {
            return 4;
        } else if (logLevel == LogLevel.Trace) {
            return 5;
        } else {
            return 0;
        }
    }

    private static String level_into_string(LogLevel logLevel) {
        if (logLevel == LogLevel.OFF) {
            return "OFF  ";
        } else if (logLevel == LogLevel.Error) {
            return "ERROR";
        } else if (logLevel == LogLevel.Warn) {
            return "WARN ";
        } else if (logLevel == LogLevel.Info) {
            return "INFO ";
        } else if (logLevel == LogLevel.Debug) {
            return "DEBUG";
        } else if (logLevel == LogLevel.Trace) {
            return "TRACE";
        } else {
            return "NONE  ";
        }
    }

    private static void printColoredString(LogLevel logLevel, String content) {
        if (logLevel != LogLevel.OFF) {
            int num = 30;

            if (logLevel == LogLevel.Error) {
                num = 31;
            } else if (logLevel == LogLevel.Warn) {
                num = 33;
            } else if (logLevel == LogLevel.Info) {
                num = 34;
            } else if (logLevel == LogLevel.Debug) {
                num = 32;
            } else if (logLevel == LogLevel.Trace) {
                num = 36;
            }
            System.out.printf("\u001B[%d;1m%s\u001B[0m%n", num, content);
        }
    }

    /*
     *
     * 30 black
     * 31 red
     * 32 green
     * 33 yellow
     * 34 blue
     * 35 pinkish red
     * 36 cyan
     * 37 white
     */
    private static void log(LogLevel logLevel, String message) {
        if (level_into_num(logLevel) != 0) {
            if (level_into_num(logLevel) <= level_into_num(loglevel)) {
                Thread currenThread = Thread.currentThread();
                StackTraceElement stackTrace = currenThread.getStackTrace()[4];
                String output = String.format("[%s][%s](%s:%s): %s",
                        level_into_string(logLevel),
                        Thread.currentThread().getName(),
                        stackTrace.getFileName(),
                        stackTrace.getLineNumber(),
                        message);
                printColoredString(logLevel, output);
            }
        }
    }

    /**
     * 设置当前日志级别，日志级别较高的情况下会忽略较低级别的日志打印
     * <p>
     * `Error> Warn> Info> Debug> Trace`
     */
    public void setLevel(LogLevel logLevel) {
        loglevel = logLevel;
    }

    public void error(String message) {
        log(LogLevel.Error, message);
    }

    public void warn(String message) {
        log(LogLevel.Warn, message);
    }

    public void info(String message) {
        log(LogLevel.Info, message);
    }

    public void debug(String message) {
        log(LogLevel.Debug, message);
    }

    public void trace(String message) {
        log(LogLevel.Trace, message);
    }
}
