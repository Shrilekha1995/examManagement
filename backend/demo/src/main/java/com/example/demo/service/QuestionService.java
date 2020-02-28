package com.example.demo.service;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import com.example.demo.model.Questions;

public interface QuestionService {

	void addQuestion(Questions question, int tid);

	List<Questions> getAllQuestions();

	void updateQuestion(Questions question);

	void deleteQuestion(int qid, int tid);

	

}
