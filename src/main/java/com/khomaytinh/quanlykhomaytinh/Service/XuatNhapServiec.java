package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.PhieuXuatNhap;

import java.util.List;

public interface XuatNhapServiec {
    int insertPhieu(PhieuXuatNhap p);
    int updatePhieu(PhieuXuatNhap p);
    int updateTrangThaiPhieu(Boolean p);

    int deletePhieu(int id);

    List<PhieuXuatNhap> showList();
    PhieuXuatNhap showDetailPhieu(String id);

}
