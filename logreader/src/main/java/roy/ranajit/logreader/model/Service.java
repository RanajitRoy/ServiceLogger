package roy.ranajit.logreader.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Service {
    @Id
    private String name;
}
