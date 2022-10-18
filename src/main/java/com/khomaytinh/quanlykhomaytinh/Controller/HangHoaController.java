package com.khomaytinh.quanlykhomaytinh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/hang-hoa")
@Controller
public class HangHoaController extends Common{
    @GetMapping("/laptop")
    public ModelAndView page_laptop(){
        mv.setViewName("PageHangHoa/Laptop");
        return mv;
    }
    @GetMapping("/ban-phim")
    public ModelAndView page_ban_phim(){
        mv.setViewName("PageHangHoa/BanPhim");
        return mv;
    }
    @GetMapping("/chuot")
    public ModelAndView page_chuot(){
        mv.setViewName("PageHangHoa/Chuot");
        return mv;
    }
    @GetMapping("/loa")
    public ModelAndView page_loa(){
        mv.setViewName("PageHangHoa/Loa");
        return mv;
    }
    @GetMapping("/man-hinh")
    public ModelAndView page_man_hinh(){
        mv.setViewName("PageHangHoa/ManHinh");
        return mv;
    }
    @GetMapping("/pc")
    public ModelAndView page_pc(){
        mv.setViewName("PageHangHoa/PC");
        return mv;
    }
    @GetMapping("/tai-nghe")
    public ModelAndView page_tai_nghe(){
        mv.setViewName("PageHangHoa/TaiNghe");
        return mv;
    }
}
