package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.Accounts;
import com.khomaytinh.quanlykhomaytinh.Model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Accounts> {
    @Override
    public Accounts mapRow(ResultSet rs, int rowNum) throws SQLException {
        Accounts ac = new Accounts();
        ac.setUserName(rs.getString("UserName"));
        ac.setPassword(rs.getString("PassWord"));
        ac.setRole(new Role(rs.getString("MaRL")));
        return ac;
    }
}
