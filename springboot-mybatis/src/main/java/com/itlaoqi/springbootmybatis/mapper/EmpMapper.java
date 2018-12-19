package com.itlaoqi.springbootmybatis.mapper;

import java.util.List;
import java.util.Map;

import com.itlaoqi.springbootmybatis.entity.Emp;

public interface EmpMapper {
	
	Emp findById(Integer id);
	List<Map<String, String>> findEmps(Map<String, String> params);
	
	void creat(Emp emp);
	void update(Emp emp);
	void delete(Integer empno);
	
}
