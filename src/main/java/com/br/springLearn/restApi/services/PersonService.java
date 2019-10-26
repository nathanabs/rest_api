package com.br.springLearn.restApi.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.springLearn.restApi.converter.DozerConverter;
import com.br.springLearn.restApi.converter.custom.PersonConverter;
import com.br.springLearn.restApi.customException.ResourceNotFoundException;
import com.br.springLearn.restApi.data.vo.PersonVO;
import com.br.springLearn.restApi.data.vo.PersonVOV2;
import com.br.springLearn.restApi.model.Person;
import com.br.springLearn.restApi.repository.IPersonRepository;

@Service
public class PersonService {
	
	@Autowired
	IPersonRepository repository;
	
	@Autowired
	PersonConverter personConverter;
	
	public PersonVO create(PersonVO person) {
		Person entity = DozerConverter.parseObject(person, Person.class);
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public List<PersonVO> listAll() {
		
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) throws ResourceNotFoundException {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	}
	
	public PersonVO update(PersonVO person) throws ResourceNotFoundException {
		Person entity =  repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		
		return vo;
	}
	
	public void delete(Long id) throws ResourceNotFoundException {
		Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(person);
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		Person entity = personConverter.convertVOtoEntity(person);
		
		PersonVOV2 vo = personConverter.convertEntityToVO(repository.save(entity));
		
		return vo;
	}
}
