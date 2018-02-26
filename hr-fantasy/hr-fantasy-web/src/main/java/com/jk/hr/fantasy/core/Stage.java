package com.jk.hr.fantasy.core;

import org.joda.time.DateTime;

import java.util.List;
import java.util.Objects;

public class Stage {

    private String name;

    private DateTime date;

    private List<Race> races;

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

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return Objects.equals(name, stage.name) &&
                Objects.equals(date, stage.date) &&
                Objects.equals(races, stage.races);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, date, races);
    }

    @Override
    public String toString() {
        return "Stage{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", races=" + races +
                '}';
    }
}
