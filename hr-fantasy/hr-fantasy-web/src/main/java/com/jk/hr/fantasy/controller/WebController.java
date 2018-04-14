package com.jk.hr.fantasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/web", produces = MediaType.APPLICATION_JSON_VALUE)
public class WebController {

    private static final Logger LOG = Logger.getLogger(WebController.class.getName());

    @Autowired
    protected UserTokenRepository userTokenRepository;

//    @RequestMapping(method=RequestMethod.GET, value="/home")
//    public StatusDto tomorrowsStatus(String user, String token) {
//
//        boolean valid = userTokenRepository.validate(user, token);
//        ThreadContext.put("uuid", token);
//        LOG.info(String.format("setUserName %s requests fixture creation and is %s", user, (valid ? "accepted" : "rejected")));
//
//        if(valid) {
//            StatusDto statusDto = new StatusDto();
//
//            return statusDto;
//        }
//
//        return null;
//
//    }


}
