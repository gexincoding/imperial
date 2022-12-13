package com.xialinrui.imperial.court.service.impl;

import com.xialinrui.imperial.court.entity.Emp;
import com.xialinrui.imperial.court.entity.EmpExample;
import com.xialinrui.imperial.court.mapper.EmpMapper;
import com.xialinrui.imperial.court.service.api.EmpService;
import com.xialinrui.imperial.court.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp getEmpByLogin(String loginAccount, String loginPassword) {
        String encodedLoginPassword = MD5Util.encode(loginPassword);
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria criteria = empExample.createCriteria();
        criteria.andLoginAccountEqualTo(loginAccount).andLoginPasswordEqualTo(encodedLoginPassword);
        List<Emp> empList = empMapper.selectByExample(empExample);
        if (empList != null && empList.size() > 0) {
            return empList.get(0);
        }
        return null;
    }
}
