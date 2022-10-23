package com.khomaytinh.quanlykhomaytinh.Service.ServiceImp;

import com.khomaytinh.quanlykhomaytinh.Dao.PersonDao;
import com.khomaytinh.quanlykhomaytinh.Model.Admin;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.ThuKho;
import com.khomaytinh.quanlykhomaytinh.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService {
    @Autowired
    PersonDao personDao;
    @Override
    public Admin showAdmin(String userName) {
        return personDao.showAdmin(userName);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) {
        return personDao.updateAdmin(admin);
    }

    @Override
    public int insertThuKho(ThuKho thukho) {
    	return personDao.insertThuKho(thukho);
    }

    @Override
    public int updateThuKho(ThuKho thuKho) {
        return personDao.updateThuKho(thuKho);
    }
    @Override
    public int updateThuKho1(ThuKho thuKho) {
        return personDao.updateThuKho1(thuKho);
    }

    @Override
    public int deleteThuKho(String idNV) {
    	 return personDao.deleteThuKho(idNV);
    }

    @Override
    public ThuKho showThuKho(String userName) {
        return personDao.showThuKho(userName);
    }
    @Override
    public ThuKho showThuKho1(String id) {
        return personDao.showThuKho1(id);
    }
    @Override
    public List<ThuKho> showListThuKho() {
        return personDao.showListThuKho() ;
    }
    @Override
    public ThuKho check_id(String id) {
        return personDao.check_id(id);
    }
}
