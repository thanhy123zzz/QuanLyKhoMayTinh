package com.khomaytinh.quanlykhomaytinh.Dao.DaoImp;

import com.khomaytinh.quanlykhomaytinh.Dao.TaiNgheDao;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.TaiNghe;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.HangHoaMapper;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.TaiNgheMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class TaiNgheDaolmp implements TaiNgheDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(TaiNghe hh) throws IOException {
        String queryHH = "INSERT INTO `quanlykhomaytinh`.`hanghoa` " +
                "(`MAHH`, `Ten`, `HangSX`, `Gia`, `TrongLuong`, `SoluongCon`,`HinhAnh`) VALUES (?,?,?,?,?,?,?);";
        int kq1= jdbcTemplate.update(queryHH,new Object[]{hh.getID(),hh.getTen(),hh.getHangSX(),hh.getGia(),hh.getTrongLuong(),
        hh.getSoLuongCon(),hh.getHinhAnhbit().getBytes()});

        String queryLap = "insert into TaiNghe values(?,?,?,?,?,?,?,?,?)";
        int kq2 = jdbcTemplate.update(queryLap,new Object[]{hh.getID(),hh.getModel(),hh.getKetNoi(),hh.getKieuTN(),hh.getLed(),
        hh.getMau(),hh.getTanSo(),hh.getChatLieu(),hh.getKhaNangCachAm()});
        return kq1+kq2;
    }

    @Override
    public int update(TaiNghe hh) throws IOException {
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

        String queryLap = "update TaiNghe set model=?,ketnoi=?,kieutn=?,led=?,mau=?,tanso=?,khanangcacham=?,chatlieu=? where MaHH =?";
        int kq2= jdbcTemplate.update(queryLap,new Object[]{hh.getModel(),hh.getKetNoi(),hh.getKieuTN(),hh.getLed(),
                hh.getMau(),hh.getTanSo(),hh.getChatLieu(),hh.getKhaNangCachAm(),hh.getID()});
        return kq1+kq2;
    }

    @Override
    public List<TaiNghe> showList(int limit, int xapsep) {
        if(xapsep==1){
            String query = "select*from hanghoa,TaiNghe where hanghoa.MAHH = TaiNghe.MAHH order by hanghoa.Gia ASC limit "+limit;
            return jdbcTemplate.query(query,new TaiNgheMapper());
        }
        else{
            String query = "select*from hanghoa,TaiNghe where hanghoa.MAHH = TaiNghe.MAHH order by hanghoa.Gia DESC limit "+limit;
            return jdbcTemplate.query(query,new TaiNgheMapper());
        }
    }

    @Override
    public TaiNghe showDetail(String id) {
        String query = "select*from hanghoa,TaiNghe where hanghoa.MAHH = TaiNghe.MAHH and hanghoa.MAHH = '"+id+"'";
        if(jdbcTemplate.query(query,new TaiNgheMapper()).size()==0)
        return null;
        else return jdbcTemplate.query(query,new TaiNgheMapper()).get(0);
    }

    @Override
    public int delete(String id) {
        String query2 = "delete from tainghe where MAHH='"+id+"'";
        String query= "delete from hanghoa where MAHH='"+id+"'";

        int kq = jdbcTemplate.update(query2);
        kq+= jdbcTemplate.update(query);
        return kq;
    }
    @Override
    public HangHoa check_id(String id) {
        String query = "select*from hanghoa where MAHH = '"+id+"'";
        if(jdbcTemplate.query(query,new HangHoaMapper()).size()==0)
            return null;
        else return jdbcTemplate.query(query,new HangHoaMapper()).get(0);
    }
}

