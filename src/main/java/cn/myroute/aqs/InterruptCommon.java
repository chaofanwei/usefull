package cn.myroute.aqs;

import java.util.concurrent.locks.LockSupport;

import org.junit.Test;

public class InterruptCommon {
	@Test
	public void testLock(){
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("inner thread1 " + Thread.interrupted());
				System.out.println("inner thread2 " + Thread.interrupted());
				System.out.println("inner thread3 " + Thread.interrupted());
				LockSupport.park(this);
				System.out.println("inner thread4 " + Thread.interrupted());
				System.out.println("inner thread5 " + Thread.interrupted());
				System.out.println("inner thread6 " + Thread.interrupted());
				System.out.println("inner thread7 " + Thread.interrupted());
				System.out.println("inner thread8 " + Thread.interrupted());
				System.out.println("inner thread9 " + Thread.interrupted());
				System.out.println("inner thread10 " + Thread.interrupted());
			}
		});
		
		t1.start();
		
		t1.interrupt();
		t1.interrupt();
		
		
		
	}
}
