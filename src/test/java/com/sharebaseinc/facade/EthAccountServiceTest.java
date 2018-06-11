package com.sharebaseinc.facade;

import java.io.IOException;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.web3j.crypto.CipherException;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.sharebaseinc.wallet.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class EthAccountServiceTest extends EthAccountService {

	@Autowired
	private EthAccountService ethAccountService;
	
	
	@Test
	@ExpectedDatabase("expectedData.xml")
	@DatabaseSetup("sampleData.xml")
	public void testGetWalletCredential() throws IOException, CipherException {
		
		User u = new User();
		u.setUserId("kouichi");
		ethAccountService.getWalletCredential(u, "");
		
		
	}

}
