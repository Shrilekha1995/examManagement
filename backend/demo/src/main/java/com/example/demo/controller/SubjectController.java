package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Subject;
import com.example.demo.model.Test;
import com.example.demo.service.SubjectService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("subject")
public class SubjectController {
	
	
	@Autowired
	SubjectService subjectService;
	
	@GetMapping("/all")
	public List<Subject> getAllSubjects()
	{
		return subjectService.getAllSubjects();		
	}
	
       @GetMapping("/{sid}")
	public List<Test> getTestsBySId(@PathVariable ("sid")int id )
	{
	
		Subject subject=subjectService.getSubjectById(id);
		return new ArrayList<>(subject.getTests());
	}
	
	@PostMapping("/add")
	public void addSubject(@RequestBody Subject subject)
	{
		subjectService.addSubject(subject);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSubject(@PathVariable("id") int id1)
	{
		subjectService.deleteSubject(id1);
	}
	
//	@PUTMapping("/update")
//	public void updateSubject

}
