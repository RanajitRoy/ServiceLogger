package roy.ranajit.logreader.repository;

import org.springframework.data.repository.CrudRepository;

import roy.ranajit.logreader.model.Service;

public interface ServiceRepository extends CrudRepository<Service, String> {
    
}
