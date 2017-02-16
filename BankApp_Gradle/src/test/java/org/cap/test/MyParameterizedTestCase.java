package org.cap.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyParameterizedTestCase {

	
	private AcccountService accService=new AccountServiceImpl();
	private int input1;
	private int input2;
	private int output;
	
	
	public MyParameterizedTestCase(int input1, int input2,int output) {
		
		this.input1 = input1;
		this.input2 = input2;
		this.output = output;
	}
	
	@Parameters
	public static List<Object[]> myParameters(){
		return Arrays.asList(new Object[][]{
			{1,1,2},
			{0,0,0},
			{4,8,12},
			{-1,-2,-3},
			{0,2,2}
		});
	}
	
	
	@Test
	public void test_AddNumbers(){
		
	 assertEquals(output, accService.addNumbers(input1, input2));
	}
	
	
}
