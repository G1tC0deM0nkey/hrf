package com.jk.hr.fantasy.controller;

import com.jk.hr.fantasy.core.Code;
import com.jk.hr.fantasy.data.DataContext;
import com.jk.hr.fantasy.dto.NewUserDto;
import com.jk.hr.fantasy.dto.NewUserResponseDto;
import com.jk.hr.fantasy.dto.UserDto;
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
    public @ResponseBody UserDto login(@RequestParam String username, @RequestParam String pin) throws Exception {
        return userTokenRepository.login(username.toLowerCase(), pin);
    }

    @RequestMapping(value = "logout", method=RequestMethod.POST)
    public void logout(@RequestParam String username) {
        userTokenRepository.logout(username.toLowerCase());
    }

    @RequestMapping(value="add", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public NewUserResponseDto addUser(@RequestBody NewUserDto user) throws Exception {

        LOG.info("Creating new user " + user.getUserName());

           User newUser = new User();
           newUser.setAdmin(false);
           newUser.setUserName(user.getUserName().toLowerCase());
           newUser.setDisplayName(user.getDisplayName());
           newUser.setEmail(user.getEmail());

           if(user.getPin() != null && user.getPin().equals(user.getPinConfirm())) {
               newUser.setPin(user.getPin());

               User existingUser = dataContext.load(User.class, newUser.getUserName());
               if(existingUser != null) {
                   return new NewUserResponseDto("Failure - User already exists - Please try again with a different username.",false);
               }

               Code code = dataContext.load(Code.class, user.getCode().toLowerCase());
               if(code != null) {
                   dataContext.store(newUser);
               }
               else {
                   return new NewUserResponseDto("Failure - The code that was entered is not valid. Please ask the organiser for a valid code to create a user.", false);
               }

           } else {
               return new NewUserResponseDto("Failure - Pin/Password and Confirmation didn't match, please try again", false);
           }

           return new NewUserResponseDto("Success - Created new user " + user.getUserName() + " - please login", true);

    }

}
