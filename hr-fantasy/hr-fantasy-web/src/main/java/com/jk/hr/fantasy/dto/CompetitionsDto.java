package com.jk.hr.fantasy.dto;

import java.util.ArrayList;
import java.util.List;

public class CompetitionsDto {

    private List <CompetitionDto> active = new ArrayList<>();

    public List<CompetitionDto> getActive() {
        return active;
    }

    public void setActive(List<CompetitionDto> active) {
        this.active = active;
    }

}
