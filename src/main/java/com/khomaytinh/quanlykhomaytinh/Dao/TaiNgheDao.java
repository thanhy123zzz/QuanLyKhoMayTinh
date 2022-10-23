package com.khomaytinh.quanlykhomaytinh.Dao;

import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.TaiNghe;



import java.io.IOException;
import java.util.List;

public interface TaiNgheDao {
    int insert(TaiNghe hh) throws IOException;

    int update(TaiNghe hh) throws IOException;

    List<TaiNghe> showList(int limit, int xapsep);

    TaiNghe showDetail(String id);

    int delete(String id);
    HangHoa check_id(String id);

}
