package com.jk.hr.fantasy.core;

import java.util.List;
import java.util.Objects;

public class Race implements Keyed {

    private String competition;

    private String stage;

    private String name;

    private String displayName;

    private String rules;

    private int placesPaid;

    private double placesPayout;

    private List<Runner> runners;

    @Override
    public String key() {
        return competition + "-" + stage + "-" + name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public int getPlacesPaid() {
        return placesPaid;
    }

    public void setPlacesPaid(int placesPaid) {
        this.placesPaid = placesPaid;
    }

    public double getPlacesPayout() {
        return placesPayout;
    }

    public void setPlacesPayout(double placesPayout) {
        this.placesPayout = placesPayout;
    }

    public List<Runner> getRunners() {
        return runners;
    }

    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return placesPaid == race.placesPaid &&
                Double.compare(race.placesPayout, placesPayout) == 0 &&
                Objects.equals(name, race.name) &&
                Objects.equals(displayName, race.displayName) &&
                Objects.equals(rules, race.rules) &&
                Objects.equals(runners, race.runners);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, displayName, rules, placesPaid, placesPayout, runners);
    }

    @Override
    public String toString() {
        return "Race{" +
                "name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", rules='" + rules + '\'' +
                ", placesPaid=" + placesPaid +
                ", placesPayout=" + placesPayout +
                ", runners=" + runners +
                '}';
    }
}
