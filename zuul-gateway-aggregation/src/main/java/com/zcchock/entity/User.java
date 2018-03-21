
package com.zcchock.entity;

import java.util.Date;

public class User {

    private String id;
    private String sex;
    private String name;
    private Long tall;
    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTall() {
        return tall;
    }

    public void setTall(Long tall) {
        this.tall = tall;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}