package com.prontoitlabs.customexception.dto;

import java.io.Serializable;

/**
 * @version 1.0, 01-Jul-2015
 * @author giridhar
 */
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 897407329371436876L;

    private String            userName;

    private String            password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
