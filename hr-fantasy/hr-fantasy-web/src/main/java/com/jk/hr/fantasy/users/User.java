package com.jk.hr.fantasy.users;

import com.jk.hr.fantasy.core.Keyed;

import java.util.Objects;

public class User implements Keyed {

    private String userName;

    private String name;

    private String email;

    private String pin;

    private boolean admin;

    @Override
    public String key() {
        return userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return admin == user.admin &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(pin, user.pin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, name, email, pin, admin);
    }

    @Override
    public String toString() {
        return "setUserName{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pin='" + pin + '\'' +
                ", admin=" + admin +
                '}';
    }
}

