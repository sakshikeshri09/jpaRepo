package com.cap;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Author {

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo="
				+ phoneNo + "]";
	}
	@Id
	@GeneratedValue
	private int authorId;
	private String firstName;
	private String lastName;
	private BigInteger phoneNo;
	
	public Author( String firstName, String lastName, BigInteger phoneNo) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
	}
	public Author() {
		super();
	}
		public int getAuthorId() {
			return authorId;
		// TODO Auto-generated constructor stub
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public BigInteger getPhoneNo() {
		return phoneNo;
	}
	
}
