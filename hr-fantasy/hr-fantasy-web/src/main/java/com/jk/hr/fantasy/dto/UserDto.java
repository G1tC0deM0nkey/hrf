package com.jk.hr.fantasy.dto;

public class UserDto {

    String userName;

    String displayName;

    String email;

    String token;

    boolean admin;

    public UserDto() {
    }

    public UserDto(String userName, String displayName, String email, String token, boolean admin) {
        this.userName = userName;
        this.displayName = displayName;
        this.email = email;
        this.token = token;
        this.admin = admin;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
