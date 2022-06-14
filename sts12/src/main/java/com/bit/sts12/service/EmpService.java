package com.bit.sts12.service;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts12.domain.Emp;
import com.bit.sts12.repository.EmpRepo;

@Service
public class EmpService {
	@Autowired
	EmpRepo empRepo;
//	SqlSessionTemplate sqlSessionTemplate; 
	
	public void seleteAll(Model model) {
//		EmpRepo empRepo = sqlSessionTemplate.getMapper(EmpRepo.class);
		model.addAttribute("list", empRepo.findAll());
		
	}
	public void selectOne(Model model,int idx) {
//		EmpRepo empRepo = sqlSessionTemplate.getMapper(EmpRepo.class);
		model.addAttribute("bean",empRepo.findOne(idx));
	}
	public void insert(Emp bean) {
//		EmpRepo empRepo = sqlSessionTemplate.getMapper(EmpRepo.class);
		empRepo.insertOne(bean);
	}
	public void update(Emp bean) {
//		EmpRepo empRepo = sqlSessionTemplate.getMapper(EmpRepo.class);
		empRepo.updateOne(bean);
	}
	public void delete(int idx) {
//		EmpRepo empRepo = sqlSessionTemplate.getMapper(EmpRepo.class);
		empRepo.deleteOne(idx);
	}
	
		
}
