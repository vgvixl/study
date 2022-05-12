package com.company.netWorkTCP;

import java.io.Serializable;

/**
 * @Auther: zzx
 * @Date: 2022.05.22/5/12
 */
public class password implements Serializable {
    String user;
    String pwd;

    @Override
    public String toString() {
        return "password{" +
                "user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
