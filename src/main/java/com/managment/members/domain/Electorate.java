package com.managment.members.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="electorates")
@Entity
public class Electorate implements Serializable {

	private static final long serialVersionUID = -5979697825731420414L;
	private Integer id;	
	private String electorateName;
	private Integer districtId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	public Integer getId() {
	return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getElectorateName() {
		return electorateName;
	}

	public void setElectorateName(String electorateName) {
		this.electorateName = electorateName;
	}

	@Column(name = "dist_id")
	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	
	
	
	

}
