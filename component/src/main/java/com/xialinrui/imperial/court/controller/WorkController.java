package com.xialinrui.imperial.court.controller;

import com.xialinrui.imperial.court.entity.Memorials;
import com.xialinrui.imperial.court.service.api.MemorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WorkController {

    @Autowired
    private MemorialService memorialService;

    @RequestMapping("/work/show/memorials/digest/list")
    public String showMemorialsDigestList(Model model) {
        //1.调用service方法调用数据
        List<Memorials> memorialsList = memorialService.getAllMemorialsDigest();
        //2.将查询到的数据存入请求域
        model.addAttribute("memorialsList", memorialsList);
        //3.渲染视图
        return "memorials-list";
    }

    @RequestMapping("/work/show/memorials/detail")
    public String showMemorialsDetail(@RequestParam("memorialsId") String memorialsId, Model model) {
        //2.查询Memorials对象
        Memorials memorials = memorialService.getMemorialsDetailById(memorialsId);
        Integer memorialsStatus = memorials.getMemorialsStatus();
        if (memorialsStatus == 0) {
            memorialService.upDateMemorialsStatusToRead(memorialsId);
        }
        memorials.setMemorialsStatus(1);
        //3.将Memorials对象存入请求域
        model.addAttribute("memorials", memorials);
        //4.解析渲染视图
        return "memorials-detail";
    }


    @RequestMapping("/work/feedback")
    public String feedback(@RequestParam("memorialsId") String memorialsId , @RequestParam("feedbackContent")String feedbackContent) {
        //执行更新
        memorialService.updateMemorialsFeedback(memorialsId, feedbackContent);
        //重定向
        return "redirect:/work/show/memorials/digest/list";
    }

}
