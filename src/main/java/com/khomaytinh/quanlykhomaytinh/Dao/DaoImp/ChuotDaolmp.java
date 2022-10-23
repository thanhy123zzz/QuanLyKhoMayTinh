package com.khomaytinh.quanlykhomaytinh.Dao.DaoImp;

import com.khomaytinh.quanlykhomaytinh.Dao.ChuotDao;
import com.khomaytinh.quanlykhomaytinh.Dao.ChuotDao;

import com.khomaytinh.quanlykhomaytinh.Model.Chuot;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.ChuotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class ChuotDaolmp implements ChuotDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Chuot hh) throws IOException {
        String queryHH = "INSERT INTO `quanlykhomaytinh`.`hanghoa` " +
                "(`MAHH`, `Ten`, `HangSX`, `Gia`, `TrongLuong`, `SoluongCon`,`HinhAnh`) VALUES (?,?,?,?,?,?,?);";
        int kq1= jdbcTemplate.update(queryHH,new Object[]{hh.getID(),hh.getTen(),hh.getHangSX(),hh.getGia(),hh.getTrongLuong(),
        hh.getSoLuongCon(),hh.getHinhAnhbit().getBytes()});

        String queryLap = "insert into Chuot values(?,?,?,?,?,?,?)";
        int kq2 = jdbcTemplate.update(queryLap,new Object[]{hh.getID(),hh.getModel(),hh.getKetNoi(),hh.getSoNut(),hh.getLed(),
        hh.getMau(),hh.getCamBien()});
        return kq1+kq2;
    }

    @Override
    public int update(Chuot hh) throws IOException {
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

        String queryLap = "update Chuot set model=?,ketnoi=?,sonut=?,led=?,mau=?,cambien=? where MaHH =?";
        int kq2= jdbcTemplate.update(queryLap,new Object[]{hh.getModel(),hh.getKetNoi(),hh.getSoNut(),hh.getLed(),
                hh.getMau(),hh.getCamBien(),hh.getID()});
        return kq1+kq2;
    }

    @Override
    public List<Chuot> showList(int limit, int xapsep) {
        if(xapsep==1){
            String query = "select*from hanghoa,Chuot where hanghoa.MAHH = Chuot.MAHH order by hanghoa.Gia ASC limit "+limit;
            return jdbcTemplate.query(query,new ChuotMapper());
        }
        else{
            String query = "select*from hanghoa,Chuot where hanghoa.MAHH = Chuot.MAHH order by hanghoa.Gia DESC limit "+limit;
            return jdbcTemplate.query(query,new ChuotMapper());
        }
    }

    @Override
    public Chuot showDetail(String id) {
        String query = "select*from hanghoa,Chuot where hanghoa.MAHH = Chuot.MAHH and hanghoa.MAHH = '"+id+"'";
        if(jdbcTemplate.query(query,new ChuotMapper()).size()==0)
        return null;
        else return jdbcTemplate.query(query,new ChuotMapper()).get(0);
    }

    @Override
    public int delete(String id) {
        String query2 = "delete from chuot where MAHH='"+id+"'";
        String query= "delete from hanghoa where MAHH='"+id+"'";

        int kq = jdbcTemplate.update(query2);
        kq+= jdbcTemplate.update(query);
        return kq;
    }
}

