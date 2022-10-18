package com.khomaytinh.quanlykhomaytinh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/thong-ke")
@Controller
public class ThongKeController extends Common{
    //Là trang đầu tiên trả về khi đăng nhập
    @GetMapping("")
    public ModelAndView thong_ke(){
        mv.setViewName("index");return mv;
    }
}
