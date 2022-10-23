package com.khomaytinh.quanlykhomaytinh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/xuat-nhap")
@Controller
public class XuatNhapController extends Common{
    @GetMapping("/tao-phieu")
    public ModelAndView tao_phieu(){
        mv.setViewName("XuatNhap/TaoDonXN");
        return mv;
    }
    @GetMapping("/lich-su-nhap")
    public ModelAndView lich_su_nhap(){
        mv.setViewName("XuatNhap/Lichsunhapkho");
        return mv;
    }
    @GetMapping("/lich-su-xuat")
    public ModelAndView lic_su_xuat(){
        mv.setViewName("XuatNhap/Lichsuxuatkho");
        return mv;
    }
}
