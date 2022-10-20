package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;
import com.khomaytinh.quanlykhomaytinh.Model.Laptop;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BanPhimService{
    int insert(BanPhim hh);

    int update(BanPhim hh);

    List<BanPhim> showList();

    int showDetail(String id);

    int delete(int id);
}
