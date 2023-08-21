package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	
	@NamedQuery(name = "getAll",query = "from Student"),
	@NamedQuery(name = "getSingle",query = "from Student where rollno = :rn"),
	@NamedQuery(name = "deleteStudent",query = "delete from Student where rollno = :rn"),
	@NamedQuery(name = "updateName",query = "update Student set name = :nm where rollno = :rn")

})

public class Student {

	@Id
	private int rollno;
	private String name;
	private double marks;
	private String address;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + ", address=" + address + "]";
	}
	
	
	
}
