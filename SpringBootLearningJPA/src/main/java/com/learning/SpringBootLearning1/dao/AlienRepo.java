package com.learning.SpringBootLearning1.dao;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.learning.SpringBootLearning1.model.Alien;

//public interface AlienRepo extends CrudRepository<Alien, Integer> {
//	List<Alien> findByTech(String tech);
//	List<Alien> findByAidGreaterThan(int aid);
//	
//	@Query("from Alien where tech=?1 order by aname")
//	List<Alien> findByTechSorted(String tech);
//}

public interface AlienRepo extends JpaRepository<Alien, Integer> {

	
	
}
