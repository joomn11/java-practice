package com.test.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;

import com.sun.management.ThreadMXBean;

public class TestMBean {
	public static void main(String[] args) {
		ThreadMXBean mxBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
		long[] threadIds = mxBean.getAllThreadIds();
		
		ThreadInfo[] threadInfos = mxBean.getThreadInfo(threadIds);
		
		for ( ThreadInfo threadInfo : threadInfos) {
			System.out.println(threadInfo.getThreadName());
			
			System.out.println(threadInfo.getBlockedCount());
			
			System.out.println(threadInfo.getBlockedTime());
			
			System.out.println(threadInfo.getWaitedCount());
			
			System.out.println(threadInfo.getWaitedTime());
		}
	}
}
