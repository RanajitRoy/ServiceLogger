package roy.ranajit.logconsumer.model;

import org.springframework.data.repository.CrudRepository;

public interface LogRepostiory extends CrudRepository<LogMessage, Integer> {
    
}
