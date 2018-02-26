package com.jk.hr.fantasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

//    @Autowired
//    protected UserTokenRepository userTokenRepository;
//
//    @RequestMapping(value = "login", method=RequestMethod.POST)
//    public String login(String username, String password) throws Exception {
//        if("caerus".equals(username) && "racing".equals(password)) {
//            return userTokenRepository.login(username);
//        }
//        else {
//            throw new Exception("Login failed for user " + username);
//        }
//    }
//
//    @RequestMapping(value = "logout", method=RequestMethod.POST)
//    public void logout(String username, String token) {
//        userTokenRepository.logout(username, token);
//    }

}
