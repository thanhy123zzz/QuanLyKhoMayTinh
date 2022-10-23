package com.khomaytinh.quanlykhomaytinh.Dao;

import com.khomaytinh.quanlykhomaytinh.Model.PC;



import java.io.IOException;
import java.util.List;

public interface PCDao {
    int insert(PC hh) throws IOException;

    int update(PC hh) throws IOException;

    List<PC> showList(int limit, int xapsep);

    PC showDetail(String id);

    int delete(String id);

}
