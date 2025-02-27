package com.sathya.springboot.restapi.hospitalcontroller;

import java.time.LocalDateTime;







import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.springboot.restapi.apiresponse.ApiResponse;
import com.sathya.springboot.restapi.hospitalmodel.HospitalModel;
import com.sathya.springboot.restapi.hospitalrepository.HospitalRepository;
import com.sathya.springboot.restapi.hospitalservice.HospitalService;





@RestController
//@RequestMapping("/api/v1")
public class HospitalController {
	@Autowired
	HospitalService hospitalService;

	@PostMapping("/saveHospital")
	public ResponseEntity<HospitalModel> saveHospitalDetails(@RequestBody HospitalModel hospitalModel)
	{
		      HospitalModel save=hospitalService.saveHospitalDetails(hospitalModel);
		      return ResponseEntity.status(HttpStatus.CREATED)
		    		            .header("info", "data saved success")
		    		            .body(save);
	}
	@PostMapping("/saveAllHospitals")
	public ResponseEntity<List< HospitalModel>> saveAllhospitaldetails(@RequestBody List< HospitalModel> hospitalModels)
	{
		      List<HospitalModel> saveall=hospitalService.saveAllHospitalDetails(hospitalModels);
		      return ResponseEntity.status(HttpStatus.CREATED)
		    		            .header("info", "data saved success")
		    		            .body(saveall);
	}
	
	@GetMapping("/getAllHospitals")
	public ResponseEntity<List<HospitalModel>> getAllHospitals()
	{
		    List<HospitalModel> getall=hospitalService.getAllHospitals();
		    return ResponseEntity.status(HttpStatus.OK)
		    		       .header("info","data retrived success")
		    		       .body(getall);
	}
	@GetMapping("/searchById/{id}")
	public ResponseEntity<?> searchHospitalById(@PathVariable("id") long id)
	{
		       Optional<HospitalModel> hospital=hospitalService.searchHospitalById(id);
		       if(hospital.isPresent())
		       {
		    	   return ResponseEntity.status(HttpStatus.OK)
		    		       .header("info","data retrived success")
		    		       .body(hospital);
		       }
		       else
		       {
		    	   ApiResponse apiResponse=new ApiResponse();
		            apiResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
		            apiResponse.setMessege("not found with"+id);
		            apiResponse.setTimesstamp(LocalDateTime.now());
		            return ResponseEntity.status(HttpStatus.NOT_FOUND)
		            		     .header("info", "no data found")
		                           .body(apiResponse);

		       }
	}
	@GetMapping("/searchByName/{name}")
	public ResponseEntity<?> searchHospitalByname(@PathVariable("name") String name)
	{
		       Optional<HospitalModel> hospital=hospitalService.searchHospitalByName(name);
		       if(hospital.isPresent())
		       {
		    	   return ResponseEntity.status(HttpStatus.OK)
		    		       .header("info","data retrived success")
		    		       .body(hospital);
		       }
		       else
		       {
		    	   ApiResponse apiResponse=new ApiResponse();
		            apiResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
		            apiResponse.setMessege("not found with"+name);
		            apiResponse.setTimesstamp(LocalDateTime.now());
		            return ResponseEntity.status(HttpStatus.NOT_FOUND)
		            		     .header("info", "no data found")
		                           .body(apiResponse);

		       }
	}

	@GetMapping("/searchByLocation/{location}")
	public ResponseEntity<?> searchByLocation(@PathVariable("location") String location)
	{
		 Optional<HospitalModel> data=hospitalService.searchByLocation(location);
		 if(data.isPresent())
	       {
	    	   return ResponseEntity.status(HttpStatus.OK)
	    		       .header("info","data retrived success")
	    		       .body(data);
	       }
	       else
	       {
	    	   ApiResponse apiResponse=new ApiResponse();
	            apiResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
	            apiResponse.setMessege("not found with  "+location);
	            apiResponse.setTimesstamp(LocalDateTime.now());
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            		     .header("info", "no data found")
	                           .body(apiResponse);

	       }
	}
	@GetMapping("/getByRatingBetween/{minRating}/{maxRating}")
	public  ResponseEntity<List<HospitalModel>> getbyrating(@PathVariable("minRating") double minRating ,
                                                             @PathVariable("maxRating") double maxRating)
	{
		       List<HospitalModel> gethospitals=hospitalService.getbyrating(minRating,maxRating);
		       return ResponseEntity.status(HttpStatus.OK)
		    		   .header("info","data retrived success")
		    		   .body(gethospitals);
		    		            
	}
	
	
	
	
	@GetMapping("/getByGreaterthan-rating/{rating}")
	public  ResponseEntity<List<HospitalModel>>  getbygreterrating(@PathVariable("rating") double rating)
	{
		    List<HospitalModel> hospitals=hospitalService.getbygreterrating(rating);
		    return ResponseEntity.status(HttpStatus.OK)
		    		.header("info", "data retrived")
		    		.body(hospitals);
	}
	
