package com.jk.hr.fantasy.controller;

import org.springframework.stereotype.Component;

import java.util.*;

@Component(value="userTokenRepository")
public class UserTokenRepository {

    private Map<String, UserTokenWithTimeout> userTokens = new HashMap<String, UserTokenWithTimeout>();

    public String login(String user) {

        if(!userTokens.containsKey(user)) {
            userTokens.put(user, new UserTokenWithTimeout(UUID.randomUUID().toString()));
        }

        return userTokens.get(user).token;
    }

    public boolean validate(String user, String token) {

        timeout();

        UserTokenWithTimeout timeoutToken = userTokens.get(user);
        String storedToken = timeoutToken == null || timeoutToken.isTimedOut() ? null : timeoutToken.token;
        return token != null && token.equals(storedToken);
    }

    public void logout(String user, String token) {
        if(validate(user, token)) {
            userTokens.remove(user);
        }
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

        private long timeout;

        public UserTokenWithTimeout(String token) {
            this.token = token;
            this.timeout = System.currentTimeMillis() + (60 * 60 * 1000);
        }

        public boolean isTimedOut() {
            return System.currentTimeMillis() > this.timeout;
        }

        public boolean isValid() {
            return !isTimedOut();
        }

    }

}
