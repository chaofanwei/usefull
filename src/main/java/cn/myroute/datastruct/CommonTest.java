package cn.myroute.datastruct;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

import org.junit.Test;

public class CommonTest {
	
	@Test
	public void testD(){
		int i=1;
		int j=1;
		
		
		System.out.println(i<<8);
		System.out.println((i<<8 )+ j);
		System.out.println(i<<8 | j);
		
		
	}
	@Test
	public void testAnd(){
		int size= 4;
		
//		System.out.println(Long.toBinaryString(size));
//		System.out.println(Long.toBinaryString(5));
//		System.out.println(Long.toBinaryString(7));
		
		System.out.println(0%size);
		System.out.println(3%size);
		System.out.println(5%size);
		System.out.println(7%size);
		
		System.out.println();
		
		
		System.out.println(0 & (size-1));
		System.out.println(3 & (size-1));
		System.out.println(4 & (size-1));
		System.out.println(5 & (size-1));
		System.out.println(7 & (size-1));
		
	}
	
	@Test
	public void testConcurrentSkipListMap(){
		ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();
		
		map.put("key1", "val1");
		
		ConcurrentSkipListSet<String> css = new ConcurrentSkipListSet<>();
		
	}
	@Test
	public void testLock(){
		Map<String, String> map = new HashMap<>();
		map.put("key1", "val1");
		map.put("key2", "val2");
		map.put("key1", "val3");
		
		
		
	}
}
