package com.khomaytinh.quanlykhomaytinh.Dao;

import java.io.IOException;


import java.util.List;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;

public interface BanphimDao {
	int insert(BanPhim hh) throws IOException;

    int update(BanPhim hh) throws IOException;

    List<BanPhim> showList(int limit, int xapsep);

    BanPhim showDetail(String id);

    int delete(String id);
    
    HangHoa check_id(String id);

}
