package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.Admin;
import com.khomaytinh.quanlykhomaytinh.Model.ThuKho;

import java.util.List;

public interface PersonService {
    Admin showAdmin();
    int insertAdmin(Admin admin);
    int updateAdmin(Admin admin);

    int insertThuKho(ThuKho thuKho);
    int updateThuKho(ThuKho thuKho);
    int deleteThuKho(String idNV);
    ThuKho showThuKho(String idThuKho);
    List<ThuKho> showListThuKho();
}
