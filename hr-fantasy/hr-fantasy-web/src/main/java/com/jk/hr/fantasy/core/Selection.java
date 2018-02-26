package com.jk.hr.fantasy.core;

import java.util.Objects;

public class Selection {

    private String raceName;

    private String runnerName;

    private boolean nap;

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public boolean isNap() {
        return nap;
    }

    public void setNap(boolean nap) {
        this.nap = nap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Selection selection = (Selection) o;
        return nap == selection.nap &&
                Objects.equals(raceName, selection.raceName) &&
                Objects.equals(runnerName, selection.runnerName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(raceName, runnerName, nap);
    }

    @Override
    public String toString() {
        return "Selection{" +
                "raceName='" + raceName + '\'' +
                ", runnerName='" + runnerName + '\'' +
                ", nap=" + nap +
                '}';
    }
}
