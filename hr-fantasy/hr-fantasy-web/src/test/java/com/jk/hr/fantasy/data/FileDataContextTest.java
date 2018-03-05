package com.jk.hr.fantasy.data;

import com.jk.hr.fantasy.FantasyHorseracingApplication;
import com.jk.hr.fantasy.FantasyHorseracingConfiguration;
import com.jk.hr.fantasy.core.Competition;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest()
@RunWith(SpringRunner.class)
@ContextConfiguration(classes={FantasyHorseracingApplication.class, FantasyHorseracingConfiguration.class})
public class FileDataContextTest {

    @Autowired
    private DataContext dataContext;

    @Test
    public void testCompetition() throws Exception {

        Competition competition = dataContext.load(Competition.class, "TestCompetition");
        Assert.assertNotNull(competition);

        competition = dataContext.load(Competition.class, "MissingCompetition");
        Assert.assertNull(competition);

    }

}
