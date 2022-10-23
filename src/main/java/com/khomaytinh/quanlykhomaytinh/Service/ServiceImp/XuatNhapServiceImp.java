package com.khomaytinh.quanlykhomaytinh.Service.ServiceImp;

import com.khomaytinh.quanlykhomaytinh.Dao.XuatNhapDao;
import com.khomaytinh.quanlykhomaytinh.Model.Accounts;
import com.khomaytinh.quanlykhomaytinh.Model.ChiTietPhieu;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.PhieuXuatNhap;
import com.khomaytinh.quanlykhomaytinh.Service.LoginService;
import com.khomaytinh.quanlykhomaytinh.Service.XuatNhapServiec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class XuatNhapServiceImp implements XuatNhapServiec {
    @Autowired
    LoginService loginService;
    @Autowired
    XuatNhapDao xuatNhapDao;
    @Override
    public int insertPhieu(PhieuXuatNhap p) {
        return xuatNhapDao.insertPhieu(p);
    }

    @Override
    public int updatePhieu(PhieuXuatNhap p) {
        List<ChiTietPhieu> list = new ArrayList<>();
        for(ChiTietPhieu ct : p.getChiTietPhieus()){
            ct.setHangHoa(showDetailHH(ct.getIdHangHoa()));
            list.add(ct);
        }
        p.setChiTietPhieus(list);

        return xuatNhapDao.updatePhieu(p);
    }

    @Override
    public int updateTrangThaiPhieu(Boolean p) {
        return 0;
    }

    @Override
    public int deletePhieu(String id) {
        return xuatNhapDao.deletePhieu(id);
    }

    @Override
    public List<PhieuXuatNhap> showList(String loai) {
        return xuatNhapDao.showList(loai);
    }

    @Override
    public PhieuXuatNhap showDetailPhieu(String id) {
        PhieuXuatNhap phieuXuatNhap = xuatNhapDao.showDetailPhieu(id);
        if(phieuXuatNhap==null) return null;
        phieuXuatNhap.setAccounts(loginService.CheckUserName(phieuXuatNhap.getAccounts().getUserName()));
        List<ChiTietPhieu> list = new ArrayList<>();
        for(ChiTietPhieu ct : phieuXuatNhap.getChiTietPhieus()){
            ct.setHangHoa(showDetailHH(ct.getHangHoa().getID()));
            list.add(ct);
        }
        phieuXuatNhap.setChiTietPhieus(list);
        return phieuXuatNhap;
    }

    @Override
    public List<HangHoa> load_List_HH( String loai) {
        return xuatNhapDao.load_List_HH(loai);
    }

    @Override
    public List<HangHoa> search_hh(String loai, String key) {
        return xuatNhapDao.search_hh(loai,key);
    }

    @Override
    public HangHoa showDetailHH(String maHH) {
        return xuatNhapDao
                .showDetailHH(maHH);
    }
}
