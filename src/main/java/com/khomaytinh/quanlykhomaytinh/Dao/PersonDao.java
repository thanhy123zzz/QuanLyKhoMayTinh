package com.khomaytinh.quanlykhomaytinh.Dao;

import com.khomaytinh.quanlykhomaytinh.Model.Admin;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.ThuKho;

import java.util.List;

public interface PersonDao {
    Admin showAdmin(String userName);
    int insertAdmin(Admin admin);
    int updateAdmin(Admin admin);

    int insertThuKho(ThuKho thuKho);
    int updateThuKho(ThuKho thuKho);
    int updateThuKho1(ThuKho thuKho);
    int deleteThuKho(String idNV);
    ThuKho showThuKho(String userName);
    ThuKho showThuKho1(String userName);
    List<ThuKho> showListThuKho();
    ThuKho check_id(String id);
}
