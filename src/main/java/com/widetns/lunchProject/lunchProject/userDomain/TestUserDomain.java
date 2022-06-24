package com.widetns.lunchProject.lunchProject.userDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="test_user")
public class TestUserDomain {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer userNum;

	@Id
	@Column(name="user_id")
	private String userId;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	@Column(name="user_Kakao")
	private String userKakao; 
	
	
	
	
}
