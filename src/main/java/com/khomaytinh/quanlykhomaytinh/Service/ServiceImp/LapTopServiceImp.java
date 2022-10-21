package com.khomaytinh.quanlykhomaytinh.Service.ServiceImp;

import com.khomaytinh.quanlykhomaytinh.Dao.LaptopDao;
import com.khomaytinh.quanlykhomaytinh.Model.Laptop;
import com.khomaytinh.quanlykhomaytinh.Service.LapTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LapTopServiceImp implements LapTopService {
    @Autowired
    LaptopDao laptopDao;
    @Override
    public int insert(Laptop a) throws IOException {
        return laptopDao.insert(a);
    }

    @Override
    public int update(Laptop hh) throws IOException {
        return laptopDao.update(hh);
    }

    @Override
    public List<Laptop> showList(int limit, int xapsep) {
        return laptopDao.showList(limit,xapsep);
    }

    @Override
    public Laptop showDetail(String id) {
        return laptopDao.showDetail(id);
    }

    @Override
    public int delete(String id) {
        return laptopDao.delete(id);
    }
}
