package com.bigdata.dao;

import com.bigdata.model.LogEntry;
import com.bigdata.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogDao {

    // 查询所有日志信息
    public List<LogEntry> getAllLogs() {
        List<LogEntry> logEntries = new ArrayList<>();
        String sql = "SELECT ip, timestamp, resource, status, response_size FROM logs";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // 获取数据库连接
            conn = DBUtil.getConnectDb();
            // 创建 PreparedStatement 对象
            stmt = conn.prepareStatement(sql);
            // 执行查询
            rs = stmt.executeQuery();

            // 处理查询结果
            while (rs.next()) {
                // 获取每一行数据并封装到 LogEntry 对象中
                String ip = rs.getString("ip");
                String timestamp = rs.getString("timestamp");
                String resource = rs.getString("resource");
                int status = rs.getInt("status");
                int responseSize = rs.getInt("response_size");

                LogEntry logEntry = new LogEntry(ip, timestamp, resource, status, responseSize);
                logEntries.add(logEntry);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库资源
            DBUtil.CloseDB(rs, stmt, conn);
        }

        return logEntries;
    }
}
