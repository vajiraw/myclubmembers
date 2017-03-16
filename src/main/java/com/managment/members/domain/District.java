package com.managment.members.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="districts")
@Entity
public class District implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -252005711378175434L;
	private Integer id;	
	private String districtName;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	public Integer getId() {
	return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "district_name")
	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", districtName=" + districtName + "]";
	}

	
	
}
