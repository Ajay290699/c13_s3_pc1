package com.niit.c13_s3_pc1.service;

import com.niit.c13_s3_pc1.domain.Customer;
import com.niit.c13_s3_pc1.exception.CustomerAlreadyExistException;
import com.niit.c13_s3_pc1.exception.CustomerNotFoundException;
import com.niit.c13_s3_pc1.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistException {
        if (customerRepository.findById(customer.getCustomerId()).isEmpty()) {
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public String deleteCustomer(int id) throws CustomerNotFoundException {
        if (customerRepository.findById(id).isEmpty()){
            throw new CustomerNotFoundException();
        }
        return "Customer Deletd successfully";
    }

    @Override
    public List<Customer> getCustomerWhoBougthSamsungPhone(String product) {
        return customerRepository.getCustomerWhoBougthSamsungPhone(product);
    }
}
