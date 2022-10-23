package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.Chuot;

import java.io.IOException;
import java.util.List;

public interface ChuotService {
    int insert(Chuot hh) throws IOException;

    int update(Chuot hh) throws IOException;

    List<Chuot> showList(int limit, int xapsep);

    Chuot showDetail(String id);

    int delete(String id);
}
