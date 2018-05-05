package com.sharebaseinc.contract;

import java.math.BigInteger;

public class DaoDecorator {
	
	private DAO dao;
	


	public DaoDecorator(DAO dao2) {

		this.dao = dao2;
	
	
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getCurator() throws Exception {

		String curator = dao.curator().send();
		return curator;

	}

	/**
	 * 
	 * @return
	 */
	public String getAttribute() {

		String address = dao.getContractAddress();

		return address;
	}

	public BigInteger getActualBalance() throws Exception {

		BigInteger balance = dao.actualBalance().send();

		return balance;

	}

	private String contractAddress() {

		String contractAddress = dao.getContractAddress();

		return contractAddress;
	}

}
