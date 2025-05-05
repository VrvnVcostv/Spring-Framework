package com.udemy.ninthsection.jpa.NinthSection.repositories;

import org.springframework.data.repository.CrudRepository;

import com.udemy.ninthsection.jpa.NinthSection.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

}
