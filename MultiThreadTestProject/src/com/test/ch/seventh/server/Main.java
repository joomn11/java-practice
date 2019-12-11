package com.test.ch.seventh.server;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			new MiniServer(8080).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
