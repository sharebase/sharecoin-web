package com.sharebaseinc.wallet;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.PropertySource;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import com.sharebaseinc.contract.DaoDecorator;
import com.sharebaseinc.contract.factory.DaoFactory;
import com.sharebaseinc.facade.EthAccountService;

/**
 * 
 * @author kouichi
 *
 */
@Configurable(preConstruction = true)
public class User {
	
	
	
	@Autowired
	private DaoFactory daoFactory;
	

	/*サイト内で利用する
	 * 
	 */
	private String userId;
	
	/* 複数持つことがあるから 一つではなくて取得できるようにする*/
	@Autowired
	private EthAccountService ethAccountService;
	
	
	public List<Pair<String,String>> getEthAccounts(){
		
		return ethAccountService.getAccounts(this);
		
		
	}

	/**
	 * 
	 * @return
	 */
	public Pair<String,String> getDefaultAccount(){
		
		//
		return getEthAccounts().get(0);
	}
	
	
	
	

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public DaoDecorator myDaoFacade(String password) throws IOException, CipherException{
		
		
		Pair<String,String> addressAndPath =getDefaultAccount();
		String contractAddress = addressAndPath.getKey();
		
		String path = addressAndPath.getValue();
		
		Credentials credentials =WalletUtils.loadCredentials(password,path);
		BigInteger gasPrice = getDefaultGasPrice();
		BigInteger gasLimit = getDefaultGasLimit();
		
		DaoDecorator dao = daoFactory.loadFromLedger(contractAddress, credentials, gasPrice, gasLimit);
		
		
		return dao;
	}
	
	/**
	 * 
	 * @return
	 */
	private BigInteger getDefaultGasLimit() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @return
	 */
	private BigInteger getDefaultGasPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

}
