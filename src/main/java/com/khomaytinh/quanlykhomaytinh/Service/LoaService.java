package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.Loa;



import java.io.IOException;
import java.util.List;

public interface LoaService {
    int insert(Loa hh) throws IOException;

    int update(Loa hh) throws IOException;

    List<Loa> showList(int limit, int xapsep);

    Loa showDetail(String id);

    int delete(String id);
    HangHoa check_id(String id);
}
