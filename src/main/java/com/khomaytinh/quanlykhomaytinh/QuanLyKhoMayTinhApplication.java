package com.khomaytinh.quanlykhomaytinh;

import com.khomaytinh.quanlykhomaytinh.Model.PC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication(scanBasePackages = "com.khomaytinh.quanlykhomaytinh")
public class QuanLyKhoMayTinhApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuanLyKhoMayTinhApplication.class, args);
    }

}
