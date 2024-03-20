package roy.ranajit.logconsumer.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Service {
    @Id
    private String name;
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<LogMessage> logs;
}
