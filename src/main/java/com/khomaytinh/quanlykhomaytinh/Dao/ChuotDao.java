package com.khomaytinh.quanlykhomaytinh.Dao;

import com.khomaytinh.quanlykhomaytinh.Model.Chuot;


import java.io.IOException;
import java.util.List;

public interface ChuotDao {
    int insert(Chuot hh) throws IOException;

    int update(Chuot hh) throws IOException;

    List<Chuot> showList(int limit, int xapsep);

    Chuot showDetail(String id);

    int delete(String id);

}
