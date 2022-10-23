package com.khomaytinh.quanlykhomaytinh.Service;

import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.PhieuXuatNhap;

import java.util.List;

public interface XuatNhapServiec {
    int insertPhieu(PhieuXuatNhap p);
    int updatePhieu(PhieuXuatNhap p);
    int updateTrangThaiPhieu(Boolean p);
    int deletePhieu(String id);

    List<PhieuXuatNhap> showList(String loai);
    PhieuXuatNhap showDetailPhieu(String id);

    List<HangHoa> load_List_HH( String loai);

    List<HangHoa> search_hh(String loai,String key);
    HangHoa showDetailHH(String maHH);
}
