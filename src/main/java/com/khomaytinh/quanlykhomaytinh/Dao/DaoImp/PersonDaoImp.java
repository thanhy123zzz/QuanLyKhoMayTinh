package com.khomaytinh.quanlykhomaytinh.Dao.DaoImp;

import com.khomaytinh.quanlykhomaytinh.Dao.PersonDao;
import com.khomaytinh.quanlykhomaytinh.Model.Accounts;
import com.khomaytinh.quanlykhomaytinh.Model.Admin;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.AccountMapper;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.AdminMapper;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.ThuKhoMapper;
import com.khomaytinh.quanlykhomaytinh.Model.ThuKho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PersonDaoImp implements PersonDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Admin showAdmin(String userName) {
        String query = "select*from quanly where UserName='"+userName+"'";
        List<Admin> listAdmin = jdbcTemplate.query(query,new AdminMapper());
        return listAdmin.get(0);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) {
        String query = "update quanly set TenQL=?,NgaySinh=?,GioiTinh=?,CCCD=?,SDT=? where UserName = ?";
        return jdbcTemplate.update(query,new Object[]{admin.getTen(), admin.getNgaySinh(),admin.getGioiTinh(),admin.getCCCD(),admin.getSoDT(),admin.getTaiKhoan().getUserName()});

    }

    @Override
    public int insertThuKho(ThuKho thuKho) {
        return 0;
    }

    @Override
    public int updateThuKho(ThuKho admin) {
        String query = "update thukho set TenTK=?,NgaySinh=?,GioiTinh=?,CCCD=?,SDT=? where UserName = ?";
        return jdbcTemplate.update(query,new Object[]{admin.getTen(), admin.getNgaySinh(),admin.getGioiTinh(),admin.getCCCD(),admin.getSoDT(),admin.getTaiKhoan().getUserName()});

    }

    @Override
    public int deleteThuKho(String idNV) {
        return 0;
    }

    @Override
    public ThuKho showThuKho(String userName) {
        String query = "select*from thukho where UserName='"+userName+"'";
        List<ThuKho> listAdmin = jdbcTemplate.query(query,new ThuKhoMapper());
        return listAdmin.get(0);
    }

    @Override
    public List<ThuKho> showListThuKho() {
        return null;
    }
}
