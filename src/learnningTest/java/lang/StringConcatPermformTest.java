package learnningTest.java.lang;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringConcatPermformTest {

	private int repeatCount = 100000;
	
	@Test
	public void testStringConcatPerformance() {
		long startTime = System.currentTimeMillis();
		String result = "";
		for (int inx=0; inx<repeatCount; inx++) {
			result += "word";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("testStringConcatPerformance : " + (endTime - startTime));
		System.out.println("java.runtime.version" + System.getProperty("java.runtime.version"));
	}
	
	@Test
	public void testStringBufferPerformance() {
		long startTime = System.currentTimeMillis();
		StringBuffer result = new StringBuffer();
		for (int inx=0; inx<repeatCount; inx++) {
			result.append("word");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("testStringBufferPerformance : " + (endTime - startTime));
		System.out.println("java.runtime.version" + System.getProperty("java.runtime.version"));
	}
	
	@Test
	public void testStringBuilderPerformance() {
		long startTime = System.currentTimeMillis();
		StringBuilder result = new StringBuilder();
		for (int inx=0; inx<repeatCount; inx++) {
			result.append("word");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("testStringBuilderPerformance : " + (endTime - startTime));
		System.out.println("java.runtime.version" + System.getProperty("java.runtime.version"));
	}

}
