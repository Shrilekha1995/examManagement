package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

	/*@Query("Select t from Test t where id:=sid")
	List<Test> getAllTestsBySId(int sid);*/

}
