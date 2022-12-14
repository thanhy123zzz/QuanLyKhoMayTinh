package com.khomaytinh.quanlykhomaytinh.Controller;

import com.khomaytinh.quanlykhomaytinh.Model.ChiTietPhieu;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.PhieuXuatNhap;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;

@RequestMapping("/xuat-nhap")
@Controller
public class XuatNhapController extends Common{
    @GetMapping("/tao-phieu")
    public ModelAndView phieu(HttpSession session){
        List<HangHoa> list = new ArrayList<>();
        mv.addObject("hhs",list);
        mv.setViewName("XuatNhap/TaoDonXN");
        mv.addObject("hhs",xuatNhapServiec.load_List_HH("nhap"));
        session.setAttribute("listHHcuaPhieu",list);
        session.setAttribute("loai","nhap");
        return mv;
    }
    @PostMapping("/load_HH")
    public ModelAndView tao_phieu(HttpSession session,@RequestParam("loai") String loai){
        mv.setViewName("XuatNhap/TaoDonXN :: #loadHH");
        mv.addObject("hhs",xuatNhapServiec.load_List_HH(loai));
        session.setAttribute("loai",loai);
        return mv;
    }
    @GetMapping("/anh/{maHH}")
    public void load_anhhh(@PathVariable("maHH") String maHH, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("image/jpeg");

        Blob ph = xuatNhapServiec.showDetailHH(maHH).getHinhAnh();

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
    @PostMapping("/them-hh-session")
    public ModelAndView them_hh_session(HttpSession session,@RequestParam("id") String maHH){
        mv.setViewName("XuatNhap/TaoDonXN :: #listTenHH");
        List<HangHoa> list = (List<HangHoa>) session.getAttribute("listHHcuaPhieu");
        list.add(xuatNhapServiec.showDetailHH(maHH));
        session.setAttribute("listHHcuaPhieu",list);
        return mv;
    }
    @GetMapping("/xac-nhan-chi-tiet")
    public ModelAndView xac_nhan_chi_tiet(HttpSession session,Principal principal){
        mv.setViewName("XuatNhap/Chitietdon");
        List<HangHoa> list = (List<HangHoa>) session.getAttribute("listHHcuaPhieu");
        String loai = (String)session.getAttribute("loai");
        String userName = principal.getName();
        PhieuXuatNhap phieuXuatNhap = new PhieuXuatNhap();
        List<ChiTietPhieu> listChitiet = new ArrayList<>();
        for(HangHoa hh : list){
            ChiTietPhieu chitiet= new ChiTietPhieu();
            chitiet.setHangHoa(hh);
            listChitiet.add(chitiet);
        }
        phieuXuatNhap.setChiTietPhieus(listChitiet);
        phieuXuatNhap.setNgayXP(new Date());
        phieuXuatNhap.setAccounts(loginService.CheckUserName(userName));
        phieuXuatNhap.setLoai((String)session.getAttribute("loai"));
        phieuXuatNhap.setSoLoaiSP(listChitiet.size());
        mv.addObject("phieuXuatNhap",phieuXuatNhap);
        return mv;
    }
    @PostMapping("/confirm")
    public ModelAndView comfirm(PhieuXuatNhap phieuXuatNhap,Principal principal){
        phieuXuatNhap.setAccounts(loginService.CheckUserName(principal.getName()));
        for(int i = 0; i<phieuXuatNhap.getChiTietPhieus().size();i++){
            phieuXuatNhap.getChiTietPhieus().get(i)
                    .setHangHoa(xuatNhapServiec.showDetailHH(phieuXuatNhap.getChiTietPhieus().get(0).getIdHangHoa()));
            phieuXuatNhap.getChiTietPhieus().get(i).setDonGia(phieuXuatNhap.getChiTietPhieus().get(0).getHangHoa().getGia());
        }
        xuatNhapServiec.insertPhieu(phieuXuatNhap);
        if(Objects.equals(phieuXuatNhap.getLoai(), "nhap")){
            mv.setViewName("redirect:/xuat-nhap/lich-su-nhap");
        }else{
            mv.setViewName("redirect:/xuat-nhap/lich-su-xuat");
        }
        return mv;
    }
    @PostMapping("/load-loai-hang")
    public ModelAndView load_loai_hang(@RequestParam("loai") String loai,@RequestParam("id")int id){
        mv.setViewName("XuatNhap/Chitietdon :: .loaihangclass");
        mv.addObject("loaiHang",/*lapTopService.load_listhh(loai)*/3);
        mv.addObject("stat.index",id);
        return mv;
    }
    @PostMapping("/check-ma-phieu")
    public ModelAndView check_ma_phieu(@RequestParam("maPhieu")String maPhieu){
        if(xuatNhapServiec.showDetailPhieu(maPhieu)==null) {
            mv.setViewName("Fragments/1Vai :: #maHH1");
        }else{
            mv.setViewName("Fragments/1Vai :: #checkMaPhieu");
        }
        return mv;
    }

    //L???ch s??? Nh???p
    @GetMapping("/lich-su-nhap")
    public ModelAndView lich_su_nhap(){
        mv.setViewName("XuatNhap/Lichsunhapkho");
        mv.addObject("Phieus",xuatNhapServiec.showList("nhap"));
        return mv;
    }

    // l???ch s??? Xu???t
    @GetMapping("/lich-su-xuat")
    public ModelAndView lic_su_xuat(){
        mv.setViewName("XuatNhap/Lichsuxuatkho");
        mv.addObject("Phieus",xuatNhapServiec.showList("xuat"));
        return mv;
    }

    @GetMapping ("/lich-su/{maPhieu}")
    public ModelAndView chi_tiet_phieu_nhap(HttpSession session,@PathVariable("maPhieu") String maPhieu){
        mv.setViewName("XuatNhap/XemChiTietDon");
        PhieuXuatNhap p = xuatNhapServiec.showDetailPhieu(maPhieu);
        List<ChiTietPhieu> list = p.getChiTietPhieus();
        session.setAttribute("chiTietPhieus",list);
        mv.addObject("phieuXuatNhap",p);
        return mv;
    }

    @PostMapping("/sua")
    public ModelAndView sua(PhieuXuatNhap phieuXuatNhap){
        xuatNhapServiec.updatePhieu(phieuXuatNhap);
        if(Objects.equals(phieuXuatNhap.getLoai(), "nhap")){
            mv.setViewName("redirect:/xuat-nhap/lich-su-nhap");
        }else {
            mv.setViewName("redirect:/xuat-nhap/lich-su-xuat");
        }
        return mv;
    }
    @PostMapping("/change-chitiet")
    public ModelAndView change_ct(@RequestParam("index")int index,HttpSession session){
        mv.setViewName("XuatNhap/XemChiTietDon :: #bodyTable");
        List<ChiTietPhieu> list = (List<ChiTietPhieu>) session.getAttribute("chiTietPhieus");
        list.remove(index);
        mv.addObject("chiTietPhieus",list);
        return mv;
    }

    @PostMapping("/xoa-phieu-nhap")
    public ModelAndView xoa_phieu(@RequestParam("idPhieu") String maPhieu){
        xuatNhapServiec.deletePhieu(maPhieu);
        mv.addObject("Phieus", xuatNhapServiec.showList("nhap"));
        mv.setViewName("XuatNhap/Lichsunhapkho :: #listPhieuNhap");
        return mv;
    }
    @PostMapping("/xoa-phieu-xuat")
    public ModelAndView xoa_phieu_xuat(@RequestParam("idPhieu") String maPhieu){
        xuatNhapServiec.deletePhieu(maPhieu);
        mv.addObject("Phieus", xuatNhapServiec.showList("xuat"));
        mv.setViewName("XuatNhap/Lichsuxuatkho :: #listPhieuNhap");
        return mv;
    }
    @PostMapping("/tim-kiem")
    public ModelAndView tim_kiem(@RequestParam("key")String key,@RequestParam("loai")String loai){
        mv.addObject("hhs",xuatNhapServiec.search_hh(loai,key));
        mv.setViewName("XuatNhap/TaoDonXN :: #loadHH");
        return mv;
    }
}
