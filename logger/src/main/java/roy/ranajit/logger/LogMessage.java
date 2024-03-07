package roy.ranajit.logger;

import lombok.Data;

@Data
public class LogMessage {
    public int level;
    public long ts_ms;
    public String service;
    public String msg;
}
