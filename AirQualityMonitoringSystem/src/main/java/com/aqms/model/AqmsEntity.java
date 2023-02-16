package com.aqms.model;


/*
 * This class will fetch the data from the Dynamodb mapping
 * Entity class
 */

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


import lombok.Data;

@Data
@DynamoDBTable(tableName = "sensor_data")
public class AqmsEntity {
	
	
	@DynamoDBHashKey
	private String timeStamp;

	@DynamoDBAttribute(attributeName = "floor_no")
	private String floor_no;

	@DynamoDBAttribute(attributeName = "NH3")
	private int nh3_level;

	@DynamoDBAttribute(attributeName = "co2")
	private int co2_level;

	@DynamoDBAttribute(attributeName = "so2")
	private int so2_level;

	@DynamoDBAttribute(attributeName = "co")
	private float co_level;

	@DynamoDBAttribute(attributeName = "Sensor_status")
	private String sensor_status;
	
	// Constructor
	public AqmsEntity() {

	}

	public AqmsEntity(String timeStamp, String floor_no, int nh3_level, int co2_level, int so2_level, float co_level,
			String sensor_status) {

		this.timeStamp = timeStamp;
		this.floor_no = floor_no;
		this.nh3_level = nh3_level;
		this.co2_level = co2_level;
		this.so2_level = so2_level;
		this.co_level = co_level;
		this.sensor_status = sensor_status;
	}
	

	// Getters
	public String getFloor_no() {
		return floor_no;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setFloor_no(String floor_no) {
		this.floor_no = floor_no;
	}

	public int getNh3_level() {
		return nh3_level;
	}

	public void setNh3_level(int nh3_level) {
		this.nh3_level = nh3_level;
	}

	public int getCo2_level() {
		return co2_level;
	}

	public void setCo2_level(int co2_level) {
		this.co2_level = co2_level;
	}

	public int getSo2_level() {
		return so2_level;
	}

	public void setSo2_level(int so2_level) {
		this.so2_level = so2_level;
	}

	public float getCo_level() {
		return co_level;
	}

	public void setCo_level(float co_level) {
		this.co_level = co_level;
	}

	public String getSensor_status() {
		return sensor_status;
	}

	public void setSensor_status(String sensor_status) {
		this.sensor_status = sensor_status;
	}

}
