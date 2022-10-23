package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;

import com.khomaytinh.quanlykhomaytinh.Model.Laptop;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface BanPhimService{
    int insert(BanPhim hh) throws IOException;

    int update(BanPhim hh) throws IOException;

    List<BanPhim> showList(int limit, int xapsep);

    BanPhim showDetail(String id);

    int delete(String id);
}
