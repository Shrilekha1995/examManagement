package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Subject;
import com.example.demo.model.Test;
import com.example.demo.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectRepository subRepository;
	@Override
	public List<Subject> getAllSubjects() {
		return subRepository.findAll();
	}

	@Override
	public void addSubject(Subject subject) {
		 subRepository.save(subject);
		
	}

	@Override
	public void deleteSubject(int id) {
		subRepository.deleteById(id);
		
	}

	@Override
	public Subject getSubjectById(int id) {
	
		return subRepository.findById(id).orElse(null) ;
	}

	/*@Override
	public List<Test> getTestsBySId(sid) {
		
		return subRepository.findAllById(sid);
	}*/

}
