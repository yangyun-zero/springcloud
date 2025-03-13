package com.yangyun.springcloud.service.impl;

import com.yangyun.springcloud.entities.Dept;
import com.yangyun.springcloud.mapper.DeptMapper;
import com.yangyun.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName DeptServiceImpl
 * @Description:
 * @Author yangyun
 * @Date 2019/9/3 0003 10:17
 * @Version 1.0
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
//        return deptMapper.findById(id);
        try {
            TimeUnit.MILLISECONDS.sleep(900);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Dept(new Random().nextLong(), "yy", "dslj");
    }

    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }
}
