package edu.autocar.iotmonitor.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
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
