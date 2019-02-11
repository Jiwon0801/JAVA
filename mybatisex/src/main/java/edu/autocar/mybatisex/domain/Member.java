package edu.autocar.mybatisex.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
	private String userId;
	private String password;
	private String salt;
	private String name;
	private String email;
	private String phone;
	private String address;
	private Date regDate;
	private Date updateDate;

}