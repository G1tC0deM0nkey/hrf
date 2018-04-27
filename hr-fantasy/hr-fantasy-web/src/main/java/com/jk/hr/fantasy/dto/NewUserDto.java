package com.jk.hr.fantasy.dto;

public class NewUserDto {

    String userName;

    String displayName;

    String email;

    String pin;

    String pinConfirm;

    String code;

    public NewUserDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPinConfirm() {
        return pinConfirm;
    }

    public void setPinConfirm(String pinConfirm) {
        this.pinConfirm = pinConfirm;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
