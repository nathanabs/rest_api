package com.br.springLearn.restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.springLearn.restApi.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{
	
}
