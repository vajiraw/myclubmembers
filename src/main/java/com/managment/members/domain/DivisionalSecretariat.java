package com.managment.members.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="divisional_secretariat")
@Entity
public class DivisionalSecretariat implements Serializable {

	private static final long serialVersionUID = -2692238779143294609L;
	private Integer id;	
	private String name;
	private int electorateId;
	
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
	@Column(name = "electorate_id")
	public int getElectorateId() {
		return electorateId;
	}
	public void setElectorateId(int electorateId) {
		this.electorateId = electorateId;
	}
	
	
}
