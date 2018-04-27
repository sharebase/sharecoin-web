package com.sharebaseinc.facade;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web3j.crypto.CipherException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
public class Web3jAdminFacadeTest {

	@Autowired
	private Web3jAdminFacade web3jadmin;

	@Test
	public void testCreateAccount() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException,
			NoSuchProviderException, CipherException, IOException {

		Assert.assertNotNull(web3jadmin);

		web3jadmin.createAccount();

	}

	@Test
	public void testCreateAccount2() throws IOException {

		String id = web3jadmin.createAccount("password");

		System.out.println("created id : " + id);
	}
	
	
	
	

}
