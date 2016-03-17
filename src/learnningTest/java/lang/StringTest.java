package learnningTest.java.lang;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class StringTest {

	@Test
	public void test_toCharArray() {
		String str = "Hello World!";
		char[] charArray1 = str.toCharArray();
		char[] charArray2 = str.toCharArray();
		
		String str2 = "Hello World!";
		char[] charArray3 = str2.toCharArray();
		
		char[] expected = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
		
		assertArrayEquals(expected, charArray1);
		assertTrue(charArray1.equals(charArray1));
		assertFalse(charArray1.equals(charArray2));
		
		assertFalse(charArray1.equals(charArray3));
		assertTrue(Arrays.equals(charArray1, charArray3));
	}

}
