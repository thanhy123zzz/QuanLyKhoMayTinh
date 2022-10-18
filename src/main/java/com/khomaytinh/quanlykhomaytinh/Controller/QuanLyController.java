package com.khomaytinh.quanlykhomaytinh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuanLyController extends Common{
    //hiện ra giao diện quản lý
    @GetMapping("/quan-ly")
    public ModelAndView quan_ly(){
        mv.setViewName("QuanlyNV");
        return mv;
    }
}
