package com.sharebaseinc.wallet.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="UserWalletAddressEntity")
public class UserWalletAddressEntity {
	
	@Column
	private String userId;
	
	@Column
	@Id
	private String address;
	
	@Column
	private String keyPath;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getKeyPath() {
		return keyPath;
	}

	public void setKeyPath(String keyPath) {
		this.keyPath = keyPath;
	}
	
	

}
