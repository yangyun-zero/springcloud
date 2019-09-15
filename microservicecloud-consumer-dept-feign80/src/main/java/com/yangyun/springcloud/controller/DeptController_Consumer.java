package com.yangyun.springcloud.controller;

import com.yangyun.springcloud.entities.Dept;
import com.yangyun.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Consumer
{
	@Autowired
	private DeptClientService deptClientService;

	@GetMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return this.deptClientService.get(id);
	}

	@GetMapping(value = "/consumer/dept/list")
	public List<Dept> list()
	{
		return this.deptClientService.list();
	}

	@PostMapping(value = "/consumer/dept/add")
	public Object add(Dept dept)
	{
		return this.deptClientService.add(dept);
	}
}
