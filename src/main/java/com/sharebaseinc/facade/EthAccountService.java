package com.sharebaseinc.facade;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import com.sharebaseinc.wallet.User;
import com.sharebaseinc.wallet.repository.UserWalletAddressRepository;
import com.sharebaseinc.wallet.repository.entity.UserWalletAddressEntity;

@Service
public class EthAccountService {
	

	@Value("${ethereum.wallet.dir:~/.ethereum/keystore/}") 
	private String walletDirPath;
	
	@Autowired
	private AccountRepository accountRepsoitry;
	
	@Autowired
	private UserWalletAddressRepository uwaRepository;
	
	
	public List<Pair<String,String>> getAccounts(User user) {
		
		
		
		String userId = user.getUserId();
		
		 List<Pair<String,String>>  arrayList = accountRepsoitry.getEthAccounts(userId);
		

		return arrayList ;
	};
	
	
	
	public List<UserWalletAddressEntity> getWalletAddress(User user){
		
		return uwaRepository.find(user.getUserId());
	}
	
	
	public void getWalletCredential(User user,String password) throws IOException, CipherException{
		
		List<UserWalletAddressEntity> e =this.getWalletAddress(user);
		String address = e.get(0).getAddress();
		
		String source = walletDirPath + address;
		Credentials credential = WalletUtils.loadCredentials(password, source);
	}
	
	

}
