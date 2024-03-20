package roy.ranajit.logreader.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import roy.ranajit.logreader.model.Service;
import roy.ranajit.logreader.repository.ServiceRepository;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepo;

    @GetMapping
    public Iterable<Service> getMethodName() {
        Iterable<Service> allServices = serviceRepo.findAll();
        return allServices;
    }
}
