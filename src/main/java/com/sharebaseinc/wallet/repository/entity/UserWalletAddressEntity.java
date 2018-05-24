package com.sharebaseinc.wallet.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserWalletAddressEntity {
	
	@Column
	private String userId;
	
	@Column
	@Id
	private String address;
	
	@Column
	private String keyPath;
	
	

}
