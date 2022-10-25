package com.khomaytinh.quanlykhomaytinh.Dao.DaoImp;

import com.khomaytinh.quanlykhomaytinh.Dao.LoaDao;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.Loa;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.HangHoaMapper;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.LoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class LoaDaolmp implements LoaDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Loa hh) throws IOException {
        String queryHH = "INSERT INTO `quanlykhomaytinh`.`hanghoa` " +
                "(`MAHH`, `Ten`, `HangSX`, `Gia`, `TrongLuong`, `SoluongCon`,`HinhAnh`) VALUES (?,?,?,?,?,?,?);";
        int kq1= jdbcTemplate.update(queryHH,new Object[]{hh.getID(),hh.getTen(),hh.getHangSX(),hh.getGia(),hh.getTrongLuong(),
        hh.getSoLuongCon(),hh.getHinhAnhbit().getBytes()});

        String queryLap = "insert into Loa values(?,?,?,?,?)";
        int kq2 = jdbcTemplate.update(queryLap,new Object[]{hh.getID(),hh.getModel(),hh.getKetNoi(),hh.getDangLoa(),hh.getKieuLoa()});
        return kq1+kq2;
    }

    @Override
    public int update(Loa hh) throws IOException {
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

        String queryLap = "update Loa set model=?,ketnoi=?,dangloa=?,kieuloa=? where MaHH =?";
        int kq2= jdbcTemplate.update(queryLap,new Object[]{hh.getModel(),hh.getKetNoi(),hh.getDangLoa(),hh.getKieuLoa(),hh.getID()});
        return kq1+kq2;
    }

    @Override
    public List<Loa> showList(int limit, int xapsep) {
        if(xapsep==1){
            String query = "select*from hanghoa,Loa where hanghoa.MAHH = Loa.MAHH order by hanghoa.Gia ASC limit "+limit;
            return jdbcTemplate.query(query,new LoaMapper());
        }
        else{
            String query = "select*from hanghoa,Loa where hanghoa.MAHH = Loa.MAHH order by hanghoa.Gia DESC limit "+limit;
            return jdbcTemplate.query(query,new LoaMapper());
        }
    }

    @Override
    public Loa showDetail(String id) {
        String query = "select*from hanghoa,Loa where hanghoa.MAHH = Loa.MAHH and hanghoa.MAHH = '"+id+"'";
        if(jdbcTemplate.query(query,new LoaMapper()).size()==0)
        return null;
        else return jdbcTemplate.query(query,new LoaMapper()).get(0);
    }

    @Override
    public int delete(String id) {
        String query2 = "delete from loa where MAHH='"+id+"'";
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

