package com.sharebaseinc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.admin.Admin;

@Service
public class Web3jAdminFacade {
	
	@Autowired
	private Admin admin;

	/**
	 * 
	 */
	public void createAccount() {

	}
}
