package com.jk.hr.fantasy.core;

public class ActiveCompetition implements Keyed {

    private String name;

    @Override
    public String key() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
