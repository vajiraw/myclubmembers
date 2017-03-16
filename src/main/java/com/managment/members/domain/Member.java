package com.managment.members.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Table(name="Persons")
@Entity
public class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String fullName;
	private String address;
	private String mobileNo;
	private String contactNo;
	private String emailId;
	private String nicId;
	/*public String gs;
	public String division;
	public String electrorate;
	public String district;*/
	public byte [] image;	
	public String comments;	
	public String imageName;
	//private Integer rep_id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	public Integer getId() {
	return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "fullName")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}	
	

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "contactNumber")
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getNicId() {
		return nicId;
	}

	public void setNicId(String nicId) {
		this.nicId = nicId;
	}

	
	
	@Lob
	@Column(name="mem_image", nullable=false, columnDefinition="mem_image")	   
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	@Column(name = "image_name")
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "Member [fullName=" + fullName + ", address=" + address + ", mobileNo=" + mobileNo + ", contactNo="
				+ contactNo + ", emailId=" + emailId + ", nicId=" + nicId + ", comments=" + comments + ", imageName="
				+ imageName + "]";
	}
	
	

	
}
