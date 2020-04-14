package com.capg.myapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dc_details")
public class DaignosticCenter {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="center_name")
	private String center;
	@Column(name="test")
	private String test;


	public DaignosticCenter( String center, String test) {
		super();
	
		this.center = center;
		this.test = test;
	}
	@Override
	public String toString() {
		return "DaignosticCenter [id=" + id + ", center=" + center + ", test=" + test + "]";
	}
	public DaignosticCenter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	
}
