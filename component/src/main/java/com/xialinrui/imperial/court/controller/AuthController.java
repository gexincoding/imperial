package com.xialinrui.imperial.court.controller;

import com.xialinrui.imperial.court.entity.Emp;
import com.xialinrui.imperial.court.service.api.EmpService;
import com.xialinrui.imperial.court.util.ImperialCourtConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller

public class AuthController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/auth/login")
    public String doLogin(@RequestParam("loginAccount") String loginAccount, @RequestParam("loginPassword") String loginPassword, HttpSession session, Model model) {
        Emp emp = empService.getEmpByLogin(loginAccount, loginPassword);
        if (emp == null) {
            model.addAttribute("message", ImperialCourtConst.LOGIN_FAILED_MESSAGE);
            return "index";
        } else {
            session.setAttribute("loginInfo", emp);
            return "redirect:/work/show/memorials/digest/list";
        }
    }

    @RequestMapping("/auth/logout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "index";
    }


}
