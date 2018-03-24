package com.sharebaseinc.facade;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;

import com.sharebaseinc.contract.DAO;

@Service
public class DaoBusinessFacade {

	private DAO dao;
	
	@Autowired
	private Web3j web3j;
	
	
	

	public Web3j getWeb3j(){
		return web3j;
	}
	
	public void summaryDaoContract(){
		
		
		dao.verifyPreSupport(BigInteger.ONE);
		
	}
	
	
	

}
