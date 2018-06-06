package com.sharebaseinc.wallet.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.sharebaseinc.wallet.repository.entity.UserWalletAddressEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class UserWalletAddressRepositoryTest {

	@Autowired
	private UserWalletAddressRepository repo;

	@DatabaseTearDown("tearDown.xml")
	public void tearDown() {

	}

	@Test
	@ExpectedDatabase("expectedData.xml")
	@DatabaseSetup("sampleData.xml")
	public void test() {

		List<UserWalletAddressEntity> list = repo.find("kouichi");

		UserWalletAddressEntity e = list.get(0);
		
		Assert.assertEquals("kouichi" ,e.getUserId());
		

	}

}
