package com.example.demo.controller;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Questions;
import com.example.demo.service.QuestionService;

@RestController
@CrossOrigin("http://localhost:4200")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	
	@PostMapping("/addQuestion/{tid}")
	public void addQuestion(@RequestBody Questions question,@PathVariable ("tid") int tid )
	{ System.out.println("in add question tid    ="+tid);
		questionService.addQuestion(question,tid);
	}
	
	
	@GetMapping("/allQuestions")
	public List<Questions> getAllQuestions(){
		
		return questionService.getAllQuestions();
	}
	
	@PutMapping("/updateQuestion")
	public void updateQuestion(@RequestBody Questions question)
	{
		
		questionService.updateQuestion(question);
		
	}
	
	@DeleteMapping("/deleteQuestion/{qid}/{tid}")
	public String deleteQuestion(@PathVariable ("qid") int qid,@PathVariable ("tid") int tid )
	{
		
		System.out.println("in delete question");
		questionService.deleteQuestion(qid,tid);
		return "question deleted successfully";
	}
	
	

}
