package com.khomaytinh.quanlykhomaytinh.Dao.DaoImp;

import com.khomaytinh.quanlykhomaytinh.Dao.AccountDao;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.AccountMapper;
import com.khomaytinh.quanlykhomaytinh.Model.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountImp implements AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Boolean CheckAccount(Accounts accounts) {
        return null;
    }

    @Override
    public Accounts CheckUserName(String userName) {
        String query = "select*from account where UserName ='"+userName+"'";
        List<Accounts> list = jdbcTemplate.query(query,new AccountMapper());
        if(list.size()==0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int insertAccount(Accounts accounts) {
        return 0;
    }

    @Override
    public int updateAccount(Accounts accounts) {
        return 0;
    }

    @Override
    public int XoaAccount(String userName) {
        return 0;
    }
}
