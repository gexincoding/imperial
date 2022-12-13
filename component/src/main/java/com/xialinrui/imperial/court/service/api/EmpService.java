package com.xialinrui.imperial.court.service.api;

import com.xialinrui.imperial.court.entity.Emp;

public interface EmpService {
    Emp getEmpByLogin(String loginAccount, String loginPassword);
}
