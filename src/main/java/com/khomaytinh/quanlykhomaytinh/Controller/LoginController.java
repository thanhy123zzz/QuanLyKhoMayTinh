package com.khomaytinh.quanlykhomaytinh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends Common{
    @GetMapping("/")
    public ModelAndView hien_thi_login(){
        mv.setViewName("pages-login");
        return mv;
    }
}
