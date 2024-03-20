package roy.ranajit.logreader.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import roy.ranajit.logreader.model.LogMessage;

public interface LogRepository extends PagingAndSortingRepository<LogMessage, Integer> {
    public Page<LogMessage> findAllByService(String serviceName, Pageable pageable);
}
