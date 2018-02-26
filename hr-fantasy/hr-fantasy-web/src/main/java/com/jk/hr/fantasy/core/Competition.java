package com.jk.hr.fantasy.core;

import java.util.List;
import java.util.Objects;

public class Competition implements Keyed {

    private String name;

    private List<Stage> stages;

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

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competition that = (Competition) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(stages, that.stages);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, stages);
    }
}
