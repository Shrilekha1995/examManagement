package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Questions;
import com.example.demo.model.Test;
import com.example.demo.service.TestService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/test")
public class TestClassController {
	
	@Autowired
	TestService testService;
	
	
	/*@GetMapping("/all/{id}")
	public List<Test> getAllTests(@PathVariable int  id )
	{
		return testService.getAllTests(id);		
	}*/
	
	@GetMapping("/{tid}")
	public List<Questions> getAllQuestionsByTId(@PathVariable ("tid") int tid)
	{
		Test test=testService.getTestById(tid);
		
		System.out.println(new ArrayList<>(test.getQuestions()));
		return new ArrayList<>(test.getQuestions());
		
	}

}
