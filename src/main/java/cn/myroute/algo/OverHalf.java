package cn.myroute.algo;

import org.junit.Test;

/**
 * 从一个数组里面寻找一个出现过半的数
 * @author wei
 *
 */
public class OverHalf {

	@Test
	public void testCommon() {
		int[] data = new int[]{1,2,1,2,1,2,1};
		data=new int[]{1,2,1};
		data=new int[]{1,2,3};
		data=new int[]{1,1,1,2,2,2,2};
		
		System.out.println(process(data));
		
	}
	
	public int process(int[] data){
		int n=-1;
		int count=0;
		
		for(int d : data){
			if(count == 0){
				n=d;
				count++;
			}else if (d == n) {
				count++;
			}else {
				count--;
			}
		}
		//System.out.println(n+" ,"+totalCount+"/"+data.length);
		return n;
	}
	
}
