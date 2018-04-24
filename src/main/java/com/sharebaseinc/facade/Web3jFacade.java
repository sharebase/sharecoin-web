package com.sharebaseinc.facade;

import java.io.IOException;
import java.math.BigInteger;

import javax.swing.table.DefaultTableColumnModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

@Service
public class Web3jFacade {
	@Autowired
	private Web3j web3j;

	public String getClientVersion() throws IOException {

		Web3ClientVersion web3jv = web3j.web3ClientVersion().send();

		return web3jv.getWeb3ClientVersion();

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

}
