package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.ChiTietPhieu;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.ThongKe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThongKeMapper implements RowMapper<ThongKe> {
    @Override
    public ThongKe mapRow(ResultSet rs, int rowNum) throws SQLException {
        ThongKe tk = new ThongKe();
        HangHoa hangHoa = new HangHoa();
        hangHoa.setID(rs.getString("MAHH"));
        hangHoa.setTen(rs.getString("Ten"));
        ChiTietPhieu ct = new ChiTietPhieu();
        ct.setSoLuong(rs.getInt("SoLuong"));
        ct.setDonGia((long)rs.getDouble("DonGia"));
        ct.setThanhTien((long)rs.getDouble("ThanhTien"));
        tk.setHangHoah(hangHoa);
        tk.setChiTietPhieu(ct);
        return tk;
    }
}
