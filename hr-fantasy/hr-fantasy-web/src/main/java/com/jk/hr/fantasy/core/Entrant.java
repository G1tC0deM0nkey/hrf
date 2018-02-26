package com.jk.hr.fantasy.core;

import java.util.Objects;

public class Entrant implements Keyed {

    private String userName;

    private String competitionName;

    private boolean paid;

    @Override
    public String key() {
        return competitionName + "-" + userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrant entrant = (Entrant) o;
        return paid == entrant.paid &&
                Objects.equals(userName, entrant.userName) &&
                Objects.equals(competitionName, entrant.competitionName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, competitionName, paid);
    }

    @Override
    public String toString() {
        return "Entrant{" +
                "userName='" + userName + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", paid=" + paid +
                '}';
    }
}
