package com.khomaytinh.quanlykhomaytinh.Controller;

import com.khomaytinh.quanlykhomaytinh.Model.Accounts;
import com.khomaytinh.quanlykhomaytinh.Model.Admin;
import com.khomaytinh.quanlykhomaytinh.Model.ThuKho;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Objects;

@RequestMapping("/thong-ke")
@Controller
public class ThongKeController extends Common{
    //Là trang đầu tiên trả về khi đăng nhập
    @GetMapping("")
    public ModelAndView thong_ke(HttpSession session, Principal principal){
        session.setAttribute("admin",perSon(principal));
        mv.setViewName("index");
        return mv;
    }
}
