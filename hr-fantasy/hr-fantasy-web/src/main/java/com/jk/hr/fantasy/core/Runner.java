package com.jk.hr.fantasy.core;

import java.util.Objects;

public class Runner {

    private int racecardNumber;

    private String name;

    private String form;

    private String weight;

    private String stall;

    private String jockey;

    private String trainer;

    private String rating;

    private boolean nr;

    public int getRacecardNumber() {
        return racecardNumber;
    }

    public void setRacecardNumber(int racecardNumber) {
        this.racecardNumber = racecardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStall() {
        return stall;
    }

    public void setStall(String stall) {
        this.stall = stall;
    }

    public String getJockey() {
        return jockey;
    }

    public void setJockey(String jockey) {
        this.jockey = jockey;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean isNr() {
        return nr;
    }

    public void setNr(boolean nr) {
        this.nr = nr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runner runner = (Runner) o;
        return racecardNumber == runner.racecardNumber &&
                nr == runner.nr &&
                Objects.equals(name, runner.name) &&
                Objects.equals(form, runner.form) &&
                Objects.equals(weight, runner.weight) &&
                Objects.equals(stall, runner.stall) &&
                Objects.equals(jockey, runner.jockey) &&
                Objects.equals(trainer, runner.trainer) &&
                Objects.equals(rating, runner.rating);
    }

    @Override
    public int hashCode() {

        return Objects.hash(racecardNumber, name, form, weight, stall, jockey, trainer, rating, nr);
    }

    @Override
    public String toString() {
        return "Runner{" +
                "racecardNumber=" + racecardNumber +
                ", name='" + name + '\'' +
                ", form='" + form + '\'' +
                ", weight='" + weight + '\'' +
                ", stall='" + stall + '\'' +
                ", jockey='" + jockey + '\'' +
                ", trainer='" + trainer + '\'' +
                ", rating='" + rating + '\'' +
                ", nr=" + nr +
                '}';
    }
}
