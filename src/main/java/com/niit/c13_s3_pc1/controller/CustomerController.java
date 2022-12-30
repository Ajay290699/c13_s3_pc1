package com.niit.c13_s3_pc1.controller;

import com.niit.c13_s3_pc1.domain.Customer;
import com.niit.c13_s3_pc1.exception.CustomerAlreadyExistException;
import com.niit.c13_s3_pc1.exception.CustomerNotFoundException;
import com.niit.c13_s3_pc1.service.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

    ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        try {
            return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
        } catch (CustomerAlreadyExistException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/customer")
    public ResponseEntity<?> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.CREATED);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable int id){
        try {
            return new ResponseEntity<>(customerService.deleteCustomer(id),HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/customers/{product}")
    public ResponseEntity<?> getCustomerBySamsungPhone(@PathVariable String product){
        return new ResponseEntity<>(customerService.getCustomerWhoBougthSamsungPhone(product),HttpStatus.OK);
    }

}
