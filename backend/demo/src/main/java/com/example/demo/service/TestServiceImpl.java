package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Test;
import com.example.demo.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService {

	
	@Autowired
	TestRepository testRepository;

	@Override
	public Test getTestById(int tid) {
		return testRepository.findById(tid).orElse(null);
	}

/*	@Override
	public List<Test> getAllTests(int sid) {
		
		return testRepository.getAllTestsBySId(sid);
	}
	*/
	
	
	
}
