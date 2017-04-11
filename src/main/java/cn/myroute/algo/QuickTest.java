package cn.myroute.algo;

import org.junit.Test;


/**
 * 快排
 * @author wei
 *
 */
public class QuickTest {
	int[] data = new int[]{6,2,5,9,8,11,41,1,24,3};
	
	@Test
	public void test1(){
		
		quickSort(data,0,data.length-1);
		
		MergeTest.toString(data);
	}
	
	void quickSort(int[] dat,int s,int e){
		if(s<=e){
			int m = sort(data,s,e);
			System.out.println(m);
			MergeTest.toString(data);
			quickSort(data,s,m-1);
			quickSort(data,m+1,e);
		}
	}
	
	
	int sort(int[] dat,int s,int e){
		
		int temp=dat[s];
		
		int l=s;
		int r=e;
		while(l < r){
			while(l<=e && dat[l] <= temp){
				l++;
			}
			
			while(r>=s && dat[r] > temp){
				r--;
			}
			
			if(l<r) swap(dat, l, r);
		}
		
		if(s<r) swap(dat, r, s);
		
		return r;
		
	}
	
	void swap(int[] dat ,int i,int j){
		
		dat[i]=dat[i] ^ dat[j];
		dat[j]=dat[i] ^ dat[j];
		dat[i]=dat[i] ^ dat[j];
		
	}
	void swap2(int[] dat ,int i,int j){
		int temp=dat[i];
		dat[i]=dat[j];
		dat[j]=temp;
	}
	
}
