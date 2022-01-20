package app.consumer_logging.DataModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log {
    @Id
    Long timestamp;
    String sourceIp;
    String request;
    Integer status;

    public Long getTimestamp() {
        return timestamp;
    }

    public Log setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public Log setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
        return this;
    }

    public String getRequest() {
        return request;
    }

    public Log setRequest(String request) {
        this.request = request;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Log setStatus(Integer status) {
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
