package com.khomaytinh.quanlykhomaytinh.Service.ServiceImp;

import com.khomaytinh.quanlykhomaytinh.Dao.ThongKeDao;
import com.khomaytinh.quanlykhomaytinh.Model.ThongKe;
import com.khomaytinh.quanlykhomaytinh.Service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThongKeServiceImp implements ThongKeService {
    @Autowired
    ThongKeDao thongKeDao;
    @Override
    public List<ThongKe> showNgay() {
        return thongKeDao.showNgay();
    }

    @Override
    public List<ThongKe> showThang() {
        return thongKeDao.showThang();
    }
}
