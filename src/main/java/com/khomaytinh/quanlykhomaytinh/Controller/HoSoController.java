package com.khomaytinh.quanlykhomaytinh.Controller;

import com.khomaytinh.quanlykhomaytinh.Model.Accounts;
import com.khomaytinh.quanlykhomaytinh.Model.Admin;
import com.khomaytinh.quanlykhomaytinh.Model.ThuKho;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Objects;

@Controller
public class HoSoController extends Common{
    @GetMapping("/ho-so")
    public ModelAndView ho_so(HttpSession session,Principal principal){
        session.setAttribute("admin",perSon(principal));
        mv.setViewName("HoSo");
        return mv;
    }
    @PostMapping ("/ho-so")
    public ModelAndView update_thong_tin(ThuKho person, Principal principal, HttpSession session){
        mv.setViewName("HoSo");
        person.setTaiKhoan(new Accounts(principal.getName()));
        if(Objects.equals(loginService.CheckUserName(principal.getName()).getRole().getMaRL(), "ADMIN")){
            personService.updateAdmin(person);
            Admin admin = personService.showAdmin(principal.getName());
            admin.setTaiKhoan(loginService.CheckUserName(principal.getName()));
            session.setAttribute("admin",admin);
        }
        else{
            personService.updateThuKho(person);
            ThuKho thuKho = personService.showThuKho(principal.getName());
            thuKho.setTaiKhoan(loginService.CheckUserName(principal.getName()));
            session.setAttribute("admin",thuKho);
        }
        return mv;
    }
    @PostMapping("/update-password")
    public ModelAndView update_password( @RequestParam("passWord") String pw, @RequestParam("userName")String userName, @RequestParam("newPassWord") String newPass){
       String pass = loginService.CheckUserName(userName).getPassword();
        boolean ss = passwordEncoder.matches(pw,pass);
        if(ss){
            Accounts accounts = new Accounts();
            accounts.setPassword(passwordEncoder.encode(newPass));
            accounts.setUserName(userName);
            loginService.updateAccount(accounts);
            mv.setViewName("Fragments/1Vai :: #KetQuaDung");
        }else {
            mv.setViewName("Fragments/1Vai :: #KetQuaSai");
        }
        return mv;
    }
}
