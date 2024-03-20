package roy.ranajit.logreader.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "log_message")
public class LogMessage {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String message;
    @Column(name = "service_name")
    private String service;
    private int logLevel;
    private Timestamp timeStamp;
}
