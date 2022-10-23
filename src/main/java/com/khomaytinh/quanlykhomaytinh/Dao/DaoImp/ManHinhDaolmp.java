package com.khomaytinh.quanlykhomaytinh.Dao.DaoImp;

import com.khomaytinh.quanlykhomaytinh.Dao.ManHinhDao;

import com.khomaytinh.quanlykhomaytinh.Model.ManHinh;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.ManHinhMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class ManHinhDaolmp implements ManHinhDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(ManHinh hh) throws IOException {
        String queryHH = "INSERT INTO `quanlykhomaytinh`.`hanghoa` " +
                "(`MAHH`, `Ten`, `HangSX`, `Gia`, `TrongLuong`, `SoluongCon`,`HinhAnh`) VALUES (?,?,?,?,?,?,?);";
        int kq1= jdbcTemplate.update(queryHH,new Object[]{hh.getID(),hh.getTen(),hh.getHangSX(),hh.getGia(),hh.getTrongLuong(),
        hh.getSoLuongCon(),hh.getHinhAnhbit().getBytes()});

        String queryLap = "insert into ManHinh values(?,?,?,?,?,?,?)";
        int kq2 = jdbcTemplate.update(queryLap,new Object[]{hh.getID(),hh.getModel(),hh.getKetNoi(),hh.getTanSoQuet(),hh.getTiLeKhungHinh(),
        hh.getLoaiMH(),hh.getMauSacHienThi()});
        return kq1+kq2;
    }

    @Override
    public int update(ManHinh hh) throws IOException {
        int kq1;
        if(!hh.getHinhAnhbit().isEmpty()) {
            String queryHH = "update hanghoa set Ten = ?, HangSX =?, Gia =?, TrongLuong=?,HinhAnh=?,SoLuongCon=? where MAHH=?;";
            kq1 = jdbcTemplate.update(queryHH, new Object[]{hh.getTen(), hh.getHangSX(), hh.getGia(), hh.getTrongLuong(), hh.getHinhAnhbit().getBytes(),
                    hh.getSoLuongCon(), hh.getID()});
        }
        else {
            String queryHH = "update hanghoa set Ten = ?, HangSX =?, Gia =?, TrongLuong=?,SoLuongCon=? where MAHH=?;";
            kq1 = jdbcTemplate.update(queryHH, new Object[]{hh.getTen(), hh.getHangSX(), hh.getGia(), hh.getTrongLuong(),
                    hh.getSoLuongCon(), hh.getID()});
        }

        String queryLap = "update ManHinh set HeDieuHanh=?,WebCam=?,Ram=?,GPU=?,CPU=?,CARD=?,Pin=? where MaHH =?";
        int kq2= jdbcTemplate.update(queryLap,new Object[]{hh.getModel(),hh.getKetNoi(),hh.getTanSoQuet(),hh.getTiLeKhungHinh(),
                hh.getLoaiMH(),hh.getMauSacHienThi(),hh.getID()});
        return kq1+kq2;
    }

    @Override
    public List<ManHinh> showList(int limit, int xapsep) {
        if(xapsep==1){
            String query = "select*from hanghoa,ManHinh where hanghoa.MAHH = ManHinh.MAHH order by hanghoa.Gia ASC limit "+limit;
            return jdbcTemplate.query(query,new ManHinhMapper());
        }
        else{
            String query = "select*from hanghoa,ManHinh where hanghoa.MAHH = ManHinh.MAHH order by hanghoa.Gia DESC limit "+limit;
            return jdbcTemplate.query(query,new ManHinhMapper());
        }
    }

    @Override
    public ManHinh showDetail(String id) {
        String query = "select*from hanghoa,ManHinh where hanghoa.MAHH = ManHinh.MAHH and hanghoa.MAHH = '"+id+"'";
        if(jdbcTemplate.query(query,new ManHinhMapper()).size()==0)
        return null;
        else return jdbcTemplate.query(query,new ManHinhMapper()).get(0);
    }

    @Override
    public int delete(String id) {
        String query2 = "delete from manhinh where MAHH='"+id+"'";
        String query= "delete from hanghoa where MAHH='"+id+"'";

        int kq = jdbcTemplate.update(query2);
        kq+= jdbcTemplate.update(query);
        return kq;
    }
}

