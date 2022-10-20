package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;
import com.khomaytinh.quanlykhomaytinh.Model.Chuot;

import java.util.List;

public interface ChuotService {
    int insert(Chuot hh);

    int update(Chuot hh);

    List<Chuot> showList();

    int showDetail(String id);

    int delete(int id);
}
