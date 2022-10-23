package com.khomaytinh.quanlykhomaytinh.Service.ServiceImp;

import com.khomaytinh.quanlykhomaytinh.Dao.ChuotDao;
import com.khomaytinh.quanlykhomaytinh.Model.Chuot;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Service.ChuotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ChuotServiceImp implements ChuotService {
    @Autowired
    ChuotDao ChuotDao;
    @Override
    public int insert(Chuot a) throws IOException {
        return ChuotDao.insert(a);
    }

    @Override
    public int update(Chuot hh) throws IOException {
        return ChuotDao.update(hh);
    }

    @Override
    public List<Chuot> showList(int limit, int xapsep) {
        return ChuotDao.showList(limit,xapsep);
    }

    @Override
    public Chuot showDetail(String id) {
        return ChuotDao.showDetail(id);
    }

    @Override
    public int delete(String id) {
        return ChuotDao.delete(id);
    }
    @Override
    public HangHoa check_id(String id) {
        return ChuotDao.check_id(id);
    }
}
