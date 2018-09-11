package com.open.javabean;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/9/11
 * @ Description：
 * @ throws
 */
public class User {
    private Integer id;
    private String tel;
    private String name;
    private String password;

    public User() {
    }

    public User(Integer id, String tel, String name, String password) {
        this.id = id;
        this.tel = tel;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

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
        return "User{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
