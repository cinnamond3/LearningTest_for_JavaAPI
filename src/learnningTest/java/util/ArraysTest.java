package learnningTest.java.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class ArraysTest {

	@Test
	public void test_copyOf() {
		char[] original = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '!'};
		
		assertArrayEquals("hello".toCharArray(), Arrays.copyOf(original, 5));
		assertArrayEquals("hello world".toCharArray(), Arrays.copyOf(original, 11));
	}
	
	@Test
	public void test_copyOfRange() {
		char[] original = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '!'};
		
		assertArrayEquals("hello".toCharArray(), Arrays.copyOfRange(original, 0, 5));
		assertArrayEquals("world".toCharArray(), Arrays.copyOfRange(original, 6, 11));
	}
	
	@Test
	public void test_asList_char_array() {
		List<Character> expected = new ArrayList<Character>(){{
			add('h');
			add('e');
			add('l');
			add('l');
			add('o');
			add(' ');
			add('w');
			add('o');
			add('r');
			add('l');
			add('d');
			add('!');
		}};
		
		assertEquals(expected, Arrays.asList('h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '!'));
	}
	
	@Test
	public void test_asList_int_array() {
		List<Integer> expected = new ArrayList<Integer>(){{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
		}};
		
		assertEquals(expected, Arrays.asList(1, 2, 3, 4, 5));
	}
	
	@Test
	public void test_asList_string() {
		List<String> expected = new ArrayList<String>() {{
			add("h");
			add("e");
			add("l");
			add("l");
			add("o");
			add(" ");
			add("w");
			add("o");
			add("r");
			add("l");
			add("d");
			add("!");
		}};
		
		assertEquals(expected, Arrays.asList("h", "e", "l", "l", "o", " ", "w", "o", "r", "l", "d", "!"));
	}

	@Test(expected=UnsupportedOperationException.class)
	public void test_asList_unmodifiable() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.add(6);
	}
	
	@Test
	public void test_asList_unmodifiable_solve() {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		list.add(6);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), list);
	}

	@Test
	public void test_equals() {
		int[] a = {1, 2, 3};
		int[] a2 = {1, 2, 3};
		
		assertTrue(Arrays.equals(a, a2));
	}
	
	@Test
	public void test_equals2() {
		String[] a = {"1", "2", "3"};
		String[] a2 = {"1", "2", "3"};
		
		assertFalse(a.equals(a2));
	}
	
	@Test
	public void test_deepEquals() {
		Integer[] a = {1, 2, 3};
		Integer[] a2 = {1, 2, 3};
		
		assertTrue(Arrays.deepEquals(a, a2));
	}
	
	@Test
	public void test_sort_int() {
		int[] a = {3, 2, 4, 1, 5};
		
		Arrays.sort(a);
		
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, a);
	}
	
	@Test
	public void test_sort_char() {
		char[] a = {'l', 'o', 'h', 'e', 'l'};
		
		Arrays.sort(a);
		
		assertArrayEquals(new char[]{'e', 'h', 'l', 'l', 'o'}, a);
	}
	
	@Test
	public void test_sort_int_from_to() {
		int[] a = {3, 2, 4, 1, 5};
		
		Arrays.sort(a, 2, 4);
		
		assertArrayEquals(new int[]{3, 2, 1, 4, 5}, a);
	}
	
	@Test
	public void test_sort_with_comparator() {
		Integer[] a = {3, 2, 4, 1, 5};
		
		class MyComparator implements Comparator<Integer> {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		}
		
		Arrays.sort(a, new MyComparator());
		
		assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
	}
	
	@Test
	public void test_sort_with_comparator2() {
		Integer[] a = {3, 2, 4, 1, 5};
		
		Arrays.sort(a, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
	}
	
	@Test
	public void test_sort_with_comparator3() {
		Integer[] a = {3, 2, 4, 1, 5};
		
		Arrays.sort(a, (Integer o1, Integer o2) -> { return o1.compareTo(o2); });
		
		assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, a);
	}
}
