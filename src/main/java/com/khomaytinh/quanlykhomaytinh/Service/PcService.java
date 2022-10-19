package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;
import com.khomaytinh.quanlykhomaytinh.Model.PC;

import java.util.List;

public interface PcService {
    int insert(PC hh);

    int update(PC hh);

    List<PC> showList();

    int showDetail(int id);

    int delete(int id);
}
