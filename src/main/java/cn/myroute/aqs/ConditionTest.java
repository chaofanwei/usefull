package cn.myroute.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

	   final Lock lock = new ReentrantLock();
	   final Condition notFull  = lock.newCondition(); 
	   final Condition notEmpty = lock.newCondition(); 

	   final Object[] items = new Object[100];
	   int putptr, takeptr, count;

	   public static void main(String[] args) {
		   final ConditionTest conditionTest = new ConditionTest();
		   
		   Runnable pro= new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					try {
						conditionTest.put(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		Runnable cons= new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					try {
						System.out.println(conditionTest.take());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		
//		new Thread(pro).start();
//		new Thread(pro).start();
		new Thread(cons).start();
		new Thread(cons).start();
		new Thread(cons).start();
		new Thread(cons).start();
		
	   }
	   
	   public void put(Object x) throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == items.length)
	         notFull.await();
	       items[putptr] = x;
	       if (++putptr == items.length) putptr = 0;
	       ++count;
	       notEmpty.signal();
	     } finally {
	       lock.unlock();
	     }
	   }

	   public Object take() throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == 0)
	         notEmpty.await();
	       Object x = items[takeptr];
	       if (++takeptr == items.length) takeptr = 0;
	       --count;
	       notFull.signal();
	       return x;
	     } finally {
	       lock.unlock();
	     }
	   }
	   
}
