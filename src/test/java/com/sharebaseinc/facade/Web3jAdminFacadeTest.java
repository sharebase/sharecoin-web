package com.sharebaseinc.facade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
public class Web3jAdminFacadeTest {

	@Autowired
	private Web3jAdminFacade web3jadmin;
	
	
	@Test
	public void testCreateAccount() {
		
		

		Assert.assertNotNull(web3jadmin);
	}

}
