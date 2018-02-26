package com.jk.hr.fantasy;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


import java.util.logging.Logger;

@SpringBootTest()
//@RunWith(SpringRunner.class)
@ContextConfiguration(classes={FantasyHorseracingApplication.class, FantasyHorseracingConfiguration.class})
public class ApplicationConfigurationTest {

    private Logger LOG = Logger.getLogger(ApplicationConfigurationTest.class.getName());

    @Autowired
    private FantasyHorseracingConfiguration configuration;

    @Ignore
    @Test
    public void testValue() {
        Assert.assertEquals("Hello", configuration.getTestValue());
    }
}

