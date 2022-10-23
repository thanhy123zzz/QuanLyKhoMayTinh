package com.khomaytinh.quanlykhomaytinh.Service.ServiceImp;


import com.khomaytinh.quanlykhomaytinh.Dao.PCDao;
import com.khomaytinh.quanlykhomaytinh.Model.PC;
import com.khomaytinh.quanlykhomaytinh.Service.PcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PCServiceImp implements PcService {
    @Autowired
    PCDao PCDao;
    @Override
    public int insert(PC a) throws IOException {
        return PCDao.insert(a);
    }

    @Override
    public int update(PC hh) throws IOException {
        return PCDao.update(hh);
    }

    @Override
    public List<PC> showList(int limit, int xapsep) {
        return PCDao.showList(limit,xapsep);
    }

    @Override
    public PC showDetail(String id) {
        return PCDao.showDetail(id);
    }

    @Override
    public int delete(String id) {
        return PCDao.delete(id);
    }
}
