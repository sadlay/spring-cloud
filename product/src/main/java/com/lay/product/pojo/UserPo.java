package com.lay.product.pojo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 16:31 2018/11/26
 * @Modified By:IntelliJ IDEA
 */
public class UserPo implements Serializable {

    private static final long serialVersionUID = 6984412951642658165L;

    private Long id;
    private String userName;
    //1-白银会员，2-黄金会员，3-钻石会员
    private int level;
    private String note;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
