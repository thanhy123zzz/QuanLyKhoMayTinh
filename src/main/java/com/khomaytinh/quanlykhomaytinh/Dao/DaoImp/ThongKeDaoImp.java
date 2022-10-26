package com.khomaytinh.quanlykhomaytinh.Dao.DaoImp;

import com.khomaytinh.quanlykhomaytinh.Dao.ThongKeDao;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.ThongKeMapper;
import com.khomaytinh.quanlykhomaytinh.Model.ThongKe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThongKeDaoImp implements ThongKeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<ThongKe> showNgay() {
        String q = "select*from ThongTinNgayNhap;";
        return jdbcTemplate.query(q,new ThongKeMapper());
    }

    @Override
    public List<ThongKe> showThang() {
        String q = "SELECT * FROM quanlykhomaytinh.thongtinthangnhap;";
        List<ThongKe> list = jdbcTemplate.query(q,new ThongKeMapper());
        return list;
    }
}
