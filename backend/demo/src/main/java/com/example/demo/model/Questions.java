package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questionNo;
	
	
	private String question;
	
	
	@Column(name="OptionA")
	private String optA;
	
	@Column(name="OptionB")
	private String optB;
	
	@Column(name="OptionC")
	private String optC;
	
	@Column(name="OptionD")
	private String optD;
	
	@Column(name="RightAnswer")
	private String ans;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="test_id", nullable=false)
	@JsonBackReference
	private Test test1;

	public Integer getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptA() {
		return optA;
	}

	public void setOptA(String optA) {
		this.optA = optA;
	}

	
	public String getOptB() {
		return optB;
	}

	public void setOptB(String optB) {
		this.optB = optB;
	}
	public String getOptC() {
		return optC;
	}

	public void setOptC(String optC) {
		this.optC = optC;
	}


	public String getOptD() {
		return optD;
	}

	public void setOptD(String optD) {
		this.optD = optD;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	
	public Test getTest1() {
		return test1;
	}

	public void setTest1(Test test1) {
		this.test1 = test1;
	}

	public Questions(Integer questionNo, String question, String optA, String optB, String optD, String ans) {
		super();
		this.questionNo = questionNo;
		this.question = question;
		this.optA = optA;
		this.optB = optB;
		this.optD = optD;
		this.ans = ans;
	}
	public Questions()
	{
		
	}

	@Override
	public String toString() {
		return "Questions [questionNo=" + questionNo + ", question=" + question + ", optA=" + optA + ", optB=" + optB
				+ ", optD=" + optD + ", ans=" + ans + "]";
	}
	
	
	
	
	

}
