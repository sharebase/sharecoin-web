package com.sharebaseinc.transaction.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * transactiondataの保存
 * 
 */
@Entity
public class EthTransactionEntity {

	@Id
	private String hash;
	
	private String nonce;
	private String blockHash;
	private String blockNumber;
	private String transactionIndex;
	private String from;
	private String to;
	private String value;
	private String gasPrice;
	private String gas;
	private String input;
	private String creates;
	private String publicKey;
	private String raw;
	private String r;
	private String s;
	
	private int v;
	
	
	

}
