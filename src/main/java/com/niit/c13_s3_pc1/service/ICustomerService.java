package com.niit.c13_s3_pc1.service;

import com.niit.c13_s3_pc1.domain.Customer;
import com.niit.c13_s3_pc1.exception.CustomerAlreadyExistException;
import com.niit.c13_s3_pc1.exception.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {

    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistException;
    public List<Customer> getAllCustomer();
    public String deleteCustomer(int id) throws CustomerNotFoundException;
    public List<Customer> getCustomerWhoBougthSamsungPhone(String product);
}
