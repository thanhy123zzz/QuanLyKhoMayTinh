package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.Laptop;



import java.io.IOException;
import java.util.List;

public interface LapTopService {
    int insert(Laptop hh) throws IOException;

    int update(Laptop hh) throws IOException;

    List<Laptop> showList(int limit, int xapsep);

    Laptop showDetail(String id);

    int delete(String id);
    HangHoa check_id(String id);
}
