package com.bit.sts23.boot03.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.sts23.boot03.mapper.DeptMapper;
import com.bit.sts23.boot03.mapper.domain.Dept;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@Service
public class RestServiceImpl {
	
	@Autowired
	HttpServletResponse res;
	
	private static DeptMapper deptMapper;
	
	public RestServiceImpl(DeptMapper deptMapper){
		this.deptMapper=deptMapper;
	}
	
	public List<Dept> selectAll() {
		System.out.println(res);
		return deptMapper.findAll();
	}
	
	public Dept selectOne(int idx) {
		return deptMapper.findOne(idx);
	}
	
	public int insertOne(Dept bean) {
		return deptMapper.insertOne(bean);
	}
	
	public int updateOne(Dept bean) {
		return deptMapper.updateOne(bean);
	}
	
	public int deleteOne(int idx) {
		return deptMapper.deleteOne(idx);
	}
}
