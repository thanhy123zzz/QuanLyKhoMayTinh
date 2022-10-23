package com.khomaytinh.quanlykhomaytinh.Service.ServiceImp;

import com.khomaytinh.quanlykhomaytinh.Dao.TaiNgheDao;

import com.khomaytinh.quanlykhomaytinh.Model.TaiNghe;
import com.khomaytinh.quanlykhomaytinh.Service.TaiNgheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TaiNgheServiceImp implements TaiNgheService {
    @Autowired
    TaiNgheDao TaiNgheDao;
    @Override
    public int insert(TaiNghe a) throws IOException {
        return TaiNgheDao.insert(a);
    }

    @Override
    public int update(TaiNghe hh) throws IOException {
        return TaiNgheDao.update(hh);
    }

    @Override
    public List<TaiNghe> showList(int limit, int xapsep) {
        return TaiNgheDao.showList(limit,xapsep);
    }

    @Override
    public TaiNghe showDetail(String id) {
        return TaiNgheDao.showDetail(id);
    }

    @Override
    public int delete(String id) {
        return TaiNgheDao.delete(id);
    }
}
