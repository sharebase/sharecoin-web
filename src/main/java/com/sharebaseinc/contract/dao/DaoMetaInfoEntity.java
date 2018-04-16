package com.sharebaseinc.contract.dao;


/**
 * DAOのメタ情報をもたせる BinaryInterface情報
 * 
 *	address 情報
 * 
 * 
 * 
 * @author kouichi
 *
 */
public class DaoMetaInfoEntity {
	
	
	/**
	 * 
	 */
	private String address;

	private String applicationBinaryInterface;
	
	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getBinaryInterface() {
		return applicationBinaryInterface;
	}


	public void setBinaryInterface(String binaryInterface) {
		this.applicationBinaryInterface = binaryInterface;
	}


	
	
	

}
