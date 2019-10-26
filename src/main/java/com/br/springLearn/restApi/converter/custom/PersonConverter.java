package com.br.springLearn.restApi.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.br.springLearn.restApi.data.vo.PersonVOV2;
import com.br.springLearn.restApi.model.Person;

@Service
public class PersonConverter {
	
	public PersonVOV2 convertEntityToVO(Person person) {
		
		PersonVOV2 vo = new PersonVOV2();
		
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setAdress(person.getAdress());
		vo.setBirthday(new Date());
		vo.setGender(person.getGender());
		vo.setId(person.getId());
		
		return vo;
	}
	
public Person convertVOtoEntity(PersonVOV2 person) {
		
		Person entity = new Person();
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		entity.setId(person.getId());
		
		return entity;
	}
}
