package com.test.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory{

	private static final ConcurrentHashMap<String, AtomicInteger> POOL_NUMBER = 
			new ConcurrentHashMap<>();
	
	private final ThreadGroup group;
	private final AtomicInteger threadNumber = new AtomicInteger(1);
	private final String namePrefix;
	
	public MyThreadFactory(String threadPoolName) {
		if (threadPoolName == null) {
			throw new NullPointerException("threadPoolName");
		}
		
		POOL_NUMBER.putIfAbsent(threadPoolName, new AtomicInteger());
		
		SecurityManager securityManager = System.getSecurityManager();
		group = (securityManager != null) ? securityManager.getThreadGroup() : 
			Thread.currentThread().getThreadGroup();
		
		AtomicInteger poolCnt = POOL_NUMBER.get(threadPoolName);
		
		if (poolCnt == null) {
			namePrefix = threadPoolName + " pool-00-thread-";
		} else {
			namePrefix = threadPoolName + " pool-" + poolCnt.getAndIncrement() + "-thread-";
		}
	}
	
	
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
		
		if (thread.isDaemon()) 
			thread.setDaemon(false);
		
		if (thread.getPriority() != Thread.NORM_PRIORITY) 
			thread.setPriority(Thread.NORM_PRIORITY);
		
		return thread;
	}

}
