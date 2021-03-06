package com.hostbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor

@NoArgsConstructor
public class User {

	@Id
	@NonNull
	@GeneratedValue
	private Integer id;
	private String userSalutation;
	private String userFirstName;
	private String userLastName;

	private String userGender;
	private Long userMobile;
	private String userEmail;
	private String userAddress;
	private String userRole;
	private String userStatus;

	
}
