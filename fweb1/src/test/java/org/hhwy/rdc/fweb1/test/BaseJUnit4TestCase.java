package org.hhwy.rdc.fweb1.test;

import java.util.Random;

import org.hhwy.rdc.fweb1.Utility;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
public class BaseJUnit4TestCase extends
		AbstractTransactionalJUnit4SpringContextTests {

	private static final int MIN = 2;
	private static final int MAX = 10;

	protected int getRandomInt() {
		return (int) (Math.random() * (MAX - MIN) + MIN);
	}

	protected boolean getRandomBoolean() {
		return getRandomInt() > MAX / 2;
	}
	
	protected String getRandomString(){
		return Utility.randomString(5) + ",≤‚ ‘";
	}

}