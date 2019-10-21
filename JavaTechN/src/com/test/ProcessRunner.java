package com.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.function.Consumer;

public class ProcessRunner {
	public static void main(String[] args) throws Throwable {
		String[] command = new String[] {"echo", "hello"};
		
		ProcessRunner runner = new ProcessRunner();
		runner.byRuntime(command);
		
		runner.byProcessBuilder(command);
		
		Consumer<String> f1 = System.out::println;
	}
	
	public void byRuntime(String[] command) throws Throwable {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(command);
		printStream(process);
	}
	
	public void byProcessBuilder(String[] command) throws Throwable {
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.start();
		printStream(process);
	}
	
	private void printStream(Process process) throws InterruptedException, Throwable {
		process.waitFor();
		try(InputStream psout = process.getInputStream()) {
			copy(psout, System.out);
		}
	}
	
	public void copy (InputStream input, OutputStream output) throws Throwable {
		byte[] buffer = new byte[1024];
		int n= 0;
		
		while((n = input.read(buffer)) != -1) {
			output.write(buffer, 0, n);
		}
	}
}
