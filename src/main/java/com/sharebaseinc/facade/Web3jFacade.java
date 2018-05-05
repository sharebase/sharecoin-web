package com.sharebaseinc.facade;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

import rx.Observable;
import rx.Observer;
import rx.schedulers.Schedulers;
/**
 * 
 * 
 * web3jをラップしてビジネス部分のデータのみ取得できるようにする。
 * 
 * 
 * 
 * @author kouichi
 *
 */
@Service
public class Web3jFacade {
	@Autowired
	private Web3j web3j;

	public String getClientVersion() throws IOException {

		Web3ClientVersion web3jv = web3j.web3ClientVersion().send();

		return web3jv.getWeb3ClientVersion();

	}

	
	public Transaction getTransactionFromBlockHash(String blockHash ,BigInteger transactionIndex) throws IOException{
		
		Transaction t = web3j.ethGetTransactionByBlockHashAndIndex(blockHash, transactionIndex).send().getResult();
		
		return t;
		
		
	}
	
	/**
	 * 
	 * @param address
	 * @return
	 * @throws IOException
	 */
	public EthGetBalance getBalance(String address) throws IOException{
	
		// ブロックの位置
		DefaultBlockParameter defaultBlockParameter = DefaultBlockParameterName.LATEST;
		EthGetBalance b = web3j.ethGetBalance(address, defaultBlockParameter).send();
		
		
		return b;
	}
	
	
	public EthAccounts getAccountsInfomation() throws IOException{
		
		EthAccounts accounts =  web3j.ethAccounts().send();	
		return accounts;
		
	}
	
	
	public Transaction getTransactionFromHash(String transactionHash) throws IOException{
		
		EthTransaction etran = web3j.ethGetTransactionByHash(transactionHash).send();
		
		Transaction t = etran.getResult();
		
		return t;
		
	}
	
	
	public EthBlock getBlockNumber() throws IOException{

		
		boolean returnFullTransactionObjects = true;
		DefaultBlockParameter defaultBlockParameter = DefaultBlockParameterName.LATEST;

		EthBlock block = web3j.ethGetBlockByNumber(defaultBlockParameter, returnFullTransactionObjects).send();
		
		
		return block;
		
	}
	
	
	
	
	/**
	 * 
	 */
	public void createAccount() {

		String address = null;
		BigInteger position = null;
		DefaultBlockParameter defaultBlockParameter = null;

		web3j.ethGetStorageAt(address, position, defaultBlockParameter);

	}

	public void fileText() {

		Observable<Transaction> ob = web3j.transactionObservable();
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
				
				System.out.println(t.getBlockNumber());
				
			}
			
		});

	}

	public EthBlock getBlockNumberFrom(String blockHash) throws IOException {
		
		boolean returnFullTransactionObjects = true;
		
		
		Request<?, EthBlock> r = web3j.ethGetBlockByHash(blockHash, returnFullTransactionObjects);
		EthBlock block = r.send();
		
		return block;
		
		
	}

}
