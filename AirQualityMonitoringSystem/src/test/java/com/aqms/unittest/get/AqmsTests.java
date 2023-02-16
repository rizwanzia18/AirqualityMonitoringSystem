package com.aqms.unittest.get;


/*
 * Unit Testing the API
 */

import org.junit.jupiter.api.Order;


import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.aqms.controller.AqmsController;
import com.aqms.model.AqmsEntity;
import com.aqms.repo.AirQualityRepository;

@SpringBootTest(classes = { AqmsTests.class })
public class AqmsTests {

	// Logging the data
	private static final Logger log = LoggerFactory.getLogger(AqmsTests.class);

	@Mock
	AirQualityRepository airqualityrepo;

	@InjectMocks
	AqmsController aqmscontroller;

	public List<AqmsEntity> sensordata;

	@Test
	@Order(1)
	public void test_getAllData() {

		log.info("Inside the first test method to check all data displayed");

		// List of mocked data
		List<AqmsEntity> sensordatamock = new ArrayList<AqmsEntity>();
		sensordatamock.add(new AqmsEntity("3/2/2023, 8:33:47 pm", "3", 17, 30, 4, 4, "OFF"));
		sensordatamock.add(new AqmsEntity("3/2/2023, 8:43:47 pm", "4", 15, 23, 2, 2, "ON"));

		// Mocking the Data
		when(airqualityrepo.getAllData()).thenReturn(sensordatamock);

		ResponseEntity<List<AqmsEntity>> sensorData = aqmscontroller.getAllData();

		// Comparing the data with mocked data using assertion
		assertEquals(sensordatamock, sensorData.getBody());

	}

	@Test
	@Order(2)
	public void test_nullData() {

		log.info("Inside the Second test method to check null data handled");

		// Mocking the Data as null
		when(airqualityrepo.getAllData()).thenReturn(null);

		ResponseEntity<List<AqmsEntity>> nullData = aqmscontroller.getAllData();

		// Checking the status code using null when there is null data
		assertEquals(null, nullData.getBody());

	}

}
