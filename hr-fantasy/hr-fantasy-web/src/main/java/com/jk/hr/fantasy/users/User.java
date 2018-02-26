package com.jk.hr.fantasy.users;

import com.jk.hr.fantasy.core.Keyed;

import java.util.Objects;

public class User implements Keyed {

    private String userName;

    private String name;

    private String email;

    private String hash;

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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(hash, user.hash);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, name, email, hash);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
