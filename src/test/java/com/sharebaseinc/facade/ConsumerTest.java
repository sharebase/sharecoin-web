package com.sharebaseinc.facade;

import java.util.function.Consumer;

public class ConsumerTest implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		
		System.out.println(" get " + t);
		
	}
	
	

}
