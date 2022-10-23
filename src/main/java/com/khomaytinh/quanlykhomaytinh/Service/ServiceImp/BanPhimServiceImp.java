package com.khomaytinh.quanlykhomaytinh.Service.ServiceImp;

import com.khomaytinh.quanlykhomaytinh.Dao.BanphimDao;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;
import com.khomaytinh.quanlykhomaytinh.Service.BanPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BanPhimServiceImp implements BanPhimService {
    @Autowired
    BanphimDao BanphimDao;
    @Override
    public int insert(BanPhim a) throws IOException {
        return BanphimDao.insert(a);
    }

    @Override
    public int update(BanPhim hh) throws IOException {
        return BanphimDao.update(hh);
    }

    @Override
    public List<BanPhim> showList(int limit, int xapsep) {
        return BanphimDao.showList(limit,xapsep);
    }

    @Override
    public BanPhim showDetail(String id) {
        return BanphimDao.showDetail(id);
    }

    @Override
    public int delete(String id) {
        return BanphimDao.delete(id);
    }
}
