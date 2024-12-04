package com.bigdata;

import com.bigdata.dao.LogDao;
import com.bigdata.model.LogEntry;
import com.bigdata.util.DBUtil;

import java.sql.Connection;
import java.util.*;
import java.util.regex.*;

public class App {

    public static void main(String[] args) {
        Connection conn = DBUtil.getConnectDb();
        if (conn != null) {
            System.out.println("数据库连接成功");
        } else {
            System.out.println("数据库连接失败");
        }

        // 创建 LogDao 对象
        LogDao logDao = new LogDao();

        // 获取所有日志
        List<LogEntry> logEntries = logDao.getAllLogs();

        // 打印解析后的日志条目
        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry);
        }
    }



    /**
     * 直接把日志信息存放在字符串中
     */
//    // 定义正则表达式来提取日志中的各个部分
//    private static final String LOG_PATTERN =
//            "(\\d+\\.\\d+\\.\\d+\\.\\d+) - - \\[(.*?)\\] \"(.*?)\" (\\d+) (\\d+|-)";
//
//    public static void main(String[] args) {
//        // 直接把日志信息存放在字符串中
//        String logData = "110.75.173.48 - - [30/May/2013:23:59:58 +0800] \"GET /thread-36410-1-9.html HTTP/1.1\" 200 68629\n"
//                + "220.181.89.186 - - [30/May/2013:23:59:59 +0800] \"GET /forum.php?mod=attachment&aid=Mjg3fDgyN2E0M2UzfDEzNTA2Mjc3MzF8MHwxNTU5 HTTP/1.1\" 200 -\n"
//                + "112.122.34.89 - - [30/May/2013:23:59:59 +0800] \"GET /forum.php?mod=ajax&action=forumchecknew&fid=91&time=1369929501&inajax=yes HTTP/1.1\" 200 66";
//
//        // 分割字符串为多行日志
//        String[] logLines = logData.split("\n");
//
//        // 创建一个 List 来存储解析后的日志对象
//        List<LogEntry> logEntries = new ArrayList<>();
//
//        // 逐行解析日志并存入 logEntries 列表
//        for (String line : logLines) {
//            LogEntry logEntry = parseLog(line);
//            if (logEntry != null) {
//                logEntries.add(logEntry);
//            }
//        }
//
//        // 打印解析后的日志条目
//        for (LogEntry logEntry : logEntries) {
//            System.out.println(logEntry);
//        }
//    }
//
//    // 解析每行日志并返回 LogEntry 对象
//    public static LogEntry parseLog(String logLine) {
//        Pattern pattern = Pattern.compile(LOG_PATTERN);
//        Matcher matcher = pattern.matcher(logLine);
//
//        if (matcher.matches()) {
//            // 提取各个字段
//            String ip = matcher.group(1); // 访问IP
//            String timestamp = matcher.group(2); // 访问时间
//            String resource = matcher.group(3); // 访问资源
//            int status = Integer.parseInt(matcher.group(4)); // 请求状态
//            int responseSize = "-".equals(matcher.group(5)) ? 0 : Integer.parseInt(matcher.group(5)); // 响应大小，"-" 处理为 0
//
//            // 创建并返回 LogEntry 对象
//            return new LogEntry(ip, timestamp, resource, status, responseSize);
//        } else {
//            // 如果日志格式不匹配，返回 null
//            System.out.println("日志格式不匹配: " + logLine);
//            return null;
//        }
//    }
}
