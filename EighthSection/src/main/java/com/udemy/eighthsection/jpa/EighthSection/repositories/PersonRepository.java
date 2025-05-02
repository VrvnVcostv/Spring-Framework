package com.udemy.eighthsection.jpa.EighthSection.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.udemy.eighthsection.jpa.EighthSection.entities.Person;
import java.util.List;
import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person, Long> {
    
    @Query("select p.name from Person p where p.id =?1")
    String getNameById(Long id);

    @Query("select concat(p.name, ' ', p.lastname) from Person p where p.id =?1")
    String getFullnameById(Long id);

    @Query("select p from Person p where p.id =?1")
    Optional<Person> findOne(Long id); 

    @Query("select p from Person p where p.name =?1")
    Optional<Person> findOneName(String id); 
    
    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneNameLike(String id); 
    
    Optional<Person> findByNameContaining(String name); 
    
    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarPorProgrammingLanguageAndName(String programmingLanguage, String name);
    
    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();

    @Query("select p.name, p.programmingLanguage from Person p where p.name=?1 and p.programmingLanguage=?2")
    List<Object[]> obtenerPersonData(String name, String programmingLanguage);
}
