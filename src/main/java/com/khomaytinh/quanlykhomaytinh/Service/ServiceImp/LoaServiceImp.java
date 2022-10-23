package com.khomaytinh.quanlykhomaytinh.Service.ServiceImp;

import com.khomaytinh.quanlykhomaytinh.Dao.LoaDao;

import com.khomaytinh.quanlykhomaytinh.Model.Loa;
import com.khomaytinh.quanlykhomaytinh.Service.LoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LoaServiceImp implements LoaService {
    @Autowired
    LoaDao LoaDao;
    @Override
    public int insert(Loa a) throws IOException {
        return LoaDao.insert(a);
    }

    @Override
    public int update(Loa hh) throws IOException {
        return LoaDao.update(hh);
    }

    @Override
    public List<Loa> showList(int limit, int xapsep) {
        return LoaDao.showList(limit,xapsep);
    }

    @Override
    public Loa showDetail(String id) {
        return LoaDao.showDetail(id);
    }

    @Override
    public int delete(String id) {
        return LoaDao.delete(id);
    }
}
