# aqs  AbstractQueuedSynchronizer

### LockSupport

详见 cn.myroute.aqs.AqsCommon

LockSupport可用于实现阻塞一个线程和唤醒

LockSupport.park()
LockSupport.park(Object)
LockSupport.parkNanos(Object, long)
LockSupport.parkNanos(long)
LockSupport.parkUntil(Object, long)
LockSupport.parkUntil(long)
LockSupport.unpark(Thread)
            
### ReentrantLock

详见 cn.myroute.aqs.AqsCommon

Lock lock = new ReentrantLock(boolean fair);

可用于实现公平锁(fifo)或非公平锁，非公平锁性能高一点，因为可能少一些暂停再启动。

http://www.blogjava.net/xylz/archive/2010/07/07/325410.html
http://www.blogjava.net/xylz/archive/2010/07/05/325274.html
http://www.blogjava.net/xylz/archive/2010/07/06/325390.html
http://ifeve.com/java-special-troops-aqs/


### thread.interrupt

详见 cn.myroute.aqs.InterruptCommon

>thread.interrupt()  中断thread的线程，标记为true
>
> Thread.interrupted() 返回当前线程的中断标记，并清楚
> 
> InterruptedException  抛出中断异常，中断操作
>









