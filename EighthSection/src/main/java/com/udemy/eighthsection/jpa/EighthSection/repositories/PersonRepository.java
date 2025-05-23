package com.udemy.eighthsection.jpa.EighthSection.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.udemy.eighthsection.jpa.EighthSection.dto.PersonDTO;
import com.udemy.eighthsection.jpa.EighthSection.entities.Person;
import java.util.List;
import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.id in ?1")
    List<Person> getPersonsById(List<Long> ids);

    @Query("select p.name, length(p.name) from Person p where length(p.name)=(select max(length(p.name)) from Person p)")
    List<Object[]> getLongestName();

    @Query("select p.name, length(p.name) from Person p where length(p.name)=(select min(length(p.name)) from Person p)")
    List<Object[]> getShorterName();

    @Query("select min(p.id), max(p.id), sum(p.id), avg(length(p.name)), count(p.id) from Person p")
    Object getResumeAggregationFunction();

    @Query("select max(length(p.name)) from Person p")
    Long getMaxNameLength();

    @Query("select min(length(p.name)) from Person p")
    Long getMinNameLength();

    @Query("select p.name, length(p.name) from Person p")
    List<Object[]> getPersonNameLenght();

    @Query("select count(p) from Person p")
    Long totalPerson();

    @Query("select min(p.id) from Person p")
    Long minId();
    
    @Query("select max(p.id) from Person p")
    Long maxId();

    @Query("select p from Person p order by p.name asc")
    List<Person> getAllOrdered();

    List<Person> findByIdBetween(Long id1, Long id2);

    List<Person> findByNameBetween(String letter1, String letter2);

    @Query("select p from Person p where p.name between ?1 and ?2")
    List<Person> findAllBetweenName(String letter1, String letter2);

    @Query("select p from Person p where p.name between ?1 and ?2 order by p.name, p.lastname desc")
    List<Person> findAllBetweenNameOrdered(String letter1, String letter2);

    @Query("select p from Person p where p.name between 'A' and 'M'")
    List<Person> findAllBetweenName();

    @Query("select p from Person p where p.id between ?1 and ?2")
    List<Person> findAllBetweenId(Long letter1, Long letter2);

    @Query("select p from Person p where p.id between 2 and 5")
    List<Person> findAllBetweenId();

    @Query("select p.id, upper(p.name), lower(p.lastname), upper(p.programmingLanguage) from Person p")
    List<Object[]> findAllPersonDataListCase();

    @Query("select upper(concat(p.name, ' ', p.lastname)) from Person p")
    List<String> findAllFullnameConcatUpper();

    @Query("select lower(concat(p.name, ' ', p.lastname)) from Person p")
    List<String> findAllFullnameConcatLower();

    @Query("select concat(p.name, ' ', p.lastname) from Person p")
    List<String> findAllFullnameConcat();

    @Query("select p.name || ' ' || p.lastname from Person p")
    List<String> findAllFullnamePipe();

    @Query("select p.name from Person p")
    List<String> findAllNames();

    @Query("select distinct(p.name) from Person p")
    List<String> findAllNamesDistinct();

    @Query("select count(distinct(p.programmingLanguage)) from Person p")
    long findAllProgrammingLanguageDistinctCount();

    @Query("select distinct(p.programmingLanguage) from Person p")
    List<String> findAllProgrammingLanguageDistinct();

    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllCustomPerson();

    @Query("select new com.udemy.eighthsection.jpa.EighthSection.dto.PersonDTO(p.name, p.lastname) from Person p")
    List<PersonDTO> findAllCustomPersonDTO();
    
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

    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id =?1")
    Object obtenerPersonFullDataById(Long id);

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();

    @Query("select p.name, p.programmingLanguage from Person p where p.name=?1 and p.programmingLanguage=?2")
    List<Object[]> obtenerPersonData(String name, String programmingLanguage);

    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMixPersonDataList();
}
