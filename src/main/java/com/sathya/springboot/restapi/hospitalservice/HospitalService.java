package com.sathya.springboot.restapi.hospitalservice;

import java.util.List;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springboot.restapi.hospitalmodel.HospitalModel;
import com.sathya.springboot.restapi.hospitalrepository.HospitalRepository;


@Service
public class HospitalService {
	@Autowired
	HospitalRepository hospitalRepository;

	public  HospitalModel saveHospitalDetails(HospitalModel hospitalModel) {
		   return hospitalRepository.save(hospitalModel);
	}

	public List<HospitalModel> saveAllHospitalDetails(List<HospitalModel> hospitalModels) {
		  		    return hospitalRepository.saveAll(hospitalModels);
	}

	public   List<HospitalModel> getAllHospitals() 
	{
		        return hospitalRepository.findAll();
	
      
	}

	public Optional<HospitalModel> searchHospitalById(long id) {
		      Optional<HospitalModel> optionaldata=hospitalRepository.findById(id);
		      return optionaldata;
		
	}
	public Optional<HospitalModel> searchHospitalByName(String name) {
		 Optional<HospitalModel> optionaldata=hospitalRepository.findByName(name);
	      return optionaldata;
	}


	public Optional<HospitalModel> searchByLocation(String location) 
	{
		              Optional<HospitalModel> optionaldata=hospitalRepository.findByLocation(location);
		                
		                return optionaldata;

		
	}
	public List<HospitalModel> searchByNameAndLocation(String name,String location) {
		List<HospitalModel> hospitals = hospitalRepository.findByNameAndLocation( name, location );
	    return hospitals;
		
	}
	public List<HospitalModel> getByLocationAndRating(double minRating ,double maxRating,String location) 
	 {
		List<HospitalModel> hospitals = hospitalRepository.findByRatingBetweenAndLocation(minRating, maxRating, location);
		
		    return hospitals;
	}


	public List<HospitalModel> sortbyRating() {
		List<HospitalModel> hospitals = hospitalRepository.findAllByOrderByRatingAsc();

		return hospitals;
	}
	public List<HospitalModel> getbyrating(double minRating, double maxRating) {
	    List<HospitalModel> hospitals = hospitalRepository.findByRatingBetween(minRating, maxRating);
	    return hospitals;
	}

	public List<HospitalModel> getbygreterrating(double rating) {
		 return   hospitalRepository.findHospitalsByRatingGreaterThan(rating);
		
	}

	public List<HospitalModel> getbylesserrating(double rating) {
		  List<HospitalModel> hospitals=hospitalRepository.findHospitalsByRatingLessThan(rating);
		return hospitals;
	}


	public boolean deletebyid(long id) {
		if(hospitalRepository.existsById(id))
		{
			hospitalRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public void deletebybyrating(double minRating, double maxRating) {
		hospitalRepository.deleteByRatingBetween(minRating,maxRating);

	}
	
    public void deleteByRatingGreterThan(double rating)
    {
    	 hospitalRepository.deleteByRatingGreaterThan(rating);
    }
    
    public  boolean deleteHospitalByname(String name) 
    {
		if(hospitalRepository.existsByName(name))
		{
			
			hospitalRepository.deleteByName(name);
			return true;
		}
		return false;
	}
	public boolean deleteHospitalByemail(String email) {
		if(hospitalRepository.existsByEmail(email))
		{
			
			hospitalRepository.deleteByEmail(email);
			return true;
		}
		return false;
	}



	public void deletebyratingandlocation(double rating, String location) {
		hospitalRepository.deleteByRatingAndLocation(rating, location);
		
	}

	public HospitalModel updatebyid(long id,Map< String, Object> updates) {
			  Optional<HospitalModel> optionalhospital =hospitalRepository.findById(id);
			  if(optionalhospital.isPresent())
			  {
                    HospitalModel existinghospital=optionalhospital.get();	
                    if(updates.containsKey("name"))
                    {
                    	existinghospital.setName((String)updates.get("name"));
                    }
                    if(updates.containsKey("location"))
                    {
                    	existinghospital.setLocation((String)updates.get("location"));
                    }
                    if(updates.containsKey("rating"))
                    {
                    	existinghospital.setRating((double)updates.get("rating"));
                    }
                    if(updates.containsKey("email"))
                    {
                    	existinghospital.setEmail((String)updates.get("email"));
                    }
                    
                    	return hospitalRepository.save(existinghospital);
                    			
                    }
                    return null;
                    
		  
		
	}
	

	public Optional<HospitalModel> updateHospitalbyid( HospitalModel newHospitalModel ,long id) {
		
		 Optional<HospitalModel> optionaldata=hospitalRepository.findById(id);
		 if(optionaldata.isPresent())
		 {
			 HospitalModel existinghospital= optionaldata.get();
			 existinghospital.setName(newHospitalModel.getName());
			 existinghospital.setLocation(newHospitalModel.getLocation());
			 existinghospital.setRating(newHospitalModel.getRating());
			 existinghospital.setEmail(newHospitalModel.getEmail());
			 existinghospital.setAdress(newHospitalModel.getAdress());
			 existinghospital.setDoctors(newHospitalModel.getDoctors());
			 hospitalRepository.save(existinghospital);
			 return optionaldata;
		 }
		
		 
			 return null;
		 
		 
	}


	

	public HospitalModel updatebyname(String name, Map<String, Object> updates) {
		
		 Optional<HospitalModel> optionalhospital =hospitalRepository.findByName(name);
		  if(optionalhospital.isPresent())
		  {
               HospitalModel existinghospital=optionalhospital.get();	
               if(updates.containsKey("name"))
               {
               	existinghospital.setName((String)updates.get("name"));
               }
               if(updates.containsKey("location"))
               {
               	existinghospital.setLocation((String)updates.get("location"));
               }
               if(updates.containsKey("rating"))
               {
               	existinghospital.setRating((double)updates.get("rating"));
               }
               if(updates.containsKey("email"))
               {
               	existinghospital.setEmail((String)updates.get("email"));
               }

               	return hospitalRepository.save(existinghospital);
               			
               }
               return null;
               
		
	}

	


	

	 
}

