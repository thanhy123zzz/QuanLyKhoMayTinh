package com.khomaytinh.quanlykhomaytinh.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/hang-hoa")
@Controller
public class HangHoaController extends Common{
    //Controller cho laptop
    @GetMapping("/laptop")
    public ModelAndView page_laptop(){
        mv.setViewName("PageHangHoa/Laptop");
        return mv;
    }
    @GetMapping("/laptop-ct")
    public ModelAndView page_laptop_ct(){
        mv.setViewName("ChiTietHangHoa/CTLap");
        return mv;
    }
    // end-controller cho laptop

    /**/

    //Controller cho bàn phím
    @GetMapping("/ban-phim")
    public ModelAndView page_ban_phim(){
        mv.setViewName("PageHangHoa/BanPhim");
        return mv;
    }
    @GetMapping("/ban-phim-ct")
    public ModelAndView page_ban_phim_ct(){
        mv.setViewName("ChiTietHangHoa/CTBanphim");
        return mv;
    }
    //end- controller bàn phím

    /**/

    //Controller cho chuột
    @GetMapping("/chuot")
    public ModelAndView page_chuot(){
        mv.setViewName("PageHangHoa/Chuot");
        return mv;
    }
    @GetMapping("/chuot-ct")
    public ModelAndView page_chuot_ct(){
        mv.setViewName("ChiTietHangHoa/CTChuot");
        return mv;
    }
    //end- controller chuột

    /**/

    //controller cho loa
    @GetMapping("/loa")
    public ModelAndView page_loa(){
        mv.setViewName("PageHangHoa/Loa");
        return mv;
    }
    @GetMapping("/loa-ct")
    public ModelAndView page_loa_ct(){
        mv.setViewName("ChiTietHangHoa/CTLoa");
        return mv;
    }
    //end- controller loa

    /**/

    //controller cho màn hình
    @GetMapping("/man-hinh")
    public ModelAndView page_man_hinh(){
        mv.setViewName("PageHangHoa/ManHinh");
        return mv;
    }
    @GetMapping("/man-hinh-ct")
    public ModelAndView page_man_hinh_ct(){
        mv.setViewName("ChiTietHangHoa/CTManHinh");
        return mv;
    }
    //end controller man hinh

    /**/

    //controller pc
    @GetMapping("/pc")
    public ModelAndView page_pc(){
        mv.setViewName("PageHangHoa/PC");
        return mv;
    }
    @GetMapping("/pc-ct")
    public ModelAndView page_pc_ct(){
        mv.setViewName("ChiTietHangHoa/CTPC");
        return mv;
    }
    //end controller pc

    /**/

    //controller tai nghe
    @GetMapping("/tai-nghe")
    public ModelAndView page_tai_nghe(){
        mv.setViewName("PageHangHoa/TaiNghe");
        return mv;
    }
    @GetMapping("/tai-nghe-ct")
    public ModelAndView page_tai_nghe_ct(){
        mv.setViewName("ChiTietHangHoa/CTTainghe");
        return mv;
    }
    //end controller tai nghe
}
