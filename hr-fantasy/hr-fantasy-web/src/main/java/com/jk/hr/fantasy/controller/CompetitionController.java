package com.jk.hr.fantasy.controller;

import com.jk.hr.fantasy.core.*;
import com.jk.hr.fantasy.data.DataContext;
import com.jk.hr.fantasy.dto.CompetitionDto;
import com.jk.hr.fantasy.dto.CompetitionsDto;
import com.jk.hr.fantasy.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value="list", method=RequestMethod.GET)
    public @ResponseBody
    CompetitionsDto listCompetitions(@RequestParam String username, @RequestParam String token) throws Exception {
        //If authorised
        User ordinaryUser = userTokenRepository.validate(username, token);
        if(ordinaryUser != null) {
            List <String> activeCompetitions = dataContext.list(ActiveCompetition.class);

            CompetitionsDto competitions = new CompetitionsDto();

            for(String activeComp : activeCompetitions) {

                List<String> entrants = dataContext.list(Entrant.class, activeComp );
                CompetitionDto competition = new CompetitionDto(activeComp);
                competition.setEntrants(entrants.size());

                Entrant entrant = dataContext.load(Entrant.class, activeComp, username);
                if(entrant != null) {
                    competition.setEntered(true);
                }

                competitions.getActive().add(competition);

            }


        }

        return null;
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
