package com.jk.hr.fantasy.controller;

import com.jk.hr.fantasy.core.Competition;
import com.jk.hr.fantasy.core.Race;
import com.jk.hr.fantasy.core.Stage;
import com.jk.hr.fantasy.data.DataContext;
import com.jk.hr.fantasy.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/competition/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompetitionController {

    @Resource(name="dataContext")
    DataContext dataContext;

    @Resource(name="userTokenRepository")
    UserTokenRepository userTokenRepository;

    @RequestMapping(value="add", method=RequestMethod.POST)
    public void addCompetition(@RequestParam String username, @RequestParam String token, @RequestBody Competition competition) throws Exception {
        //If authorised
        User adminUser = userTokenRepository.validate(username, token);
        if(adminUser != null && adminUser.isAdmin()) {
            dataContext.store(competition);
        }
    }

    @RequestMapping(value="list", method=RequestMethod.GET)
    public @ResponseBody List<String> listCompetitions(@RequestParam String username, @RequestParam String token) throws Exception {
        //If authorised
        User ordinaryUser = userTokenRepository.validate(username, token);
        if(ordinaryUser != null) {
            return dataContext.list(Competition.class);
        }

        return null;
    }

    @RequestMapping(value="stage/add", method=RequestMethod.POST)
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

    @RequestMapping(value="stage/list", method=RequestMethod.GET)
    public @ResponseBody List<String> listStages(@RequestParam String username, @RequestParam String token, @RequestParam String competition) throws Exception {
        //If authorised
        User ordinaryUser = userTokenRepository.validate(username, token);
        if(ordinaryUser != null) {
            return dataContext.list(Stage.class, competition);
        }

        return null;
    }

    @RequestMapping(value="race/add", method=RequestMethod.POST)
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

    @RequestMapping(value="race/list", method=RequestMethod.GET)
    public @ResponseBody List<String> listRaces(@RequestParam String username, @RequestParam String token, @RequestParam String competition, @RequestParam String stage) throws Exception {
        //If authorised
        User ordinaryUser = userTokenRepository.validate(username, token);
        if(ordinaryUser != null) {
            return dataContext.list(Race.class, competition, stage);
        }

        return null;
    }


}
