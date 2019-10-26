package com.br.springLearn.restApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.springLearn.restApi.customException.ResourceNotFoundException;
import com.br.springLearn.restApi.data.vo.PersonVO;
import com.br.springLearn.restApi.data.vo.PersonVOV2;
import com.br.springLearn.restApi.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@GetMapping
	public List<PersonVO> listAll() {
		return service.listAll();
	}
	
	@GetMapping(value="/{id}")
	public PersonVO findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return service.findById(id);
	}
	
	@PostMapping
	public PersonVO create(@RequestBody PersonVO personVO) throws ResourceNotFoundException {
		return service.create(personVO);
	}
	
	@PutMapping
	public PersonVO update(@RequestBody PersonVO personVO) throws ResourceNotFoundException {
		return service.update(personVO);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
		service.delete(id);
	}
	
	@PostMapping("/v2")
	public PersonVOV2 createV2(@RequestBody PersonVOV2 personVOV2) throws ResourceNotFoundException {
		return service.createV2(personVOV2);
	}
}
