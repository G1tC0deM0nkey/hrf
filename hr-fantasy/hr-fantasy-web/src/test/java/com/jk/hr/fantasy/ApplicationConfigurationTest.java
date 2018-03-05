package com.jk.hr.fantasy;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.logging.Logger;

@SpringBootTest()
@RunWith(SpringRunner.class)
@ContextConfiguration(classes={FantasyHorseracingApplication.class, FantasyHorseracingConfiguration.class})
public class ApplicationConfigurationTest {

    private Logger LOG = Logger.getLogger(ApplicationConfigurationTest.class.getName());

    @Autowired
    private FantasyHorseracingConfiguration configuration;

    @Test
    public void testValue() {
        Assert.assertEquals("data", configuration.getDataDirectory());
    }
}

