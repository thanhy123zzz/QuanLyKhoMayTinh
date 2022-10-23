package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.PC;

import java.io.IOException;
import java.util.List;

public interface PcService {
    int insert(PC hh) throws IOException;

    int update(PC hh) throws IOException;

    List<PC> showList(int limit, int xapsep);

    PC showDetail(String id);

    int delete(String id);
    HangHoa check_id(String id);
}
