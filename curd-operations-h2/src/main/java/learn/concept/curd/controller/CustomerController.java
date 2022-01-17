package learn.concept.curd.controller;

import java.util.List;

import learn.concept.curd.model.CustomerDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.concept.curd.exception.RecordNotFoundException;
import learn.concept.curd.service.CustomerDetailsService;
 
@RestController
@RequestMapping("/customerdetails")
public class CustomerController
{
    @Autowired
    CustomerDetailsService service;
 
    @GetMapping
    public ResponseEntity<List<CustomerDetailsEntity>> getAllCustomerDetails() {
        List<CustomerDetailsEntity> list = service.getAllCustomerDetails();
 
        return new ResponseEntity<List<CustomerDetailsEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailsEntity> getEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        CustomerDetailsEntity entity = service.getCustomerDetailsById(id);
 
        return new ResponseEntity<CustomerDetailsEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<CustomerDetailsEntity> createOrUpdateEmployee(CustomerDetailsEntity customerDetails)
                                                    throws RecordNotFoundException {
        CustomerDetailsEntity updated = service.createOrUpdateCustomerDetails(customerDetails);
        return new ResponseEntity<CustomerDetailsEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteCustomerDetailsById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}