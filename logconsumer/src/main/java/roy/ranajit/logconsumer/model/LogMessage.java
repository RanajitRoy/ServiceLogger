package roy.ranajit.logconsumer.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class LogMessage {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String message;
    private String service;
    private int logLevel;
    private Timestamp timeStamp;
}
