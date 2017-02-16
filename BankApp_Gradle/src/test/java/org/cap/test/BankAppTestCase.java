package org.cap.test;

import static org.junit.Assert.*;

import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BankAppTestCase {
	
	private AcccountService accountService;
	
	@BeforeClass
	public static void init(){
		//System.out.println("Before class Method");
	}
	
	@AfterClass
	public static void destroy(){
		//System.out.println("After class Method");
	} 
	@Before
	public void setUp(){
		//System.out.println("Before Method");
		accountService=new AccountServiceImpl();
	}
	
	@After
	public void tearDown(){
		//System.out.println("After Method");
		accountService=null;
	}

	@Category(GoodTestCategory.class)
	@Test
	public void test_addNumbers() {
		assertEquals(10, accountService.addNumbers(10, 20));
	}
	
	@Category(GoodTestCategory.class)
	@Test(expected=IllegalArgumentException.class)
	public void test_customer_with_null_addAccount() throws InvalidInitialAmountException{
		Customer customer=null;
		accountService.addAccount(customer, 10000);
	}
	
	
	@Category(BadTestCategory.class)
	@Test(expected=InvalidInitialAmountException.class)
	public void test_addAccount_with_invalid_inital_Amount() throws InvalidInitialAmountException{
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		accountService.addAccount(customer, 100);
	}
	
	
	@Category(GoodTestCategory.class)
	@Test(timeout=5)
	//@Ignore
	public void test_SumNumbers_Method(){
		assertEquals(3, accountService.sumNumbers(3));
	}

}
