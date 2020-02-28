package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Questions;
import com.example.demo.model.Test;
import com.example.demo.repository.QuestionDao;
import com.example.demo.repository.TestRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	TestRepository testRepository;

	@Override
	public void addQuestion(Questions question,int tid) {
		
		Test t=testRepository.findById(tid).orElse(null);
		t.addQuestion(question);
		questionDao.save(question);
		
	}

	@Override
	public List<Questions> getAllQuestions() {
		return questionDao.findAll();
	
	}

	@Override
	public void updateQuestion(Questions question) {
		
		Questions q=questionDao.findById(question.getQuestionNo()).orElse(null);
		//q.setQuestion(question.getQuestion());
		question.setTest1(q.getTest1());
		questionDao.save(question);
		
		
		
	}

	@Override
	public void deleteQuestion(int qid, int tid) {
		Test t=testRepository.findById(tid).orElse(null);
		t.removeQuestion(questionDao.findById(qid).orElse(null));
		questionDao.deleteById(qid);
	}

}
