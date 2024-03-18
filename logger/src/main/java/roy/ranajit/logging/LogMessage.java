package roy.ranajit.logging;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class LogMessage {
    public int level;
    public Timestamp ts_ms;
    public String service;
    public String msg;
}
