package com.khomaytinh.quanlykhomaytinh.Dao;

import com.khomaytinh.quanlykhomaytinh.Model.Accounts;

public interface AccountDao {
    Boolean CheckAccount(Accounts accounts);

    Accounts CheckUserName(String userName);

    int insertAccount(Accounts accounts);

    int updateAccount(Accounts accounts);

    int XoaAccount(String userName);
}
