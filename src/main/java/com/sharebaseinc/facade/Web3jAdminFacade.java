package com.sharebaseinc.facade;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthAccounts;

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

		String fileName = WalletUtils.generateFullNewWalletFile("your password", new File("/path/to/destination"));
		Request<?, EthAccounts> request = admin.ethAccounts();

		request.getId();

	}
}
