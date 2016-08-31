package com.bean;

/**
 * Created by zhouweitao on 16/8/31.
 */
public class User {

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    /**
     * id : 9995
     * name : Illiana Santana
     * phone : 070-917-5092
     * email : eu.metus@aarcuSed.co.uk
     * birthday : 08/05/2007
     */

    private int id;
    private String name;
    private String phone;
    private String email;
    private String birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