	@GetMapping("/getByLessthan-rating/{rating}")
	public  ResponseEntity<List<HospitalModel>>  getbylesserrating(@PathVariable("rating") double rating)
	{
		    List<HospitalModel> hospitals=hospitalService.getbylesserrating(rating);
		    return ResponseEntity.status(HttpStatus.OK)
		    		.header("info", "data retrived")
		    		.body(hospitals);
	}
	 @GetMapping("/getByNameAndLocation/{name}/{location}")
	 public ResponseEntity<List<HospitalModel>> searchByNameAndLocation(@PathVariable("name") String name,
			                                                         @PathVariable("location") String location)
	 {
		     List<HospitalModel> hospitals= hospitalService.searchByNameAndLocation( name, location);
		     return ResponseEntity.status(HttpStatus.OK)
			    		.header("info", "data retrived sucessful")
			    		.body(hospitals);
	 }
	 
	 @GetMapping("/getByRatingBetweenAndLocation/{minRating}/{maxRating}/{location}")
	 public  ResponseEntity<List<HospitalModel>> getByLocationAndRating( @PathVariable double minRating,
	                                                                     @PathVariable double maxRating,
	                                                                     @PathVariable String location)
	 {
		 List<HospitalModel> hospitals= hospitalService.getByLocationAndRating(minRating,maxRating,location);
	     return ResponseEntity.status(HttpStatus.OK)
		    		.header("info", "data retrived sucessful")
		    		.body(hospitals);
	     
	 }

	 @GetMapping("/sortByRating")
	 public ResponseEntity<List<HospitalModel>> sortbyRating()
	 {
		     List<HospitalModel> hospitals= hospitalService.sortbyRating();
		     return ResponseEntity.status(HttpStatus.OK)
			    		.header("info", "data retrived sucessful")
			    		.body(hospitals);
	 }
	 
	@DeleteMapping("/deleteByRatingBetween/{minRating}/{maxRating}")
	public ResponseEntity<ApiResponse> deletebybyrating(@PathVariable("minRating") double minRating ,
			                                            @PathVariable("maxRating") double maxRating )
		{
		hospitalService.deletebybyrating(minRating,maxRating);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
				.header("info", "data deleted")
				.build();

		
	}
	
	
	
		 @DeleteMapping("/deleteById/{id}")
		 public ResponseEntity<ApiResponse> deleteEmployeeById(@PathVariable("id") long id)
			{
				 boolean status=hospitalService.deletebyid(id);
				 if(status)
				 {
					 return ResponseEntity.status(HttpStatus.NO_CONTENT)
							 .header("info","data deleted success")
							 .build();
				 }
				 else
			       {
			    	   ApiResponse apiResponse=new ApiResponse();
			            apiResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
			            apiResponse.setMessege("not found with  "+ id);
			            apiResponse.setTimesstamp(LocalDateTime.now());
			            return ResponseEntity.status(HttpStatus.NOT_FOUND)
			            		     .header("info", "no data found")
			                           .body(apiResponse);
			       }
			}
		 @DeleteMapping("/delete-by-Rating-GreaterThan/{rating}")
		 public ResponseEntity<ApiResponse> deletebyratingbeetween(@PathVariable("rating") double rating)
		 {
			  hospitalService.deleteByRatingGreterThan(rating);
			  return ResponseEntity.status(HttpStatus.NO_CONTENT)
						 .header("info","data deleted success")
						 .build();
			  
		 }
		 
		 
		 
