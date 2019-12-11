package com.test.ch.seventh.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MiniServer {
	private final int portnumber;
	
	public MiniServer(int portnumber) {
		this.portnumber = portnumber;
	}
	
	public void execute() throws IOException {
		ServerSocket serverSocket = new ServerSocket(portnumber);
		System.out.println("Listening on" + serverSocket);
		
		try {
			while (true) {
				System.out.println("Acception...");
				Socket clientSocket = serverSocket.accept();
				System.out.println("Connected to " + clientSocket);
				
				new Thread() {
					public void run() {
						try {
							Service.service(clientSocket);
						} catch (IOException e) {
							e.printStackTrace();
						}
					};
				}.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			serverSocket.close();
		}
	}
}
