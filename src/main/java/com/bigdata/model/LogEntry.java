package com.bigdata.model;

public class LogEntry {
    private String ip;
    private String timestamp;
    private String resource;
    private int status;
    private int responseSize;

    // 构造方法
    public LogEntry(String ip, String timestamp, String resource, int status, int responseSize) {
        this.ip = ip;
        this.timestamp = timestamp;
        this.resource = resource;
        this.status = status;
        this.responseSize = responseSize;
    }

    // Getter 和 Setter
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(int responseSize) {
        this.responseSize = responseSize;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "ip='" + ip + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", resource='" + resource + '\'' +
                ", status=" + status +
                ", responseSize=" + responseSize +
                '}';
    }
}
