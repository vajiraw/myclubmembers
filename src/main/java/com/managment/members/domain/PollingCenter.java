package com.managment.members.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="polling_center")
@Entity
public class PollingCenter implements Serializable {

	private static final long serialVersionUID = 2660412387283979666L;
	private Integer id;	
	private String pollingCenterName;
	private Integer gramasewaId;
	
	
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
	public String getPollingCenterName() {
		return pollingCenterName;
	}

	public void setPollingCenterName(String pollingCenterName) {
		this.pollingCenterName = pollingCenterName;
	}

	@Column(name = "grama_sewa_id")
	public Integer getGramasewaId() {
		return gramasewaId;
	}

	public void setGramasewaId(Integer gramasewaId) {
		this.gramasewaId = gramasewaId;
	}
	
	

}
