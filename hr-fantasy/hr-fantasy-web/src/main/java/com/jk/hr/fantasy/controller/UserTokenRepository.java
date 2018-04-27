package com.jk.hr.fantasy.controller;

import com.jk.hr.fantasy.data.DataContext;
import com.jk.hr.fantasy.dto.UserDto;
import com.jk.hr.fantasy.users.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@Component(value="userTokenRepository")
public class UserTokenRepository {

    private static final Logger LOG = LogManager.getLogger(UserTokenRepository.class);

    private Map<String, UserTokenWithTimeout> userTokens = new HashMap<String, UserTokenWithTimeout>();

    @Resource(name="dataContext")
    private DataContext dataContext;

    public UserDto login(String user, String pin) {

        if(userTokens.containsKey(user)) {
            UserTokenWithTimeout token = userTokens.get(user);
            if(!token.isTimedOut() && token.getUser().getPin().equals(pin)) {
                UserDto dto = new UserDto();
                dto.setUserName(token.user.getUserName());
                dto.setToken(token.token);
                dto.setDisplayName(token.user.getDisplayName());
                dto.setAdmin(token.user.isAdmin());
                return dto;
            }
        }
        else {
            try {
                User loaded = dataContext.load(User.class, user);

                if(loaded != null && loaded.getPin().equals(pin)) {
                    UserTokenWithTimeout token = new UserTokenWithTimeout(loaded, UUID.randomUUID().toString());
                    userTokens.put(user, token);

                    UserDto dto = new UserDto();
                    dto.setUserName(token.user.getUserName());
                    dto.setToken(token.token);
                    dto.setDisplayName(token.user.getDisplayName());
                    dto.setAdmin(token.user.isAdmin());
                    return dto;
                }

            } catch(IOException ioe) {
                LOG.warn("Login failed for user " + user, ioe);
                return null;
            }
        }

        return null;

    }

    public User validate(String user, String token) {

        timeout();

        if(userTokens.containsKey(user)) {
            UserTokenWithTimeout existing = userTokens.get(user);
            if(!existing.isTimedOut() && existing.token.equals(token)) {
                return existing.getUser();
            }
        }

        return null;
    }

    public void logout(String user) {
        userTokens.remove(user);
    }

    private void timeout() {

        Set<String> timedOut = new HashSet<String>();

        for(String user : userTokens.keySet()) {
            UserTokenWithTimeout tt = userTokens.get(user);
            if(tt.isTimedOut()) {
                timedOut.add(user);
            }
        }

        for(String user : timedOut) {
            userTokens.remove(user);
        }
    }

    private class UserTokenWithTimeout {

        private String token;

        private User user;

        private long timeout;

        public UserTokenWithTimeout(User user, String token) {
            this.token = token;
            this.user = user;
            this.timeout = System.currentTimeMillis() + (60 * 60 * 1000);
        }

        public User getUser() {
            return user;
        }

        public boolean isTimedOut() {
            return System.currentTimeMillis() > this.timeout;
        }

        public boolean isValid() {
            return !isTimedOut();
        }

    }

}
