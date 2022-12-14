package com.khomaytinh.quanlykhomaytinh.Controller;

import com.khomaytinh.quanlykhomaytinh.Model.Accounts;



import com.khomaytinh.quanlykhomaytinh.Model.Admin;
import com.khomaytinh.quanlykhomaytinh.Model.ThuKho;
import com.khomaytinh.quanlykhomaytinh.Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Objects;

public class Common {
    ModelAndView mv = new ModelAndView();
    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    LapTopService hangHoaService;


    @Autowired
    PersonService personService;

    @Autowired
    LoginService loginService;

    @Autowired
    LapTopService lapTopService;
    @Autowired
    XuatNhapServiec xuatNhapServiec;
    
    @Autowired
    BanPhimService BanPhimService;
    
    @Autowired
    ChuotService ChuotService;
    @Autowired
    LoaService LoaService;
    @Autowired
    ManHinhService ManHinhService;
    @Autowired
    PcService PcService;
    @Autowired
    TaiNgheService TaiNgheService;
    @Autowired
    ThongKeService thongKeService;
    Admin perSon(Principal principal){
        if(Objects.equals(loginService.CheckUserName(principal.getName()).getRole().getMaRL(), "ADMIN")){
            Admin admin = personService.showAdmin(principal.getName());
            admin.setTaiKhoan(loginService.CheckUserName(principal.getName()));
            return admin;
        }else{
            ThuKho thuKho = personService.showThuKho(principal.getName());
            thuKho.setTaiKhoan(loginService.CheckUserName(principal.getName()));
            return thuKho;
        }
    }

}
