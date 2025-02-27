package com.sathya.springboot.restapi.hospitalrepository;

import java.util.List;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sathya.springboot.restapi.hospitalmodel.HospitalModel;

import jakarta.transaction.Transactional;


@Repository
public interface HospitalRepository extends JpaRepository<HospitalModel, Long> {
	
	Optional<HospitalModel>  findByName(String name);


 	 Optional<HospitalModel> findByLocation(String location);
 	 
 	 


	 @Query("SELECT h FROM HospitalModel h WHERE h.name = ?1 AND h.location = ?2")
	 List<HospitalModel> findByNameAndLocation(String name, String location);


	 @Query("SELECT h FROM HospitalModel h WHERE  h.rating BETWEEN :minRating AND :maxRating AND  h.location = :location")
	 List<HospitalModel> findByRatingBetweenAndLocation(@Param("minRating") double minRating, 
	                                                    @Param("maxRating") double maxRating,
	                                                    @Param("location") String location);



	List<HospitalModel> findAllByOrderByRatingAsc();

 	 
 	
 
 @Transactional
 @Modifying
// @Query("DELETE FROM HospitalModel h WHERE h.rating BETWEEN :minRating AND :maxRating")
 void deleteByRatingBetween(@Param("minRating") double minRating,
                            @Param("maxRating") double maxRating);
 
 @Transactional
 @Modifying
 void deleteByRatingGreaterThan(double rating);

   List<HospitalModel> findByRatingBetween(double minRating,double maxRating);
   

 List<HospitalModel> findHospitalsByRatingGreaterThan(double rating);

 List<HospitalModel> findHospitalsByRatingLessThan( @Param("lesserthan") double rating);
 
 

 @Query("SELECT COUNT(h) > 0 FROM HospitalModel h WHERE h.name = :name")
 boolean existsByName( String name);
	 @Transactional
	 @Modifying
 	void deleteByName(String name);
//	@Query("SELECT COUNT(h) > 0 FROM HospitalModel h WHERE h.email = :email")
	boolean existsByEmail(String email);
	@Transactional
	@Modifying	
	void deleteByEmail(String email);

	 @Transactional
	 @Modifying
	 @Query("delete from HospitalModel  h WHERE h.rating=?1 AND h.location=?2 ")
	  void deleteByRatingAndLocation(@Param("rating") double rating,
                                            @Param("location") String location);


	


	 
	 
	


	
}  
