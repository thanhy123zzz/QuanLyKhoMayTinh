package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;

import java.util.List;

public interface TaiNgheService {
    int insert(BanPhim hh);

    int update(BanPhim hh);

    List<BanPhim> showList();

    int showDetail(String id);

    int delete(int id);
}
