package learn.concept.curd.service;

import learn.concept.curd.exception.RecordNotFoundException;
import learn.concept.curd.model.CustomerDetailsEntity;
import learn.concept.curd.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
@Service
public class CustomerDetailsService {
     
    @Autowired
    CustomerDetailsRepository repository;
     
    public List<CustomerDetailsEntity> getAllEmployees()
    {
        List<CustomerDetailsEntity> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<CustomerDetailsEntity>();
        }
    }
     
    public CustomerDetailsEntity getEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<CustomerDetailsEntity> customerDetails = repository.findById(id);
         
        if(customerDetails.isPresent()) {
            return customerDetails.get();
        } else {
            throw new RecordNotFoundException("No customerDetails record exist for given id");
        }
    }
     
    public CustomerDetailsEntity createOrUpdateEmployee(CustomerDetailsEntity entity) throws RecordNotFoundException
    {
        Optional<CustomerDetailsEntity> customerDetails = repository.findById(entity.getId());
         
        if(customerDetails.isPresent())
        {
            CustomerDetailsEntity newEntity = customerDetails.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<CustomerDetailsEntity> customerDetails = repository.findById(id);
         
        if(customerDetails.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No customerDetails record exist for given id");
        }
    }
}