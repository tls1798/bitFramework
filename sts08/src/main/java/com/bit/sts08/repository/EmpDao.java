package com.bit.sts08.repository;

import java.util.*;

import com.bit.sts08.domain.Emp;

public interface EmpDao {

	List<Emp> findAll();
	Emp findOne(int idx);
}
