package cn.myroute.algo;

import org.junit.Test;

/**
 * 堆排序
 * 分为大顶堆和小顶堆 ，本文为大顶堆，可用来试下数组顺序排序
 * 
 * 特长就是寻找topN
 * 
 * 构造初始堆-》调整堆
 * 
 * @author wei
 *
 */
public class HeapSort {

	int[] data = new int[]{6,2,5,9,8,11,41,33,24,7};
	
	@Test
	public void test2(){
		
		int length = data.length-1;
		
		int i=getParentIndex(length, length);
		
		for(;i>=0;i--){
			adjustHeap(data,length,i);
		}
		
		heapSort(data,length);
		
		System.out.println("result------");
		MergeTest.toString(data);
		
	}
	
	void heapSort(int[] dat,int length){
		while(length >0){
			toString(data);
			swap(dat, length, 0);
			length--;
			adjustHeap(data,length,0);
		}
	}
	
	
	void adjustHeap(int[] dat,int length,int parent){
		int p = dat[parent];
		int max=parent;
		int left = getLeftParent(parent);
		if(left<=length && dat[left] > dat[max]){
				max=left;
		}
		
		int right=getRightParent(parent);
		if(right<=length && dat[right] > dat[max]){
				max=right;
		}
		
		if(parent != max){
			swap(dat, max, parent);
			adjustHeap(dat, length, max);
		}
		
	}
	
	void swap(int[] dat ,int i,int j){
		
		dat[i]=dat[i] ^ dat[j];
		dat[j]=dat[i] ^ dat[j];
		dat[i]=dat[i] ^ dat[j];
		
	}

	
	int getLeftParent(int parent){
		return 2*parent + 1;
	}
	int getRightParent(int parent){
		return 2*parent + 2;
	}
	
	int getParentIndex(int length,int child){
		return (child - 1) >> 1;
	}
	
	public void toString(int[] dat) {
		int h = 1;
		int max= (int) Math.pow(2, h) -2;
		for(int i=0;i<dat.length;i++){
			if(i > max){
				h++;
				max= (int) Math.pow(2, h) -2;
				System.out.println();
			}
			
			System.out.print(dat[i]+"\t");
			
		}
		
		System.out.println();
		System.out.println();
		
	}
	
	
}
