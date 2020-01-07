package com.jtzh.vo.dispute;

import javax.persistence.Column;

public class DisputePeopleVO {

    private     String no;

    @Column
    private  String name;

    @Override
    public String toString() {
        return "DisputePeopleVO{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public String getNo() {
        return no;
    }

    public void setNo(String  no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
