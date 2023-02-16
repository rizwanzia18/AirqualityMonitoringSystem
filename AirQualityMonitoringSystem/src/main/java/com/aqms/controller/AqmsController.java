package com.aqms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aqms.exceptionhandling.FloorNotFoundException;
import com.aqms.model.AqmsEntity;
import com.aqms.repo.AirQualityRepository;

@RestController
@CrossOrigin
public class AqmsController {

	@Autowired
	private AirQualityRepository airqualityrespository;
	
	
	//Logging the data 
	private static final Logger log = LoggerFactory.getLogger(AqmsController.class);

	// to get all the sensor data
	@GetMapping("/floors")
	public ResponseEntity<List<AqmsEntity>> getAllData() {
		
		log.info("Inside the method of getting the all data");

		//try block to check the exception 
		try {
			List<AqmsEntity> sensorData = airqualityrespository.getAllData();
			log.info("Got the data from the repository");
			
			
			//Condition statement to check there is sensor data
			if (sensorData != null) {
				
				log.info("Data from the repo is not null");
				return ResponseEntity.status(HttpStatus.OK).body(sensorData);
			} else {
				log.info("There is no data in the repo");
				throw new FloorNotFoundException();
			}
		} 
		// catch block to handle the exception
		catch (FloorNotFoundException e) {
			log.info("Exception is handled");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}

	}

}
