package com.sharebaseinc.facade;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthCoinbase;

@Service
public class Web3jAdminFacade {

	@Autowired
	private Admin admin;

	/**
	 * @throws IOException 
	 * @throws CipherException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidAlgorithmParameterException 
	 * 
	 */
	public void createAccount() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, CipherException, IOException {

		//String fileName = WalletUtils.generateFullNewWalletFile("your password", new File("//to/destination"));
		Request<?, EthAccounts> request = admin.ethAccounts();

		
		
		EthAccounts  e = request.send();
		List<String> accountList =e.getAccounts();
		
		
		for(String account : accountList){
			System.out.println(account);
		}
		
		
		
		EthCoinbase ecb = admin.ethCoinbase().send();

		System.out.println(ecb.getAddress());
		
		
	}
	
	
	
	public String createAccount(String password) throws IOException{
		
		String accountId = admin.personalNewAccount(password).send().getAccountId();
		
		
		return accountId;
	
		
	}
}
