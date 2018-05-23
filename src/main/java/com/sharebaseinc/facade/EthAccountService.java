package com.sharebaseinc.facade;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharebaseinc.wallet.User;

@Service
public class EthAccountService {
	
	@Autowired
	private AccountRepository accountRepsoitry;
	
	
	public List<Pair<String,String>> getAccounts(User user) {
		
		
		
		String userId = user.getUserId();
		
		 List<Pair<String,String>>  arrayList = accountRepsoitry.getEthAccounts(userId);
		

		return arrayList ;
	};
	
	
	
	

}
