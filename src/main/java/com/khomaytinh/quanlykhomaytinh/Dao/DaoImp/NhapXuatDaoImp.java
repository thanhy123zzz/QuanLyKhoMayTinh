package com.khomaytinh.quanlykhomaytinh.Dao.DaoImp;

import com.khomaytinh.quanlykhomaytinh.Dao.XuatNhapDao;
import com.khomaytinh.quanlykhomaytinh.Model.ChiTietPhieu;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.ChiTiecPhieuMapper;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.HangHoaMapper;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.PhieuXuatNhapMapper;
import com.khomaytinh.quanlykhomaytinh.Model.PhieuXuatNhap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class NhapXuatDaoImp implements XuatNhapDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int insertPhieu(PhieuXuatNhap p) {
        int kq;
        p.setTrangThai(true);
        String query = "insert into phieuxuatnhap values(?,?,?,?,?,?,?)";
        kq = jdbcTemplate.update(query,new Object[]{p.getMaPhieu(),p.getLoai(),p.getNgayXP(),p.getSoLoaiSP(),p.getTongTienCaPhieu(),p.isTrangThai(),p.getAccounts().getUserName()});
        if(Objects.equals(p.getLoai(), "nhap")){
            for(ChiTietPhieu ct : p.getChiTietPhieus()){
                String sql = "insert into chitietphieu values(?,?,?,?,?)";
                jdbcTemplate.update(sql,new Object[]{p.getMaPhieu(),ct.getIdHangHoa(),ct.getSoLuong(),ct.getDonGia(),ct.getThanhTien()});
                String sql2 = "update hanghoa set SoLuongCon = SoLuongCon +"+ct.getSoLuong()+ " where MAHH='"+ct.getIdHangHoa()+"'";
                jdbcTemplate.update(sql2);
            }
        }
        else{
            for(ChiTietPhieu ct : p.getChiTietPhieus()){
                String sql = "insert into chitietphieu values(?,?,?,?,?)";
                jdbcTemplate.update(sql,new Object[]{p.getMaPhieu(),ct.getIdHangHoa(),ct.getSoLuong(),ct.getDonGia(),ct.getThanhTien()});
                String sql2 = "update hanghoa set SoLuongCon = SoLuongCon -"+ct.getSoLuong()+ " where MAHH='"+ct.getIdHangHoa()+"'";
                jdbcTemplate.update(sql2);
            }
        }
        return kq;
    }

    @Override
    public int updatePhieu(PhieuXuatNhap p) {
        String updatePhieu = "update PhieuXuatNhap set TrangThai=?,SLLoaiSP=?,TongTienCaPhieu=? where MaPhieu =?";
        int kq = jdbcTemplate.update(updatePhieu,new Object[]{p.isTrangThai(),p.getChiTietPhieus().size(),p.getTongTienCaPhieu(),p.getMaPhieu()});

        List<ChiTietPhieu> chiTietPhieu = showDetailPhieu(p.getMaPhieu()).getChiTietPhieus();
        String delete = "delete from chitietphieu where MaPhieu ='"+p.getMaPhieu()+"'";
        int kq1 =jdbcTemplate.update(delete);

        String insertCt = "insert into chitietphieu values(?,?,?,?,?)";
        int kq2=0;
        for(ChiTietPhieu ct: p.getChiTietPhieus()) {
           kq2 += jdbcTemplate.update(insertCt,new Object[]{p.getMaPhieu(),ct.getIdHangHoa(),ct.getSoLuong(),ct.getHangHoa().getGia(),ct.getThanhTien()});
        }

        int kq3=0;
        List<ChiTietPhieu> listCt = new ArrayList<>();
        for(ChiTietPhieu hf : chiTietPhieu){
            int diem=0;
            for(ChiTietPhieu hs:p.getChiTietPhieus()){
                if(Objects.equals(hf.getHangHoa().getID(), hs.getIdHangHoa()))
                {
                    String updateHH;
                    int hieu = hf.getSoLuong()-hs.getSoLuong();
                    if(Objects.equals(p.getLoai(), "nhap")){
                        updateHH = "update hanghoa set SoluongCon = SoluongCon - "+hieu+" where MAHH = '"+hf.getHangHoa().getID()+"'";
                    }else{
                        updateHH = "update hanghoa set SoluongCon = SoluongCon + "+hieu+" where MAHH = '"+hf.getHangHoa().getID()+"'";
                    }
                    jdbcTemplate.update(updateHH);
                    break;
                }
                diem++;
                if(diem>=p.getChiTietPhieus().size()){
                    String updateHH;
                    if(Objects.equals(p.getLoai(), "nhap")){
                        updateHH = "update hanghoa set SoluongCon = SoluongCon - "+hf.getSoLuong()+" where MAHH = '"+hf.getHangHoa().getID()+"'";
                    }else{
                        updateHH = "update hanghoa set SoluongCon = SoluongCon + "+hf.getSoLuong()+" where MAHH = '"+hf.getHangHoa().getID()+"'";
                    }
                    jdbcTemplate.update(updateHH);
                }
            }
        }

        return 1;
    }

    @Override
    public int updateTrangThaiPhieu(Boolean p) {
        return 0;
    }

    @Override
    public int deletePhieu(String id) {
        List<ChiTietPhieu> chiTietPhieu = showDetailPhieu(id).getChiTietPhieus();

        String delete = "delete from chitietphieu where MaPhieu ='" + id + "'";
        int kq1 = jdbcTemplate.update(delete);

        String updateHH;
        for (ChiTietPhieu hf : chiTietPhieu){
            if (Objects.equals(showDetailPhieu(id).getLoai(), "nhap")) {
                updateHH = "update hanghoa set SoluongCon = SoluongCon - " + hf.getSoLuong() + " where MAHH = '" + hf.getHangHoa().getID() + "'";
            } else {
                updateHH = "update hanghoa set SoluongCon = SoluongCon + " + hf.getSoLuong() + " where MAHH = '" + hf.getHangHoa().getID() + "'";
            }
            jdbcTemplate.update(updateHH);
         }
        String delete2 = "delete from phieuxuatnhap where MaPhieu ='" + id + "'";
        jdbcTemplate.update(delete2);

        return 0;
    }

    @Override
    public List<PhieuXuatNhap> showList(String loai) {
        String query = "select*from phieuxuatnhap where Loai ='"+loai+"'";
        List<PhieuXuatNhap> phieuXuatNhaps = jdbcTemplate.query(query,new PhieuXuatNhapMapper());
        return phieuXuatNhaps;
    }

    @Override
    public PhieuXuatNhap showDetailPhieu(String id) {
        String query = "select*from phieuxuatnhap where MaPhieu ='"+id+"'";
        List<PhieuXuatNhap> list = jdbcTemplate.query(query,new PhieuXuatNhapMapper());
        if(list.size()==0) return null;
        String sql = "select*from chitietphieu where MaPhieu ='"+id+"'";
        List<ChiTietPhieu> list1 = jdbcTemplate.query(sql,new ChiTiecPhieuMapper());
        list.get(0).setChiTietPhieus(list1);
        return list.get(0);
    }
    @Override
    public List<HangHoa> load_List_HH( String loai) {
        List<HangHoa> list = new ArrayList<>();
        if(Objects.equals(loai, "xuat")){
            String query = "select*from hanghoa where SoluongCon >0 ";
            list = jdbcTemplate.query(query,new HangHoaMapper());
        }else{
            String query = "select*from hanghoa";
            list = jdbcTemplate.query(query,new HangHoaMapper());
        }
        return list;
    }

    @Override
    public List<HangHoa> search_hh(String loai,String key) {
        List<HangHoa> list;
        if(Objects.equals(loai, "xuat")){
            String query = "select*from hanghoa where concat_ws(' ',MAHH,Ten,HangSX,Gia) like '%"+key+"%' and SoluongCon >0 ";
            list = jdbcTemplate.query(query,new HangHoaMapper());
        }else{
            String query = "select*from hanghoa where concat_ws(' ',MAHH,Ten,HangSX,Gia) like '%"+key+"%'";
            list = jdbcTemplate.query(query,new HangHoaMapper());
        }
        return list;
    }

    @Override
    public HangHoa showDetailHH(String maHH) {
        String q = "select*from hanghoa where MAHH='"+maHH+"'";
        return jdbcTemplate.query(q,new HangHoaMapper()).get(0);
    }
}
