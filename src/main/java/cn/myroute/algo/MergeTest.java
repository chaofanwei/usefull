package cn.myroute.algo;

import org.junit.Test;

/**
 * 归并排序
 * @author wei
 *
 */
public class MergeTest {

	int[] data = new int[]{6,2,5,9,8,11,41,33,24,7};
	
	@Test
	public void test2(){
		
	}
	
	void mergeSort(int[] dat,int start,int end){
		int m=(start + end) / 2;
		mergeSort(dat,start,m);
		mergeSort(dat,m,end);
		
		
		int temp = 0;
		
		//......new一个数组
	}
	
	
	
	@Test
	public void test1(){
		int[] a = new int[]{4,6,9};
		int[] b = new int[]{1,2,3};
		
		int[] c = new int[a.length+b.length];
		int m, n ; 
		m=n=0;
		
		for(int i = 0;i<c.length;i++){
			//c[i]=a[m]<b[n] ? a[m++] : b[n++];
			if(m>=a.length){
				c[i]=b[n++];
				continue;
			}
			if(n>=b.length){
				c[i]=a[m++];
				continue;
			}
			int aa=a[m];
			int bb=b[n];
			
			if(aa< bb){
				c[i]=a[m++];
			}else{
				c[i]=b[n++];
			}
		}
		toString(c);
	}
	
	
	public static void toString(int[] data){
		for(int i=0;i<data.length;i++)
			System.out.print(data[i]+"\t");
		System.out.println();
	}
}
