package com.sharebaseinc;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.sharebaseinc.contract.DaoDecorator;
import com.sharebaseinc.contract.factory.DaoFactory;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class DaoBusinessFacadeTest {

	@Autowired
	private DaoFactory daoFactory;

	@Test
	public void test() throws Exception {
		

		BigInteger gasPrice = new BigInteger("1");
		BigInteger gasLimit= new BigInteger("2");
		
		
		String contractAddress = "";
		
		Credentials credential = WalletUtils.loadCredentials("", "/home/kouichi/data_testnet/keystore/UTC--2017-08-14T07-23-26.961758766Z--d79268b86aeb0996dad3ea2a9373e78fae512976");
		
		DaoDecorator dao =  daoFactory.loadFromLedger(contractAddress, credential, gasPrice, gasLimit);
		dao.getCurator();


	}

}
