package com.sharebaseinc.contract.factory;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;

import com.sharebaseinc.contract.DAO;
import com.sharebaseinc.contract.DaoDecorator;

@Service
public class DaoFactory {

	private DAO dao;

	@Autowired
	private Web3j web3j;

	/**
	 * 
	 * すでにある DAO contractを使って、新たにコントラクト実態を作成する
	 * 
	 * 
	 * 
	 * @throws Exception
	 */
	public DAO deployNewDaoContract() throws Exception {

		String password = "pass0";

		// private keyのパス

		String string = "/home/kouichi/data_testnet/testnet/keystore/UTC--2017-08-14T07-23-26.961758766Z--d79268b86aeb0996dad3ea2a9373e78fae512976";

		Credentials credentials = WalletUtils.loadCredentials(password, string);

		BigInteger gasPrice = new BigInteger("0");
		BigInteger gasLimit = new BigInteger("0");

		String _curator = "";
		BigInteger _proposalDeposit = new BigInteger("0");
		String _token = "";

		DAO dao = DAO.deploy(web3j, credentials, gasPrice, gasLimit, _curator, _proposalDeposit, _token).send();

		return dao;
	}

	/**
	 * アドレスと ABIの値から smart contractのledgerデータとアクセスする。
	 * 
	 * @return
	 */
	public DaoDecorator loadFromLedger(String contractAddress, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {

		DAO dao = DAO.load(contractAddress, this.web3j, credentials, gasPrice, gasLimit);

		
		DaoDecorator result = new DaoDecorator(dao);
		
		return result;

	}

}
