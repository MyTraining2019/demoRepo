package org.cap.test;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class ConsoleRunner {

	public static void main(String[] args) {
		JUnitCore core=new JUnitCore();
		core.addListener(new TextListener(System.out));
		
		core.run(TestBankApp.class);
	}

}
