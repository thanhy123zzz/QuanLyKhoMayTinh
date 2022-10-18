package com.khomaytinh.quanlykhomaytinh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HoSoController extends Common{
    @GetMapping("/ho-so")
    public ModelAndView ho_so(){
        mv.setViewName("HoSo");
        return mv;
    }
}
