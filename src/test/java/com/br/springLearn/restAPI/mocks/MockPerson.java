package com.br.springLearn.restAPI.mocks;

import java.util.ArrayList;
import java.util.List;

import com.br.springLearn.restApi.data.vo.PersonVO;
import com.br.springLearn.restApi.model.Person;

public class MockPerson {
	
	public Person mockEntity() {
		return mockEntity(0);
	}
	
	public PersonVO mockVO() {
		return mockVO(0);
	}
	
	public List<Person> mockEntityList(){
		List<Person> persons = new ArrayList<Person>();
		for(int i = 0; i <= 14; i++) {
			persons.add(mockEntity(i));
		}
		return persons;
	}
	

	public List<PersonVO> mockVOList(){
		List<PersonVO> persons = new ArrayList<PersonVO>();
		for(int i = 0; i <= 14; i++) {
			persons.add(mockVO(i));
		}
		return persons;
	}
	
	private Person mockEntity(Integer i) {
		Person person = new Person();
		person.setAdress("Addres Test "+ i);
		person.setFirstName("First Name Test " + i);
		person.setLastName("Last Name Test "+i);
		person.setGender(((i % 2) == 0) ? "Male" : "Female");
		person.setId(i.longValue());
		return person;
	}
	
	private PersonVO mockVO(Integer i) {
		PersonVO person = new PersonVO();
		person.setAdress("Addres Test "+ i);
		person.setFirstName("First Name Test " + i);
		person.setLastName("Last Name Test "+i);
		person.setGender(((i % 2) == 0) ? "Male" : "Female");
		person.setId(i.longValue());
		return person;
	}
	
	
}
