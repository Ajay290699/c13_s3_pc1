package com.niit.c13_s3_pc1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "Customer not found")
public class CustomerNotFoundException extends Exception{
}
