package com.itlaoqi.springbootmybatis.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itlaoqi.springbootmybatis.entity.Emp;
import com.itlaoqi.springbootmybatis.mapper.EmpMapper;

@Controller
public class EmpController {

	@Resource
	private EmpMapper empMapper = null;

	@RequestMapping(value = "/{id}")
	@ResponseBody
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Emp findById(@PathVariable("id") Integer id) {
		return empMapper.findById(id);
	}

	@RequestMapping(value = "/find")
	@ResponseBody
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Map<String, String>> findEmps(String dname, Float sal) {
		Map params = new HashMap<>();
		params.put("pdname", dname);
		params.put("psal", sal);
		return empMapper.findEmps(params);
	}

	@RequestMapping(value = "/create")
	@Transactional(rollbackFor = Exception.class)
	public void create() {
		Emp emp = new Emp();
		emp.setComm(0f);
		emp.setDeptno(30);
		emp.setEname("laoqi");
		emp.setHiredate(new Date());
		emp.setJob("SEARCHER");
		emp.setMgr(null);
		emp.setSal(3000f);
		empMapper.creat(emp);
	}

	@RequestMapping(value = "/update")
	@Transactional(rollbackFor = Exception.class)
	public void update() {
		Emp emp = empMapper.findById(7788);
		emp.setSal(emp.getSal() * 2);
		empMapper.update(emp);
	}

	@RequestMapping(value = "/delete")
	@Transactional(rollbackFor = Exception.class)
	public void delete() {
		empMapper.delete(7369);
	}
}
