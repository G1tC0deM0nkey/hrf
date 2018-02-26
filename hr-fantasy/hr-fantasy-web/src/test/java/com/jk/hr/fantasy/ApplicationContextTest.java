package com.jk.hr.fantasy;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest()
//@RunWith(SpringRunner.class)
@ContextConfiguration(classes={FantasyHorseracingApplication.class})
public class ApplicationContextTest {

	@Test
	public void contextLoads() {
    }

}
