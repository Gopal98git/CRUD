package com.CrudApi.CRUDAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
private int id;
private String name;
private String college;
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", college=" + college + ", department=" + department + "]";
}
private String department;
@Id
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}

}