		 @DeleteMapping("/deleteHospitalByname/{name}")
			public ResponseEntity<ApiResponse> deleteHospitalByname(@PathVariable("name") String name)
			{
				 boolean status=hospitalService.deleteHospitalByname(name);
				 if(status)
				 {
					 return ResponseEntity.status(HttpStatus.NO_CONTENT)
							 .header("info","data deleted success")
							 .build();
				 }
				 else
				 {
					 ApiResponse apiResponse=new ApiResponse();				
					 apiResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
					 apiResponse.setMessege("data not found with  "+name+" name");
					 apiResponse.setTimesstamp(LocalDateTime.now());
					 return ResponseEntity.status(HttpStatus.NOT_FOUND)
							 .header("info", "no data found")
		                     .body(apiResponse);			 
						
					}
				 }
		
		 @DeleteMapping("/deleteHospitalByemail/{email}")
			public ResponseEntity<ApiResponse> deleteHospitalByemail(@PathVariable("email") String email)
			{
				 boolean status=hospitalService.deleteHospitalByemail(email);
				 if(status)
				 {
					 return ResponseEntity.status(HttpStatus.NO_CONTENT)
							 .header("info","data deleted success")
							 .build();
				 }
				 else
				 {
					 ApiResponse apiResponse=new ApiResponse();				
					 apiResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
					 apiResponse.setMessege("data not found with  "+email+" email");
					 apiResponse.setTimesstamp(LocalDateTime.now());
					 return ResponseEntity.status(HttpStatus.NOT_FOUND)
							 .header("info", "no data found")
		                     .body(apiResponse);			 
						
					}
				 }
		
		 @DeleteMapping("/deleteByRatingAndLocation/{rating}/{location}")
		 public ResponseEntity<ApiResponse> deletebyratingandlocation(@PathVariable("rating") double rating,
				                                                    @PathVariable("location") String location)
		 {
			  hospitalService.deletebyratingandlocation(rating,location);
			  return ResponseEntity.status(HttpStatus.NO_CONTENT)
						 .header("info","data deleted success")
						 .build();
			  
		 }
		 
		 
		 @PutMapping("/upadateById/{id}")
			public ResponseEntity<?> updateHospitalbyid(@RequestBody HospitalModel newHospitalModel,@PathVariable("id") long id )
			 {
				      Optional<HospitalModel> updateemployee =hospitalService.updateHospitalbyid( newHospitalModel,id);
				       if(updateemployee!=null)
				       {
				    	   
				    	   return ResponseEntity.status(HttpStatus.OK)
							          .header("info", "data updated succesfully")
							          .body(updateemployee);
				       }
				       else
						 {
							 ApiResponse apiResponse=new ApiResponse();
							 apiResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
							 apiResponse.setMessege("data not found with"+id+"id");
							 apiResponse.setTimesstamp(LocalDateTime.now());
							 return ResponseEntity.status(HttpStatus.NOT_FOUND)
									 .header("info", "no data found")
				                     .body(apiResponse);			 
								
							}					         
			}

		 
		 @PatchMapping("/upadate-Partially-ById/{id}")
			public ResponseEntity<?> updatebyid(@PathVariable("id") long id,@RequestBody Map< String, Object> updates)
			{
		 		    HospitalModel updatedata =hospitalService.updatebyid(id,updates);
		 		    if(updatedata!=null)
		 		    {
		 		    	return ResponseEntity.status(HttpStatus.OK)
		 		    			.header("info", "data updated success")
		 		    			.body(updatedata);
		 		    	
		 		    }
		 		   
		 else
	       {
	    	   ApiResponse apiResponse=new ApiResponse();
	            apiResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
	            apiResponse.setMessege("not found with  "+ id);
	            apiResponse.setTimesstamp(LocalDateTime.now());
	            
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            		     .header("info", "no data found")
	                           .body(apiResponse);
	     }
			}
		 
		 
		 

		
		 @PatchMapping("/upadate-Partially-ByName/{name}")
			public ResponseEntity<?> updatebyid(@PathVariable("name") String name,@RequestBody Map< String, Object> updates)
			{
		 		    HospitalModel updatedata =hospitalService.updatebyname(name,updates);
		 		    if(updatedata!=null)
		 		    {
		 		    	return ResponseEntity.status(HttpStatus.OK)
		 		    			.header("info", "data updated sucessful")
		 		    			.body(updatedata);
		 		    	
		 		    }
		 		   
		 else
	       {
	    	   ApiResponse apiResponse=new ApiResponse();
	            apiResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
	            apiResponse.setMessege("not found with  "+ name);
	            apiResponse.setTimesstamp(LocalDateTime.now());
	            
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            		     .header("info", "no data found")
	                           .body(apiResponse);
	     }
			}
		 
		 
		
		 
		 
		 
}