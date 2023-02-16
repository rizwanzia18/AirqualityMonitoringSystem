package com.aqms.repo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.aqms.model.AqmsEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirQualityRepository {

	// Logging the data
	private static final Logger log = LoggerFactory.getLogger(AirQualityRepository.class);

	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	// method to save the data to Dynamodb
	public AqmsEntity save(AqmsEntity aqmsEntity) {
		log.info("Saving the Data from DynamoDB");
		dynamoDBMapper.save(aqmsEntity);
		return aqmsEntity;
	}

	// method to get data as list from Dynamodb
	public List<AqmsEntity> getAllData() {
		log.info("Repository method fetching from Dynamodb");
		return dynamoDBMapper.scan(AqmsEntity.class, new DynamoDBScanExpression());
	}

}