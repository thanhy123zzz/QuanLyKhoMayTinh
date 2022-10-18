package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.Accounts;

public interface LoginService {
    Boolean CheckAccount(Accounts accounts);

    Accounts CheckUserName(String userName);

    int insertAccount(Accounts accounts);

    int updateAccount(Accounts accounts);

    int XoaAccount(String userName);
}
