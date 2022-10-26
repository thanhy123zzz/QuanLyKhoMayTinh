package com.khomaytinh.quanlykhomaytinh.Controller;

import com.khomaytinh.quanlykhomaytinh.Model.Accounts;
import com.khomaytinh.quanlykhomaytinh.Model.Admin;
import com.khomaytinh.quanlykhomaytinh.Model.ThuKho;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Objects;

@RequestMapping("/thong-ke")
@Controller
public class ThongKeController extends Common{
    //Là trang đầu tiên trả về khi đăng nhập
    @GetMapping("")
    public ModelAndView thong_ke(HttpSession session, Principal principal){
        session.setAttribute("admin",perSon(principal));
        mv.setViewName("index");
        mv.addObject("thongKe",thongKeService.showNgay());
        return mv;
    }
    @PostMapping("/change-thong-ke")
    public ModelAndView change_thong_ke(@RequestParam("key")int key) {
        mv.setViewName("index :: #thongKeTable");
        if (key == 1) {
            mv.addObject("thongKe", thongKeService.showNgay());
        }
        else {
            mv.addObject("thongKe",thongKeService.showThang());
        }
        return mv;
    }
}
