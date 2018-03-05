package com.jk.hr.fantasy.core;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Entry implements Keyed {

    public String userName;

    public String competitionName;

    public String stage;

    public Map<String, Selection> selections;

    @Override
    public String key() {
        return competitionName + "-" + stage + "-" + userName;
    }

    public Map<String, Selection> getSelections() {
        return selections;
    }

    public void setSelections(Map<String, Selection> selections) {
        this.selections = selections;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competition) {
        this.competitionName = competition;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(userName, entry.userName) &&
                Objects.equals(competitionName, entry.competitionName) &&
                Objects.equals(stage, entry.stage) &&
                Objects.equals(selections, entry.selections);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, competitionName, stage, selections);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "userName='" + userName + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", stage='" + stage + '\'' +
                ", selections=" + selections +
                '}';
    }
}
