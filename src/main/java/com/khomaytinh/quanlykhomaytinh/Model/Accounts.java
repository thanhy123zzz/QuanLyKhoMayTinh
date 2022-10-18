package com.khomaytinh.quanlykhomaytinh.Model;

public class Accounts {
private String userName;
private String passWord;
private Role role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Accounts(String userName) {
        this.userName = userName;
    }
    public Accounts() {

    }
}
