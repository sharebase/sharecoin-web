package com.sharebaseinc.facade;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthTransaction;
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

	/**
	 * @throws IOException
	 * 
	 */

	@Test
	public void testAccounts() throws IOException {

		EthAccounts accounts = web3j.getAccountsInfomation();

		List<String> accountList = accounts.getAccounts();

		for (String account : accountList) {
			System.out.println(account);
		}

	}

	@Test
	public void testGetBalance() throws IOException {

		String testAccount = "0xd79268b86aeb0996dad3ea2a9373e78fae512976";

		EthAccounts accounts = web3j.getAccountsInfomation();

		List<String> accountList = accounts.getAccounts();

		for (String account : accountList) {
			EthGetBalance b = web3j.getBalance(account);
			System.out.println(account + " balance is " + b.getBalance());
		}

	}

	/**
	 * 
	 * 
	 * 
	 * parent blockをblockchainにシステムを取り込む
	 * 
	 * 
	 * @throws IOException
	 */
	@Test
	public void testBlock() throws IOException {

		EthBlock block = web3j.getBlockNumberFrom("0x4f9bfc9e61fd292c578c18d8934ae9c4633f3e2b73e436cdf627d9a17c65d11b");

		System.out.println("blockNumber " + block.getBlock().getNumber());

		// parent block
		// hash"0x4f9bfc9e61fd292c578c18d8934ae9c4633f3e2b73e436cdf627d9a17c65d11b","receiptsRoot"

		block.getBlock().getHash();

		List<EthBlock.TransactionResult> trans = null;
		do {

			String parent = block.getBlock().getParentHash();

			EthBlock eb = web3j.getBlockNumberFrom(parent);

//			System.out.println("parent " + eb.getBlock().getNumber());

			trans = eb.getBlock().getTransactions();

//			System.out.println("trans " + trans.size());

			for (EthBlock.TransactionResult tran : trans) {

				System.out.println(tran.get());
				
				

			}

			block = eb;
		} while (trans.isEmpty());
		
		
		System.out.println(block.getBlock().getHash());
		
	}

	@Test
	public void testTransaction() throws IOException {

		String transactionHash = "0x654578b2059c04558e27bb1d47ca9bfd389c738237de5ff87a3e2b0d25a1ad27";
		transactionHash ="0x548baa79671481ae23dafb230665dde8fcb5c8a320ec03bd745f6ab96084dadc";
		// EthTransaction etran = web3j.getTransaction(transactionHash);

		//0x95776df723da45f8e1b39f8f3d80d595cb28be653f545601d16eca4036bc13c4
		Transaction t = web3j.getTransactionFromHash(transactionHash);
		System.out.println("transaction from " + t.getFrom());

		System.out.println("transaction To " + t.getTo());

		System.out.println("transaction Value " + t.getValue());

		System.out.println("transaction small v " + t.getV());

		// 0x548baa79671481ae23dafb230665dde8fcb5c8a320ec03bd745f6ab96084dadc

		//
		// transactions":[{"blockHash":"0x548baa79671481ae23dafb230665dde8fcb5c8a320ec03bd745f6ab96084dadc","blockNumber":"0x8324","from":"0xd79268b86aeb0996dad3ea2a9373e78fae512976","gas":"0xc6cd","gasPrice":"0x4a817c800","hash":"0x654578b2059c04558e27bb1d47ca9bfd389c738237de5ff87a3e2b0d25a1ad27","input":"0xa9059cbb000000000000000000000000195bc791f8b2c2924adb1932f755c5245a2a145000000000000000000000000000000000000000000000000000000000000007d0","nonce":"0xf","to":"0x53437875c623415223852a286757a0e115097e29","transactionIndex":"0x0","value":"0x0","v":"0x1b","r":"0x51917ccb7c3cc4989a016d20db89f636fe1ea657827f1c37cff11f17624520ce","s":"0x6e59551c731950798e51f8364c4f23a962fd76375f0273c530c4c4569b62997b"}]

		// 33572
		// parent block
		// hash"0x4f9bfc9e61fd292c578c18d8934ae9c4633f3e2b73e436cdf627d9a17c65d11b","receiptsRoot"

	}
	
	
	@Test
	public void testTransactionFromBlock() throws IOException{
		
		String blockHash = "0x548baa79671481ae23dafb230665dde8fcb5c8a320ec03bd745f6ab96084dadc";
		// 0x95776df723da45f8e1b39f8f3d80d595cb28be653f545601d16eca4036bc13c4
		blockHash = "0x95776df723da45f8e1b39f8f3d80d595cb28be653f545601d16eca4036bc13c4";
		BigInteger transactionIndex = new BigInteger("0");
		
		Transaction t = web3j.getTransactionFromBlockHash(blockHash, transactionIndex);
		
		
		// 
		System.out.println("transaction from " + t.getFrom());
		
		
		// 0xd79268b86aeb0996dad3ea2a9373e78fae512976
		
		//27 
		System.out.println("transaction V " + t.getV());

		System.out.println("transaction value " + t.getValue().intValue());
		System.out.println("transaction to " + t.getTo());
		System.out.println("transaction gas " + t.getGas());
		
		
		
		
	}
	
	
	/**
	 * 
	 */
	@Test
	public void testAccoun(){
		
		
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

				System.out.println("hash is " + t.getBlockHash());

			}

		});
	}

}
