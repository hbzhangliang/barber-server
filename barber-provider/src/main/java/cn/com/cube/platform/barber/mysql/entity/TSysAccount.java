package cn.com.cube.platform.barber.mysql.entity;

import java.util.Date;

public class TSysAccount extends BaseEntity{

    private String name;

    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TSysAccount{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}