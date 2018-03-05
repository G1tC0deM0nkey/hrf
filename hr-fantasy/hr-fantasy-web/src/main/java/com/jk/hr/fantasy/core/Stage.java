package com.jk.hr.fantasy.core;

import org.joda.time.DateTime;

import java.util.List;
import java.util.Objects;

public class Stage implements Keyed {

    private String competition;

    private String name;

    private DateTime date;

    private List<String> races;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public List<String> getRaces() {
        return races;
    }

    public void setRaces(List<String> races) {
        this.races = races;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    @Override
    public String key() {
        return competition + "-" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return Objects.equals(competition, stage.competition) &&
                Objects.equals(name, stage.name) &&
                Objects.equals(date, stage.date) &&
                Objects.equals(races, stage.races);
    }

    @Override
    public int hashCode() {

        return Objects.hash(competition, name, date, races);
    }

    @Override
    public String toString() {
        return "Stage{" +
                "competition='" + competition + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", races=" + races +
                '}';
    }
}
