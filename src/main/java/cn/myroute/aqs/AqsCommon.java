package cn.myroute.aqs;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class AqsCommon {

	@Test
	public void testLock(){
		
		List list;
		
		Lock lock = new ReentrantLock();
		
		ExecutorService service =  Executors.newFixedThreadPool(300);
		
		for(int i=0;i<10;i++){
			service.submit(new Runnable() {
				
				@Override
				public void run() {
					String name = Thread.currentThread().getName() + "_"+Thread.currentThread().getId();
					
					
					lock.lock();
					System.out.println("thread : "+ name +" lock");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("thread : "+ name +" unlock");
					
					lock.unlock();
					
				}
			});
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test1(){
		FIFOMutex fifo = new FIFOMutex();
		
		ExecutorService service =  Executors.newFixedThreadPool(300);
		
		for(int i=0;i<10;i++){
			service.submit(new Runnable() {
				
				@Override
				public void run() {
					String name = Thread.currentThread().getName() + "_"+Thread.currentThread().getId();
					System.out.println("thread : "+ name +" begin");
					
					fifo.lock();
					
					System.out.println("thread : "+ name +" end");
				}
			});
		}
		
		
	}
	
	class FIFOMutex {
		   private final AtomicBoolean locked = new AtomicBoolean(false);
		   private final Queue<Thread> waiters   = new ConcurrentLinkedQueue();

		   public void lock() {
		     boolean wasInterrupted = false;
		     Thread current = Thread.currentThread();
		     waiters.add(current);

		     // Block while not first in queue or cannot acquire lock
		     while (waiters.peek() != current || !locked.compareAndSet(false, true)) {
		       LockSupport.park(this);
		       if (Thread.interrupted()) // ignore interrupts while waiting
		         wasInterrupted = true;
		     }

		     waiters.remove();
		     if (wasInterrupted)          // reassert interrupt status on exit
		       current.interrupt();
		   }

		   public void unlock() {
		     locked.set(false);
		     LockSupport.unpark(waiters.peek());
		   }
		 }
}
