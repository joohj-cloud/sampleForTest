package com.example.samplespringboot;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/customer")
public class SampleController {

    @GetMapping
    public Customer getCustomer(@RequestParam String name, @RequestParam String email ){
        log.info("[INFO] name = {}, age = {}", name, email);
        log.info("Create New Object");

        Customer customer = new Customer();
        customer.setName(name);
        customer.setAge(100);
        customer.setEmail(email);

        log.info("[INFO] customer name = {}, age = {}", customer.getName(), customer.getEmail());

        log.info("test");
        return customer;
    }
}
