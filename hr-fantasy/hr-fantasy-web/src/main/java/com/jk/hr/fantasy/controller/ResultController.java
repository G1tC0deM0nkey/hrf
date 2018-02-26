package com.jk.hr.fantasy.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class ResultController {

    private static final Logger LOG = Logger.getLogger(ResultController.class.getName());

//    @Autowired
//    protected UserTokenRepository userTokenRepository;
//
//    @RequestMapping(method=RequestMethod.GET, value="/home")
//    public StatusDto todaysStatus(String user, String token) {
//
//        boolean valid = userTokenRepository.validate(user, token);
//        ThreadContext.put("uuid", token);
//        LOG.info(String.format("User %s requests fixture creation and is %s", user, (valid ? "accepted" : "rejected")));
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
