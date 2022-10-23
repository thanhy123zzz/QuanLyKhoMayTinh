package com.khomaytinh.quanlykhomaytinh.Dao.DaoImp;

import com.khomaytinh.quanlykhomaytinh.Dao.PersonDao;
import com.khomaytinh.quanlykhomaytinh.Model.Accounts;
import com.khomaytinh.quanlykhomaytinh.Model.Admin;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.AccountMapper;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.AdminMapper;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.HangHoaMapper;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.LapTopMapper;
import com.khomaytinh.quanlykhomaytinh.Model.Mapper.ThuKhoMapper;
import com.khomaytinh.quanlykhomaytinh.Model.ThuKho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PersonDaoImp implements PersonDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Admin showAdmin(String userName) {
        String query = "select*from quanly where UserName='"+userName+"'";
        List<Admin> listAdmin = jdbcTemplate.query(query,new AdminMapper());
        return listAdmin.get(0);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) {
        String query = "update quanly set TenQL=?,NgaySinh=?,GioiTinh=?,CCCD=?,SDT=? where UserName = ?";
        return jdbcTemplate.update(query,new Object[]{admin.getTen(), admin.getNgaySinh(),admin.getGioiTinh(),admin.getCCCD(),admin.getSoDT(),admin.getTaiKhoan().getUserName()});

    }

    @Override
    public int insertThuKho(ThuKho tk) {
    	String querytk = "INSERT INTO `quanlykhomaytinh`.`account` " +
                "(`username`, `password`, `marl`) VALUES (?,?,?);";
        int kq1= jdbcTemplate.update(querytk,new Object[]{tk.getTaiKhoan().getUserName(),tk.getTaiKhoan().getPassword(),tk.getTaiKhoan().getRole().getMaRL()});

        String querytk1 = "insert into thukho(`matk`,`username`) values(?,?)";
        int kq2 = jdbcTemplate.update(querytk1,new Object[]{tk.getID(),tk.getTaiKhoan().getUserName()});
        return kq1+kq2;
        
    }

    @Override
    public int updateThuKho(ThuKho admin) {
        String query = "update thukho set TenTK=?,NgaySinh=?,GioiTinh=?,CCCD=?,SDT=? where UserName = ?";
        return jdbcTemplate.update(query,new Object[]{admin.getTen(), admin.getNgaySinh(),admin.getGioiTinh(),admin.getCCCD(),admin.getSoDT(),admin.getTaiKhoan().getUserName()});

    }
    public int updateThuKho1(ThuKho admin) {
        String query = "update thukho set sotientrengio=? where matk = ?";
        return jdbcTemplate.update(query,new Object[]{ admin.getSoTienTrenGio(),admin.getID()});

    }

    @Override
    public int deleteThuKho(String idNV) {
        String userName = showThuKho1(idNV).getTaiKhoan().getUserName();
        String query2 = "delete from thukho where matk='"+idNV+"'";
        int kq = jdbcTemplate.update(query2);

        String query = "delete from account where UserName ='"+userName+"'";
        jdbcTemplate.update(query);
        return kq;
    }
    public int delete(String id) {
        String query = "delete from account where UserName ='"+showThuKho1(id).getTaiKhoan().getUserName()+"'";
        jdbcTemplate.update(query);
        String query2 = "delete from thukho where matk='"+id+"'";
        int kq = jdbcTemplate.update(query2);
        return kq;
    }

    @Override
    public ThuKho showThuKho(String userName) {
        String query = "select*from thukho where UserName='"+userName+"'";
        List<ThuKho> listAdmin = jdbcTemplate.query(query,new ThuKhoMapper());
        return listAdmin.get(0);
    }
    public ThuKho showThuKho1(String id) {
        String query = "select*from thukho where matk='"+id+"'";
        List<ThuKho> listAdmin = jdbcTemplate.query(query,new ThuKhoMapper());
        return listAdmin.get(0);
    }

    @Override
    public List<ThuKho> showListThuKho() {
    	String query="select * from thukho";
    	 return jdbcTemplate.query(query,new ThuKhoMapper());
    }
    @Override
    public ThuKho check_id(String id) {
        String query = "select*from thukho where matk = '"+id+"'";
        if(jdbcTemplate.query(query,new ThuKhoMapper()).size()==0)
            return null;
        else return jdbcTemplate.query(query,new ThuKhoMapper()).get(0);
    }
}
