package com.khomaytinh.quanlykhomaytinh.Controller;

import com.khomaytinh.quanlykhomaytinh.Model.Laptop;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

@RequestMapping("/hang-hoa")
@Controller
public class HangHoaController extends Common{
    //Controller cho laptop
    @GetMapping("/laptop")
    public ModelAndView page_laptop(){
        mv.setViewName("PageHangHoa/Laptop");
        mv.addObject("laptop",new Laptop());
        mv.addObject("laptops",lapTopService.showList(6, 1));
        return mv;
    }
    @PostMapping("/laptop")
    public ModelAndView load_page_laptop(@RequestParam("xs") int xs){
        mv.setViewName("PageHangHoa/Laptop :: #listLaptop");
        mv.addObject("laptops",lapTopService.showList(6, xs));
        return mv;
    }
    @PostMapping("/show_more_laptop")
    public ModelAndView show_more_laptop(@RequestParam("xs") int xs,@RequestParam("limit") int limit){
        mv.setViewName("PageHangHoa/Laptop :: #listLaptop");
        mv.addObject("laptops",lapTopService.showList(limit+6, xs));
        return mv;
    }
    @GetMapping("/laptop-ct/{maHH}")
    public ModelAndView page_laptop_ct(@PathVariable("maHH") String maHH){
        mv.addObject("laptop",lapTopService.showDetail(maHH));
        mv.setViewName("ChiTietHangHoa/CTLap");
        return mv;
    }
    @GetMapping("/anh-laptop/{MaHH}")
    public void load_anh_laptop(@PathVariable("MaHH") String maHH, HttpServletResponse response) throws SQLException, IOException {
        response.setContentType("image/jpeg");

        Blob ph = lapTopService.showDetail(maHH).getHinhAnh();

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
    @PostMapping("/them-laptop")
    public ModelAndView them_laptop(Laptop laptop) throws IOException {
        lapTopService.insert(laptop);
        mv.setViewName("redirect:/hang-hoa/laptop");
        return mv;
    }
    @PostMapping("/sua-laptop")
    public ModelAndView sua_laptop(Laptop laptop) throws IOException {
        lapTopService.update(laptop);
        mv.setViewName("redirect:/hang-hoa/laptop");
        return mv;
    }
    @PostMapping("/xoa-lap")
    public ModelAndView xoa_Lap(@RequestParam("idLaptop")String idlap){
        lapTopService.delete(idlap);

        return mv;
    }
    @PostMapping("/show-laptop-on-modal")
    public ModelAndView show_laptop_on_modal(@RequestParam("maHH")String maHH){
        mv.setViewName("PageHangHoa/Laptop :: #modalSua");
        mv.addObject("laptop",lapTopService.showDetail(maHH));
        return mv;
    }
    @PostMapping("/check_id_laptop")
    public ModelAndView check_id_laptop(@RequestParam("idLaptop")String idlap){
        if(hangHoaService.check_id(idlap)==null){
            mv.setViewName("Fragments/1Vai :: #maHH1");
        }else{
            mv.setViewName("Fragments/1Vai :: #maHH");
        }
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
