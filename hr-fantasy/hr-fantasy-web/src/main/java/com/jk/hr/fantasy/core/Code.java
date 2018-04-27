package com.jk.hr.fantasy.core;

public class Code implements Keyed {

    private String code;

    public Code() {
    }

    public Code(String code) {
        this.code = code;
    }

    @Override
    public String key() {
        return code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
