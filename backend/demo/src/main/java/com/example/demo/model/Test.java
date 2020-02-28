package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String testName;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="subject_id", nullable=false)
	@JsonBackReference
	private Subject subject1;
	
	@JsonManagedReference
	@OneToMany(mappedBy="test1",cascade=CascadeType.ALL)
	private Set<Questions> questions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Subject getSubject1() {
		return subject1;
	}

	public void setSubject1(Subject subject1) {
		this.subject1 = subject1;
	}

	public Set<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Questions question) {
		questions.add(question);
		question.setTest1(this);
	}
	
	public void removeQuestion(Questions question) {
		questions.remove(question);
		question.setTest1(null);
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", testName=" + testName + "]";
	}

	public Test(int id, String testName) {
		super();
		this.id = id;
		this.testName = testName;
	}
	
	
	public Test(int id, String testName, Subject subject1, Set<Questions> questions) {
		super();
		this.id = id;
		this.testName = testName;
		this.subject1 = subject1;
		this.questions = questions;
	}

	public Test()
	{
		
	}

}
