package com.sharebaseinc.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import org.junit.Test;

public class FuncEAMUtilTest {

	@Test
	public void test() {
		
		
		String[] hogehoge = {"aaa" ,"bbb"};
	
		ArrayList<String> as = new ArrayList<String>();
		Collections.addAll(as, hogehoge);
		
		Stream<String> s = as.stream();
		
		s.peek(x -> System.out.println(x)).filter(x-> x.length() > 1);
	}

}
