package com.jk.hr.fantasy.core;

import java.util.List;
import java.util.Objects;

public class Entry implements Keyed {

    public String userName;

    public String competition;

    public String stage;

    public List<Selection> selections;

    @Override
    public String key() {
        return competition + "-" + stage + "-" + userName;
    }

    public List<Selection> getSelections() {
        return selections;
    }

    public void setSelections(List<Selection> selections) {
        this.selections = selections;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(competition, entry.competition) &&
                Objects.equals(stage, entry.stage) &&
                Objects.equals(selections, entry.selections);
    }

    @Override
    public int hashCode() {

        return Objects.hash(competition, stage, selections);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "competition='" + competition + '\'' +
                ", stage='" + stage + '\'' +
                ", selections=" + selections +
                '}';
    }
}
