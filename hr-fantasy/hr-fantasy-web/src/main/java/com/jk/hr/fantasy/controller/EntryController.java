package com.jk.hr.fantasy.controller;

import com.jk.hr.fantasy.core.*;
import com.jk.hr.fantasy.data.DataContext;
import com.jk.hr.fantasy.users.User;
import org.joda.time.DateTime;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/entry/", produces = MediaType.APPLICATION_JSON_VALUE)
public class EntryController {

    @Resource(name="dataContext")
    DataContext dataContext;

    @Resource(name="userTokenRepository")
    UserTokenRepository userTokenRepository;

    @RequestMapping(value="entrant/add", method= RequestMethod.POST)
    public void addEntrant(@RequestParam String username, @RequestParam String token, @RequestBody Entrant entrant) throws Exception {
        //If authorised
        User ordinaryUser = userTokenRepository.validate(username, token);
        if(ordinaryUser != null) {

            Competition competition = dataContext.load(Competition.class, entrant.getCompetitionName());
            if(competition != null) {

                if(!ordinaryUser.isAdmin()) {
                    entrant.setPaid(false);
                }

                dataContext.store(entrant);

            }
        }
    }

    @RequestMapping(value="entrant/list", method=RequestMethod.GET)
    public @ResponseBody
    List<String> listEntrants(@RequestParam String username, @RequestParam String token, @RequestParam String competition) throws Exception {
        //If authorised
        User ordinaryUser = userTokenRepository.validate(username, token);
        if(ordinaryUser != null) {
            return dataContext.list(Entrant.class, competition);
        }

        return null;
    }

    @RequestMapping(value="entrant/pay", method= RequestMethod.POST)
    public void addEntrant(@RequestParam String username, @RequestParam String token, @RequestParam String entrant) throws Exception {
        //If authorised
        User adminUser = userTokenRepository.validate(username, token);
        if(adminUser != null && adminUser.isAdmin()) {
            Entrant loaded = dataContext.load(Entrant.class, entrant);
            loaded.setPaid(true);
            dataContext.store(loaded);
        }
    }

    @RequestMapping(value="entry/add", method= RequestMethod.POST)
    public void addEntry(@RequestParam String username, @RequestParam String token, @RequestBody Entry entry) throws Exception {

        //If authorised
        User ordinaryUser = userTokenRepository.validate(username, token);
        if(ordinaryUser != null) {

            Competition competition = dataContext.load(Competition.class, entry.getCompetitionName());
            Stage stage = dataContext.load(Stage.class, entry.getCompetitionName(), entry.getStage());
            Entrant entrant = dataContext.load(Entrant.class, entry.getCompetitionName(), entry.getUserName());
            if(competition != null && stage != null && entrant != null) {

                Entry previousEntry = dataContext.load(Entry.class, entry.getCompetitionName(), entry.getStage(), entry.getUserName());
                DateTime now = DateTime.now();

                if(!previousEntry.equals(entry)) {

                    //Copy across only those where we are before the race start time
                    for(String raceName : stage.getRaces()) {
                        Race race = dataContext.load(Race.class, entry.getCompetitionName(), entry.getStage(), raceName);
                        if(race.getOffTime().isAfter(now)) {
                            previousEntry.getSelections().put(raceName, entry.getSelections().get(raceName));
                        }
                    }

                    dataContext.store(previousEntry);

                }
            }
        }
    }

    @RequestMapping(value="entry/show", method= RequestMethod.GET)
    public Entry getEntry(@RequestParam String username, @RequestParam String token, @RequestParam String competitionName, String stageName) throws Exception {

        //If authorised
        User ordinaryUser = userTokenRepository.validate(username, token);
        if(ordinaryUser != null) {
            Entry entry = dataContext.load(Entry.class, competitionName, stageName, ordinaryUser.getUserName());
            if(entry == null) {
                entry = new Entry();
                entry.setCompetitionName(competitionName);
                entry.setStage(stageName);
                entry.setUserName(ordinaryUser.getUserName());
                entry.setSelections(new HashMap<>());
                return entry;
            }
        }

        return null;
    }

    @RequestMapping(value="entry/force", method= RequestMethod.POST)
    public void forceEntry(@RequestParam String username, @RequestParam String token, @RequestBody Entry entry) throws Exception {

        //If authorised
        User adminUser = userTokenRepository.validate(username, token);
        if(adminUser != null && adminUser.isAdmin()){
            Competition competition = dataContext.load(Competition.class, entry.getCompetitionName());
            Stage stage = dataContext.load(Stage.class, entry.getCompetitionName(), entry.getStage());
            Entrant entrant = dataContext.load(Entrant.class, entry.getCompetitionName(), entry.getUserName());

            if(competition != null && stage != null && entrant != null) {
                dataContext.store(entry);
            }

        }
    }

}
