package com.test.ch.sixth.strategy;

public class Data {
	private final ReadWriteLock lock ;
	private final ReadWriteStrategy readWriteStrategy;
	
	public Data() {
		this.lock = new ReadWriteLock(new DefaultGuardStrategy());
		this.readWriteStrategy = new DefaultReadWriteStrategy();
	}
	
	public Data(GuardStrategy guardStrategy, ReadWriteStrategy readWriteStrategy) {
		this.lock = new ReadWriteLock(guardStrategy);
		this.readWriteStrategy = readWriteStrategy;
	}
	
	public Object read() throws InterruptedException {
		lock.readLock();
		try {
			return readWriteStrategy.doRead();
		} finally {
			lock.readUnlock();
		}
	}
	
	public void write(Object c) throws InterruptedException{
		lock.writeLock();
		try {
			readWriteStrategy.doWrite(c);
		} finally {
			lock.writeUnlock();
		}
	}
	
	private class ReadWriteLock {
		private final GuardStrategy guardStrategy;
		
		public ReadWriteLock(GuardStrategy guardStrategy) {
			this.guardStrategy = guardStrategy;
		}
		
		public synchronized void readLock() throws InterruptedException {
			guardStrategy.beforeReadWait();
			try {
				while(!guardStrategy.readGuard()){
					wait();
				}
			} finally {
				guardStrategy.afterReadWait();
			}
			guardStrategy.beforeDoRead();
		}
		
		public synchronized void readUnlock() throws InterruptedException {
			guardStrategy.afterDoRead();
			notifyAll();
		}
		
		public synchronized void writeLock() throws InterruptedException {
			guardStrategy.beforeWriteWait();
			try {
				while (!guardStrategy.writeGuard()) {
					wait();
				}
			} finally {
				guardStrategy.afterWriteWait();
			}
			guardStrategy.beforeDoWrite();
		}
		
		public synchronized void writeUnlock() throws InterruptedException {
			guardStrategy.afterDoWrite();
			notifyAll();
		}
	}
	
	private class DefaultGuardStrategy implements GuardStrategy {
		private int readingReaders = 0;
		private int writingWriters = 0;
		private int waitingWriters = 0;
		private boolean preferWriter = true;
		
		@Override
		public void beforeReadWait() {
		}

		@Override
		public boolean readGuard() {
			return ((writingWriters > 0) || (preferWriter && waitingWriters > 0)) ? false : true;
		}

		@Override
		public void afterReadWait() {
		}

		@Override
		public void beforeDoRead() {
			readingReaders++;
			
		}

		@Override
		public void afterDoRead() {
			readingReaders--;
			preferWriter = true;
		}

		@Override
		public void beforeWriteWait() {
			waitingWriters++;
			
		}

		@Override
		public boolean writeGuard() {
			return ((readingReaders > 0) || writingWriters >0 ) ? false : true;
		}

		@Override
		public void afterWriteWait() {
			waitingWriters--;
		}

		@Override
		public void beforeDoWrite() {
			writingWriters++;
			
		}

		@Override
		public void afterDoWrite() {
			writingWriters--;
			preferWriter = false;
		}
	}
	
	private class DefaultReadWriteStrategy implements ReadWriteStrategy {
		private final char[] buffer;
		
		public DefaultReadWriteStrategy() {
			this(10);
		}
		
		public DefaultReadWriteStrategy(int size ){
			this.buffer = new char[size];
		}
		
		@Override
		public Object doRead() throws InterruptedException {
			char[] newbuf = new char[buffer.length];
			for(int i=0; i<buffer.length; i++) {
				newbuf[i] = buffer[i];
			}
			slowly();
			return newbuf;
		}

		@Override
		public void doWrite(Object arg) throws InterruptedException {
			char c = ((Character)arg).charValue();
			
			for(int i=0; i<buffer.length; i++) {
				buffer[i] = c;
				slowly();
			}
		}
		private void slowly() {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
