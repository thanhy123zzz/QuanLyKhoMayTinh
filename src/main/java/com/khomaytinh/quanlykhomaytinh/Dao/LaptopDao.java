package com.khomaytinh.quanlykhomaytinh.Dao;

import com.khomaytinh.quanlykhomaytinh.Model.Laptop;



import java.io.IOException;
import java.util.List;

public interface LaptopDao {
    int insert(Laptop hh) throws IOException;

    int update(Laptop hh) throws IOException;

    List<Laptop> showList(int limit, int xapsep);

    Laptop showDetail(String id);

    int delete(String id);

}
