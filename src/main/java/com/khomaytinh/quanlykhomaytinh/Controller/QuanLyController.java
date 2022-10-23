package com.khomaytinh.quanlykhomaytinh.Controller;

import java.io.IOException;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.khomaytinh.quanlykhomaytinh.Model.Laptop;
import com.khomaytinh.quanlykhomaytinh.Model.ThuKho;

@Controller
public class QuanLyController extends Common{
    //hiện ra giao diện quản lý
	@GetMapping("/quan-ly")
    public ModelAndView page_quan_ly(){
        mv.setViewName("QuanlyNV");
        mv.addObject("thukho",new ThuKho());
        mv.addObject("thukhos",personService.showListThuKho());
        return mv;
    }
    
	@GetMapping("/trang-them-tk")
    public ModelAndView page_them_tk(){
        mv.addObject("thukho",new ThuKho());
        mv.setViewName("ThemTK");
        return mv;
    }
	@GetMapping("/thu-kho-ct/{maTK}")
    public ModelAndView page_thu_kho_ct(@PathVariable("maTK") String matk){
        mv.addObject("thukho",personService.showThuKho1(matk));
        mv.setViewName("SuaTk");
        return mv;
    }
    @PostMapping("/them-tk")
    public ModelAndView them_tk(@ModelAttribute ThuKho thukho,@RequestParam("matKhau")String maKhau) {
        thukho.getTaiKhoan().setPassword(passwordEncoder.encode(maKhau));
        personService.insertThuKho(thukho);
        mv.setViewName("redirect:/quan-ly");
        return mv;
    }
    @PostMapping("/xoa-thu-kho")
    public ModelAndView xoa_thu_kho(@RequestParam("maTK")String idtk){
        personService.deleteThuKho(idtk);
        return mv;
    }
    @PostMapping("/check_id_thu_kho")
    public ModelAndView check_id_thu_kho(@RequestParam("maTK")String idtk){
        if(personService.check_id(idtk)==null){
            mv.setViewName("Fragments/1Vai :: #maHH1");
        }else{
            mv.setViewName("Fragments/1Vai :: #maHH");
        }
        return mv;
    }
    @PostMapping("/sua-thu-kho")
    public ModelAndView sua_thu_kho(ThuKho thukho) {
        personService.updateThuKho1(thukho);
        mv.setViewName("redirect:/quan-ly");
        return mv;
    }
}
