package com.jk.hr.fantasy.controller;

import com.jk.hr.fantasy.data.DataContext;
import com.jk.hr.fantasy.users.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/user/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private static final Logger LOG = LogManager.getLogger(UserController.class);

    @Resource(name="userTokenRepository")
    protected UserTokenRepository userTokenRepository;

    @Resource(name="dataContext")
    protected DataContext dataContext;

    @RequestMapping(value = "login", method=RequestMethod.POST)
    public @ResponseBody String login(@RequestParam String username, @RequestParam String pin) throws Exception {
        return userTokenRepository.login(username, pin);
    }

    @RequestMapping(value = "logout", method=RequestMethod.POST)
    public void logout(@RequestParam String username) {
        userTokenRepository.logout(username);
    }

    @RequestMapping(value="add", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void addUser(@RequestParam String username, @RequestParam String token, @RequestBody User user) throws Exception {

        //If authorised
        User adminUser = userTokenRepository.validate(username, token);
        if(adminUser != null && adminUser.isAdmin()) {
            dataContext.store(user);
        }

    }

}
