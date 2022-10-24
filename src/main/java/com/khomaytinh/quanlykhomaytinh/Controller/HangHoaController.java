package com.khomaytinh.quanlykhomaytinh.Controller;

import com.khomaytinh.quanlykhomaytinh.Model.*;

import com.khomaytinh.quanlykhomaytinh.Model.Mapper.HangHoaMapper;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
import java.util.List;
import java.util.Objects;

@RequestMapping("/hang-hoa")
@Controller
public class HangHoaController extends Common{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @PostMapping("/tim-kiem")
    public ModelAndView tim_kiem(@RequestParam("key")String key){
        List<HangHoa> list;
        String query = "select*from hanghoa where concat_ws(' ',MAHH,Ten,HangSX,Gia) like '%"+key+"%'";
        list = jdbcTemplate.query(query,new HangHoaMapper());
        mv.addObject("hangHoas",list);
        mv.setViewName("Timkiem");
        return mv;
    }

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
        mv.addObject("banphim",new BanPhim());
        mv.addObject("banphims",BanPhimService.showList(6, 1));
        return mv;
        
    }
    @GetMapping("/anh-ban-phim/{MaHH}")
    public void load_anh_ban_phim(@PathVariable("MaHH") String maHH, HttpServletResponse response) throws SQLException, IOException {
        response.setContentType("image/jpeg");

        Blob ph = BanPhimService.showDetail(maHH).getHinhAnh();

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
    @PostMapping("/them-ban-phim")
    public ModelAndView them_ban_phim(BanPhim banphim) throws IOException {
        BanPhimService.insert(banphim);
        mv.setViewName("redirect:/hang-hoa/ban-phim");
        return mv;
    }
    @PostMapping("/sua-ban-phim")
    public ModelAndView sua_ban_phim(BanPhim banphim) throws IOException {
        BanPhimService.update(banphim);
        mv.setViewName("redirect:/hang-hoa/ban-phim");
        return mv;
    }
    @PostMapping("/xoa-ban-phim")
    public ModelAndView xoa_ban_phim(@RequestParam("idBanPhim")String idbanphim){
        BanPhimService.delete(idbanphim);

        return mv;
    }
    @PostMapping("/show-ban-phim-on-modal")
    public ModelAndView show_ban_phim_on_modal(@RequestParam("maHH")String maHH){
        mv.setViewName("PageHangHoa/BanPhim :: #modalSua");
        mv.addObject("banphim",BanPhimService.showDetail(maHH));
        return mv;
    }
    
   
    @GetMapping("/ban-phim-ct/{maHH}")
    public ModelAndView page_ban_phim_ct(@PathVariable("maHH") String maHH){
        mv.addObject("banphim",BanPhimService.showDetail(maHH));
        mv.setViewName("ChiTietHangHoa/CTBanphim");
        return mv;
    }
    @PostMapping("/ban-phim")
    public ModelAndView load_page_ban_phim(@RequestParam("xs") int xs){
        mv.setViewName("PageHangHoa/BanPhim :: #listBanPhim");
        mv.addObject("banphims",BanPhimService.showList(6, xs));
        return mv;
    }
    @PostMapping("/show_more_ban_phim")
    public ModelAndView show_more_ban_phim(@RequestParam("xs") int xs,@RequestParam("limit") int limit){
        mv.setViewName("PageHangHoa/BanPhim :: #listBanPhim");
        mv.addObject("banphims",BanPhimService.showList(limit+6, xs));
        return mv;
    }
    @PostMapping("/check_id_ban_phim")
    public ModelAndView check_id_ban_phim(@RequestParam("idBanPhim")String idbanphim){
        if(BanPhimService.check_id(idbanphim)==null){
            mv.setViewName("Fragments/1Vai :: #maHH1");
        }else{
            mv.setViewName("Fragments/1Vai :: #maHH");
        }
        return mv;
    }
    //end- controller bàn phím

    /**/

    //Controller cho chuột
    @GetMapping("/chuot")
    public ModelAndView page_chuot(){
        mv.setViewName("PageHangHoa/Chuot");
        mv.addObject("chuot",new Chuot());
        mv.addObject("chuots",ChuotService.showList(6, 1));
        return mv;
    }
    @PostMapping("/chuot")
    public ModelAndView load_page_chuot(@RequestParam("xs") int xs){
        mv.setViewName("PageHangHoa/Chuot :: #listChuot");
        mv.addObject("chuots",ChuotService.showList(6, xs));
        return mv;
    }
    @PostMapping("/show_more_chuot")
    public ModelAndView show_more_chuot(@RequestParam("xs") int xs,@RequestParam("limit") int limit){
        mv.setViewName("PageHangHoa/Chuot :: #listChuot");
        mv.addObject("chuots",ChuotService.showList(limit+6, xs));
        return mv;
    }
    @GetMapping("/anh-chuot/{MaHH}")
    public void load_anh_chuot(@PathVariable("MaHH") String maHH, HttpServletResponse response) throws SQLException, IOException {
        response.setContentType("image/jpeg");

        Blob ph = ChuotService.showDetail(maHH).getHinhAnh();

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
    @PostMapping("/them-chuot")
    public ModelAndView them_chuot(Chuot chuot) throws IOException {
        ChuotService.insert(chuot);
        mv.setViewName("redirect:/hang-hoa/chuot");
        return mv;
    }
    @PostMapping("/sua-chuot")
    public ModelAndView sua_chuot(Chuot chuot) throws IOException {
        ChuotService.update(chuot);
        mv.setViewName("redirect:/hang-hoa/chuot");
        return mv;
    }
    @PostMapping("/xoa-chuot")
    public ModelAndView xoa_chuot(@RequestParam("idChuot")String idchuot){
        ChuotService.delete(idchuot);

        return mv;
    }
    @PostMapping("/show-chuot-on-modal")
    public ModelAndView show_chuot_on_modal(@RequestParam("maHH")String maHH){
        mv.setViewName("PageHangHoa/Chuot :: #modalSua");
        mv.addObject("chuot",ChuotService.showDetail(maHH));
        return mv;
    }
    
    @GetMapping("/chuot-ct/{maHH}")
    public ModelAndView page_chuot_ct(@PathVariable("maHH") String maHH){
        mv.addObject("chuot",ChuotService.showDetail(maHH));
        mv.setViewName("ChiTietHangHoa/CTChuot");
        return mv;
    }
    @PostMapping("/check_id_chuot")
    public ModelAndView check_id_chuot(@RequestParam("idChuot")String idchuot){
        if(ChuotService.check_id(idchuot)==null){
            mv.setViewName("Fragments/1Vai :: #maHH1");
        }else{
            mv.setViewName("Fragments/1Vai :: #maHH");
        }
        return mv;
    }
    //end- controller chuột

    /**/

    //controller cho loa
    @GetMapping("/loa")
    public ModelAndView page_loa(){
        mv.setViewName("PageHangHoa/Loa");
        mv.addObject("loa",new Loa());
        mv.addObject("loas",LoaService.showList(6, 1));
        return mv;
    }
    @GetMapping("/anh-loa/{MaHH}")
    public void load_anh_loa(@PathVariable("MaHH") String maHH, HttpServletResponse response) throws SQLException, IOException {
        response.setContentType("image/jpeg");

        Blob ph = LoaService.showDetail(maHH).getHinhAnh();

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
    @PostMapping("/them-loa")
    public ModelAndView them_loa(Loa loa) throws IOException {
        LoaService.insert(loa);
        mv.setViewName("redirect:/hang-hoa/loa");
        return mv;
    }
    @PostMapping("/sua-loa")
    public ModelAndView sua_loa(Loa loa) throws IOException {
        LoaService.update(loa);
        mv.setViewName("redirect:/hang-hoa/loa");
        return mv;
    }
    @PostMapping("/xoa-loa")
    public ModelAndView xoa_loa(@RequestParam("idLoa")String idloa){
        LoaService.delete(idloa);

        return mv;
    }
    @PostMapping("/show-loa-on-modal")
    public ModelAndView show_loa_on_modal(@RequestParam("maHH")String maHH){
        mv.setViewName("PageHangHoa/Loa :: #modalSua");
        mv.addObject("loa",LoaService.showDetail(maHH));
        return mv;
    }
    @GetMapping("/loa-ct/{maHH}")
    public ModelAndView page_loa_ct(@PathVariable("maHH") String maHH){
        mv.addObject("loa",LoaService.showDetail(maHH));
        mv.setViewName("ChiTietHangHoa/CTLoa");
        return mv;
    }
    @PostMapping("/loa")
    public ModelAndView load_page_loa(@RequestParam("xs") int xs){
        mv.setViewName("PageHangHoa/Loa :: #listLoa");
        mv.addObject("loas",LoaService.showList(6, xs));
        return mv;
    }
    @PostMapping("/show_more_loa")
    public ModelAndView show_more_loa(@RequestParam("xs") int xs,@RequestParam("limit") int limit){
        mv.setViewName("PageHangHoa/Loa :: #listLoa");
        mv.addObject("loas",LoaService.showList(limit+6, xs));
        return mv;
    }
    @PostMapping("/check_id_loa")
    public ModelAndView check_id_loa(@RequestParam("idLoa")String idloa){
        if(LoaService.check_id(idloa)==null){
            mv.setViewName("Fragments/1Vai :: #maHH1");
        }else{
            mv.setViewName("Fragments/1Vai :: #maHH");
        }
        return mv;
    }
    //end- controller loa

    /**/

    //controller cho màn hình
    @GetMapping("/man-hinh")
    public ModelAndView page_man_hinh(){
        mv.setViewName("PageHangHoa/ManHinh");
        mv.addObject("manhinh",new ManHinh());
        mv.addObject("manhinhs",ManHinhService.showList(6, 1));
        return mv;
    }
    @PostMapping("/them-man-hinh")
    public ModelAndView them_man_hinh(ManHinh manhinh) throws IOException {
        ManHinhService.insert(manhinh);
        mv.setViewName("redirect:/hang-hoa/man-hinh");
        return mv;
    }
    @PostMapping("/sua-man-hinh")
    public ModelAndView sua_man_hinh(ManHinh manhinh) throws IOException {
        ManHinhService.update(manhinh);
        mv.setViewName("redirect:/hang-hoa/man-hinh");
        return mv;
    }
    @PostMapping("/xoa-man-hinh")
    public ModelAndView xoa_man_hinh(@RequestParam("idManHinh")String idmanhinh){
        ManHinhService.delete(idmanhinh);

        return mv;
    }
    @GetMapping("/anh-man-hinh/{MaHH}")
    public void load_anh_man_hinh(@PathVariable("MaHH") String maHH, HttpServletResponse response) throws SQLException, IOException {
        response.setContentType("image/jpeg");

        Blob ph = ManHinhService.showDetail(maHH).getHinhAnh();

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
    @PostMapping("/show-man-hinh-on-modal")
    public ModelAndView show_man_hinh_on_modal(@RequestParam("maHH")String maHH){
        mv.setViewName("PageHangHoa/ManHinh :: #modalSua");
        mv.addObject("manhinh",ManHinhService.showDetail(maHH));
        return mv;
    }
    @GetMapping("/man-hinh-ct/{maHH}")
    public ModelAndView page_man_hinh_ct(@PathVariable("maHH") String maHH){
        mv.addObject("manhinh",ManHinhService.showDetail(maHH));
        mv.setViewName("ChiTietHangHoa/CTManHinh");
        return mv;
    }
    @PostMapping("/man-hinh")
    public ModelAndView load_page_man_hinh(@RequestParam("xs") int xs){
        mv.setViewName("PageHangHoa/ManHinh :: #listManHinh");
        mv.addObject("manhinhs",ManHinhService.showList(6, xs));
        return mv;
    }
    @PostMapping("/show_more_man_hinh")
    public ModelAndView show_more_man_hinh(@RequestParam("xs") int xs,@RequestParam("limit") int limit){
        mv.setViewName("PageHangHoa/ManHinh :: #listManHinh");
        mv.addObject("manhinhs",ManHinhService.showList(limit+6, xs));
        return mv;
    }
    @PostMapping("/check_id_man_hinh")
    public ModelAndView check_id_man_hinh(@RequestParam("idManHinh")String idmanhinh){
        if(ManHinhService.check_id(idmanhinh)==null){
            mv.setViewName("Fragments/1Vai :: #maHH1");
        }else{
            mv.setViewName("Fragments/1Vai :: #maHH");
        }
        return mv;
    }
    //end controller man hinh

    /**/

    //controller pc
    @GetMapping("/pc")
    public ModelAndView page_pc(){
        mv.setViewName("PageHangHoa/PC");
        mv.addObject("pc",new PC());
        mv.addObject("pcs",PcService.showList(6, 1));
        return mv;
    }
    @GetMapping("/anh-pc/{MaHH}")
    public void load_anh_pc(@PathVariable("MaHH") String maHH, HttpServletResponse response) throws SQLException, IOException {
        response.setContentType("image/jpeg");

        Blob ph = PcService.showDetail(maHH).getHinhAnh();

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
    @PostMapping("/them-pc")
    public ModelAndView them_pc(PC pc) throws IOException {
        PcService.insert(pc);
        mv.setViewName("redirect:/hang-hoa/pc");
        return mv;
    }
    @PostMapping("/show-pc-on-modal")
    public ModelAndView show_pc_on_modal(@RequestParam("maHH")String maHH){
        mv.setViewName("PageHangHoa/PC :: #modalSua");
        mv.addObject("pc",PcService.showDetail(maHH));
        return mv;
    }
    @PostMapping("/sua-pc")
    public ModelAndView sua_pc(PC pc) throws IOException {
        PcService.update(pc);
        mv.setViewName("redirect:/hang-hoa/pc");
        return mv;
    }
    @PostMapping("/xoa-pc")
    public ModelAndView xoa_pc(@RequestParam("idPC")String idpc){
        PcService.delete(idpc);

        return mv;
    }
    @GetMapping("/pc-ct/{maHH}")
    public ModelAndView page_pc_ct(@PathVariable("maHH") String maHH){
        mv.addObject("pc",PcService.showDetail(maHH));
        mv.setViewName("ChiTietHangHoa/CTPC");
        return mv;
    }
    @PostMapping("/pc")
    public ModelAndView load_page_pc(@RequestParam("xs") int xs){
        mv.setViewName("PageHangHoa/PC :: #listPC");
        mv.addObject("pcs",PcService.showList(6, xs));
        return mv;
    }
    @PostMapping("/show_more_pc")
    public ModelAndView show_more_pc(@RequestParam("xs") int xs,@RequestParam("limit") int limit){
        mv.setViewName("PageHangHoa/PC :: #listPC");
        mv.addObject("pcs",PcService.showList(limit+6, xs));
        return mv;
    }
    @PostMapping("/check_id_pc")
    public ModelAndView check_id_pc(@RequestParam("idPC")String idpc){
        if(PcService.check_id(idpc)==null){
            mv.setViewName("Fragments/1Vai :: #maHH1");
        }else{
            mv.setViewName("Fragments/1Vai :: #maHH");
        }
        return mv;
    }
    //end controller pc

    /**/

    //controller tai nghe
    @GetMapping("/tai-nghe")
    public ModelAndView page_tai_nghe(){
        mv.setViewName("PageHangHoa/TaiNghe");
        mv.addObject("tainghe",new TaiNghe());
        mv.addObject("tainghes",TaiNgheService.showList(6, 1));
        return mv;
    }
    @GetMapping("/anh-tai-nghe/{MaHH}")
    public void load_anh_tai_nghe(@PathVariable("MaHH") String maHH, HttpServletResponse response) throws SQLException, IOException {
        response.setContentType("image/jpeg");

        Blob ph = TaiNgheService.showDetail(maHH).getHinhAnh();

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
    @PostMapping("/them-tai-nghe")
    public ModelAndView them_tai_nghe(TaiNghe tainghe) throws IOException {
        TaiNgheService.insert(tainghe);
        mv.setViewName("redirect:/hang-hoa/tai-nghe");
        return mv;
    }
    @PostMapping("/show-tai-nghe-on-modal")
    public ModelAndView show_tai_nghe_on_modal(@RequestParam("maHH")String maHH){
        mv.setViewName("PageHangHoa/TaiNghe :: #modalSua");
        mv.addObject("tainghe",TaiNgheService.showDetail(maHH));
        return mv;
    }
    @GetMapping("/tai-nghe-ct/{maHH}")
    public ModelAndView page_tai_nghe_ct(@PathVariable("maHH") String maHH){
        mv.addObject("tainghe",TaiNgheService.showDetail(maHH));
        mv.setViewName("ChiTietHangHoa/CTTainghe");
        return mv;
    }
    @PostMapping("/sua-tai-nghe")
    public ModelAndView sua_tai_nghe(TaiNghe tainghe) throws IOException {
        TaiNgheService.update(tainghe);
        mv.setViewName("redirect:/hang-hoa/tai-nghe");
        return mv;
    }
    @PostMapping("/xoa-tai-nghe")
    public ModelAndView xoa_tai_nghe(@RequestParam("idTaiNghe")String idtainghe){
        TaiNgheService.delete(idtainghe);

        return mv;
    }
    @PostMapping("/tai-nghe")
    public ModelAndView load_page_tai_nghe(@RequestParam("xs") int xs){
        mv.setViewName("PageHangHoa/TaiNghe :: #listTaiNghe");
        mv.addObject("tainghes",TaiNgheService.showList(6, xs));
        return mv;
    }
    @PostMapping("/show_more_tai_nghe")
    public ModelAndView show_more_tai_nghe(@RequestParam("xs") int xs,@RequestParam("limit") int limit){
        mv.setViewName("PageHangHoa/TaiNghe :: #listTaiNghe");
        mv.addObject("tainghes",TaiNgheService.showList(limit+6, xs));
        return mv;
    }
    @PostMapping("/check_id_tai_nghe")
    public ModelAndView check_id_tai_nghe(@RequestParam("idTaiNghe")String idtainghe){
        if(TaiNgheService.check_id(idtainghe)==null){
            mv.setViewName("Fragments/1Vai :: #maHH1");
        }else{
            mv.setViewName("Fragments/1Vai :: #maHH");
        }
        return mv;
    }
    //end controller tai nghe
}
