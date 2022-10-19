package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.Laptop;

import java.util.List;

public interface LapTopService {
    int insert(Laptop hh);

    int update(Laptop hh);

    List<Laptop> showList();

    int showDetail(int id);

    int delete(int id);
}
