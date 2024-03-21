package sigs.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import sigs.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sigs.api.exception.RecordNotFoundException;
import sigs.api.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> result = (List<Employee>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Employee>();
		}
	}
	
	public Employee getEmployeeById(Long id) throws RecordNotFoundException
	{
		Optional<Employee> employee = repository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No sigs record exist for given id");
		}
	}
	
	public Employee createOrUpdateEmployee(Employee entity)
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<Employee> employee = repository.findById(entity.getId());
			
			if(employee.isPresent()) 
			{
				Employee newEntity = employee.get();
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
	} 
	
	public void deleteEmployeeById(Long id) throws RecordNotFoundException 
	{
		Optional<Employee> employee = repository.findById(id);
		
		if(employee.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No sigs record exist for given id");
		}
	} 
}