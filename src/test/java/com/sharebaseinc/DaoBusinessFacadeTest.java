package com.sharebaseinc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
public class DaoBusinessFacadeTest {

	@Autowired
	private DaoBusinessFacade daoFacade;

	
	
	@Test
	public void test() {
		
		Assert.assertNotNull(daoFacade);
		
		
		
	}

}
