package edu.autocar.JDBC;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {
	
	long sensorId;
	String sensorType;
	double value;
	Date regDate;
	String owner;
	String place;

}
