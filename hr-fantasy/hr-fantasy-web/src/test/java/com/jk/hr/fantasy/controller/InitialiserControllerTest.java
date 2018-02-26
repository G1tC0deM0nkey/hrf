package com.jk.hr.fantasy.controller;

import com.jk.hr.fantasy.FantasyHorseracingApplication;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.net.*;
import java.util.logging.Logger;

@SpringBootTest()
//@RunWith(SpringRunner.class)
@ContextConfiguration(classes={FantasyHorseracingApplication.class})
public class InitialiserControllerTest {

    private Logger LOG = Logger.getLogger(InitialiserControllerTest.class.getName());

    @Ignore
    @Test
    public void testControllerToggleMethod() {

        HttpURLConnection connection = null;

        try {
            URL url = new URL("http://" + Inet4Address.getLocalHost().getHostAddress() + ":8080/toggle");

            LOG.info("Connecting to " + url.getPath() + " ...");

            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Accept", "application/xml");
            connection.setRequestProperty("Content-Type", "application/xml");

            int responseCode = connection.getResponseCode();

            Assert.assertEquals(200, responseCode);

        }
        catch(IOException ioe) {
            Assert.fail(ioe.getMessage());
        }
        finally {
            //Release resources
            if(connection != null) {
                connection.disconnect();
            }
        }
    }

    @Ignore
    @Test
    public void testControllerPromptMethod() {

        HttpURLConnection connection = null;

        try {
            URL url = new URL("http://" + Inet4Address.getLocalHost().getHostAddress() + ":8080/prompt");

            LOG.info("Connecting to " + url.getPath() + " ...");

            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Accept", "application/xml");
            connection.setRequestProperty("Content-Type", "application/xml");

            int responseCode = connection.getResponseCode();

            Assert.assertEquals(200, responseCode);

        }
        catch(IOException ioe) {
            Assert.fail(ioe.getMessage());
        }
        finally {
            //Release resources
            if(connection != null) {
                connection.disconnect();
            }
        }
    }

    @After
    public void teardown() {

    }

}
