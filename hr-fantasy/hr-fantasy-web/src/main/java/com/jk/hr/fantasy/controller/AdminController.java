package com.jk.hr.fantasy.controller;

import com.jk.hr.fantasy.core.*;
import com.jk.hr.fantasy.data.DataContext;
import com.jk.hr.fantasy.dto.CompetitionDto;
import com.jk.hr.fantasy.dto.CompetitionsDto;
import com.jk.hr.fantasy.users.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    @Resource(name="dataContext")
    DataContext dataContext;

    @Resource(name="userTokenRepository")
    UserTokenRepository userTokenRepository;

    @RequestMapping(value="code/add", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(code= HttpStatus.OK)
    public void addCode(@RequestParam String username, @RequestParam String token, @RequestParam String code) throws Exception {
        //If authorised
        User adminUser = userTokenRepository.validate(username, token);
        if(adminUser != null && adminUser.isAdmin()) {
            Code newCode = new Code(code);
            dataContext.store(newCode);
        }
    }

    @RequestMapping(value="competition/add", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(code= HttpStatus.OK)
    public void addCompetition(@RequestParam String username, @RequestParam String token, @RequestBody Competition competition) throws Exception {
        //If authorised
        User adminUser = userTokenRepository.validate(username, token);
        if(adminUser != null && adminUser.isAdmin()) {
            dataContext.store(competition);
        }
    }

    @RequestMapping(value="stage/add", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(code= HttpStatus.OK)
    public void addStage(@RequestParam String username, @RequestParam String token, @RequestBody Stage stage) throws Exception {
        //If authorised
        User adminUser = userTokenRepository.validate(username, token);
        if(adminUser != null && adminUser.isAdmin()) {

            Competition competition = dataContext.load(Competition.class, stage.getCompetition());
            if(competition != null) {
                if(!competition.getStages().contains(stage.getName())) {
                    competition.getStages().add(stage.getName());
                    dataContext.store(competition);
                }
                dataContext.store(stage);
            }
        }
    }

    @RequestMapping(value="race/add", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(code= HttpStatus.OK)
    public void addRace(@RequestParam String username, @RequestParam String token, @RequestBody Race race) throws Exception {
        //If authorised
        User adminUser = userTokenRepository.validate(username, token);
        if(adminUser != null && adminUser.isAdmin()) {

            Competition competition = dataContext.load(Competition.class, race.getCompetition());
            Stage stage = dataContext.load(Stage.class, race.getCompetition(), race.getStage());

            if(competition != null && stage != null) {
                if(!stage.getRaces().contains(race.getName())) {
                    stage.getRaces().add(race.getName());
                    dataContext.store(stage);
                }
                dataContext.store(race);
            }
        }
    }


}
