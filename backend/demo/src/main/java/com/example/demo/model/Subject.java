package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Subject {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	@Column(name="subject_name")
	private String subName;
	
	@JsonManagedReference
	@OneToMany(mappedBy="subject1",cascade=CascadeType.ALL)
	private Set<Test> tests;

	
	public Subject(int id, String subName, Set<Test> tests) {
		super();
		this.id = id;
		this.subName = subName;
		this.tests = tests;
	}

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public void addTest(Test test) {
		tests.add(test);
		test.setSubject1(this);
	}
	
	public void removeTest(Test test) {
		tests.remove(test);
		test.setSubject1(null);
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", subName=" + subName + "]";
	}

	public Subject(int id, String subName) {
		super();
		this.id = id;
		this.subName = subName;
	}
	public Subject()
	{
		
	}
}
