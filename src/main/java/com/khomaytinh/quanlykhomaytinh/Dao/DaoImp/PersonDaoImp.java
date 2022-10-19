package com.khomaytinh.quanlykhomaytinh.Dao.DaoImp;

import com.khomaytinh.quanlykhomaytinh.Dao.PersonDao;
import com.khomaytinh.quanlykhomaytinh.Model.Admin;
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
    public Admin showAdmin() {
        String query = "select*from quanly";

        return null;
    }

    @Override
    public int insertAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int insertThuKho(ThuKho thuKho) {
        return 0;
    }

    @Override
    public int updateThuKho(ThuKho thuKho) {
        return 0;
    }

    @Override
    public int deleteThuKho(String idNV) {
        return 0;
    }

    @Override
    public ThuKho showThuKho(String idThuKho) {
        return null;
    }

    @Override
    public List<ThuKho> showListThuKho() {
        return null;
    }
}
