package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Subject;
import com.example.demo.model.Test;


public interface SubjectService {

	List<Subject> getAllSubjects();

	void addSubject(Subject subject);

	void deleteSubject(int id);

	Subject getSubjectById(int id);

	//List<Test> getTestsBySId();

}
