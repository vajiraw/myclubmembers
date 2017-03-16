package com.managment.members.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="gramasewa_wasama")
public class GramaSewaWasam implements Serializable {
	
	private static final long serialVersionUID = -4485071257921176478L;
	private Integer id;	
	private String name;
	private int localGovId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "local_gov_id")
	public int getLocalGovId() {
		return localGovId;
	}
	public void setLocalGovId(int localGovId) {
		this.localGovId = localGovId;
	}
	
	

}
