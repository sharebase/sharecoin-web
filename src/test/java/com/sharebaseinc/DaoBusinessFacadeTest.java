package com.sharebaseinc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web3j.protocol.Web3j;

import com.sharebaseinc.facade.DaoBusinessFacade;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
public class DaoBusinessFacadeTest {

	@Autowired
	private DaoBusinessFacade daoFacade;

	@Test
	public void test() throws Exception {

		Web3j web3j = daoFacade.getWeb3j();

//		daoFacade.setAccount();

		Assert.assertNotNull(daoFacade);

		Assert.assertNotNull(web3j);

		System.out.println("gasprice :" + web3j.ethGasPrice().getId());

	}

}
