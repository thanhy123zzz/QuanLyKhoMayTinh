package com.khomaytinh.quanlykhomaytinh.Dao;

import com.khomaytinh.quanlykhomaytinh.Model.ThongKe;

import java.util.List;

public interface ThongKeDao {
    List<ThongKe> showNgay();
    List<ThongKe> showThang();
}
