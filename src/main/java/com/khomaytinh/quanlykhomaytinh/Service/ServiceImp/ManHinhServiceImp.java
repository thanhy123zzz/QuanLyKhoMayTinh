package com.khomaytinh.quanlykhomaytinh.Service.ServiceImp;

import com.khomaytinh.quanlykhomaytinh.Dao.ManHinhDao;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.ManHinh;
import com.khomaytinh.quanlykhomaytinh.Service.ManHinhService;
import com.khomaytinh.quanlykhomaytinh.Service.ManHinhService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ManHinhServiceImp implements ManHinhService {
    @Autowired
    ManHinhDao ManHinhDao;
    @Override
    public int insert(ManHinh a) throws IOException {
        return ManHinhDao.insert(a);
    }

    @Override
    public int update(ManHinh hh) throws IOException {
        return ManHinhDao.update(hh);
    }

    @Override
    public List<ManHinh> showList(int limit, int xapsep) {
        return ManHinhDao.showList(limit,xapsep);
    }

    @Override
    public ManHinh showDetail(String id) {
        return ManHinhDao.showDetail(id);
    }
    @Override
    public int delete(String id) {
        return ManHinhDao.delete(id);
    }
    @Override
    public HangHoa check_id(String id) {
        return ManHinhDao.check_id(id);
    }
}
