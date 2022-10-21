package com.khomaytinh.quanlykhomaytinh.Controller;

import com.khomaytinh.quanlykhomaytinh.Model.PhieuXuatNhap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RequestMapping("/xuat-nhap")
@Controller
public class XuatNhapController extends Common{
    @GetMapping("/tao-phieu")
    public ModelAndView phieu(){
        mv.setViewName("XuatNhap/TaoDonXN");
        return mv;
    }
    @PostMapping("/chi-tiet-phieu")
    public ModelAndView tao_phieu(HttpSession httpSession, PhieuXuatNhap phieuXuatNhap, Principal principal){
        phieuXuatNhap.setAccounts(loginService.CheckUserName(principal.getName()));
        mv.setViewName("XuatNhap/Chitietdon");
        httpSession.setAttribute("phieu",phieuXuatNhap);
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
