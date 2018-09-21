package com.open.javabean;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/21
 * @ Description：
 * @ throws
 */
public class Record {
    private int id;
    private String account;
    private String password;
    private String des;
    private String company;

    public Record() {
    }

    public Record(int id, String account, String password, String des, String company) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.des = des;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
