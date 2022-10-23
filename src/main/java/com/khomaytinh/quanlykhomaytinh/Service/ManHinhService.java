package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.ManHinh;



import java.io.IOException;
import java.util.List;

public interface ManHinhService {
    int insert(ManHinh hh) throws IOException;

    int update(ManHinh hh) throws IOException;

    List<ManHinh> showList(int limit, int xapsep);

    ManHinh showDetail(String id);

    int delete(String id);
    HangHoa check_id(String id);
}
