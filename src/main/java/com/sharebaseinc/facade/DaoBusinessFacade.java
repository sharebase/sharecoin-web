package com.sharebaseinc.facade;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;

import com.sharebaseinc.contract.DAO;

@Service
public class DaoBusinessFacade {

	private DAO dao;

	@Autowired
	private Web3j web3j;

	public void setAccount() throws Exception {

		String password = "";
		String string = "";

		Credentials credentials = WalletUtils.loadCredentials(password, string);

		BigInteger gasPrice = new BigInteger("0");
		BigInteger gasLimit = new BigInteger("0");

		String _curator = "";
		BigInteger _proposalDeposit = new BigInteger("0");
		String _token = "";

		DAO dao = DAO.deploy(web3j, credentials, gasPrice, gasLimit, _curator,_proposalDeposit, _token).send();
		
		
		dao.numberOfProposals().send();

	}

	public Web3j getWeb3j() {
		return web3j;
	}

	public void summaryDaoContract() {

		dao.verifyPreSupport(BigInteger.ONE);

	}

}
