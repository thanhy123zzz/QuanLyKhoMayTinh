package com.khomaytinh.quanlykhomaytinh.Controller;

import com.khomaytinh.quanlykhomaytinh.Service.LapTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

public class Common {
    ModelAndView mv = new ModelAndView();

    @Autowired
    LapTopService hangHoaService;
}
