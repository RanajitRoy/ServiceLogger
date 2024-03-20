package roy.ranajit.logreader.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roy.ranajit.logreader.repository.LogRepository;
import roy.ranajit.logreader.model.LogMessage;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(path="/logs")
public class LogReaderController {
    @Autowired
    LogRepository logRepo;

    @GetMapping("/service/{serviceName}")
    public Page<LogMessage> getMethodName(@PathVariable String serviceName, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="10") int pageSize, @RequestParam(defaultValue="asc") String sort) {
        Pageable pageable = PageRequest.of(
            page,
            pageSize,
            (sort != "dsc")? Sort.by("timeStamp").ascending():Sort.by("timeStamp").descending());
        Page<LogMessage> actualPage = logRepo.findAllByService(serviceName, pageable);
        // Page<LogMessage> actualPage = logRepo.findAll(pageable);
        return actualPage;
    }
}
