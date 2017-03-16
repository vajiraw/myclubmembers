package com.managment.members.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="local_government")
@Entity
public class LocalGovernment implements Serializable{


	private static final long serialVersionUID = -4485071257921176478L;
	private Integer id;	
	private String name;
	private int dsId;
	
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
	
	@Column(name = "divi_sec_id")
	public int getDsId() {
		return dsId;
	}
	public void setDsId(int dsId) {
		this.dsId = dsId;
	}
	
	
	

}
