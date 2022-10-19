package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;

import java.util.List;

public interface ManHinhService {
    int insert(BanPhim hh);

    int update(BanPhim hh);

    List<BanPhim> showList();

    int showDetail(int id);

    int delete(int id);
}
