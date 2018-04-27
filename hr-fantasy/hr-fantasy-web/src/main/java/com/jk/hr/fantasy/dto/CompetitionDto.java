package com.jk.hr.fantasy.dto;

public class CompetitionDto {

    private String name;

    private boolean entered;

    private int entrants;

    private String comments;

    private String position;

    public CompetitionDto() {
    }

    public CompetitionDto(String name) {
        this.name = name;
    }

    public boolean isEntered() {
        return entered;
    }

    public void setEntered(boolean entered) {
        this.entered = entered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEntrants() {
        return entrants;
    }

    public void setEntrants(int entrants) {
        this.entrants = entrants;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
