package edu.autocar.tourguide.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourGuide {
	private int num;
	private String name;
	private String region;
	private String city;
	private String content;
	private String address;
	private String homepage;
}
