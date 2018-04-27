package com.sharebaseinc.facade;

import java.io.IOException;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web3j.protocol.core.methods.response.Transaction;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

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
	public void testWeb3j() {

		Observable<Transaction> ob = Observable.create(new OnSubscribe<Transaction>() {

			@Override
			public void call(Subscriber<? super Transaction> t) {
				
				Transaction trn = new Transaction();
				
				trn.setBlockHash("hogehoge");
				t.onNext(trn);
				
				
			}
		});
		ob.observeOn(Schedulers.computation()).subscribe(new Observer<Transaction>() {

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onNext(Transaction t) {

				System.out.println("hash is " +t.getBlockHash());

			}

		});
	}

}
