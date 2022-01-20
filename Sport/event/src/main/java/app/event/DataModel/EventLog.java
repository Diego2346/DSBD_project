package app.event.DataModel;

public class EventLog {

    Long timestamp;
    String sourceIp;
    String request;
    Integer status;

    public Long getTimestamp() {
        return timestamp;
    }

    public EventLog setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public EventLog setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
        return this;
    }

    public String getRequest() {
        return request;
    }

    public EventLog setRequest(String request) {
        this.request = request;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public EventLog setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "Log{" +
                "timestamp=" + timestamp +
                ", Ip='" + sourceIp + '\'' +
                ", request='" + request + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
