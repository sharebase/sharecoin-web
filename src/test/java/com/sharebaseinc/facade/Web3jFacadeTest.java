package com.sharebaseinc.facade;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
public class Web3jFacadeTest {

	@Autowired
	private Web3jFacade web3j;
	
	
	@Test
	public void test() throws IOException {
		
		String web3jv = web3j.getClientVersion();
		

		System.out.println(web3jv);
		
	}
	
	
	

	@Test
	public void testWeb3j(){
		
		
		
	}
	
	

}
