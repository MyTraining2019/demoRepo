package org.cap.test;

import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Customer;
import org.cap.exception.InsufficientBalanceException;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Contains;
import org.junit.*;


public class TestBankApp {
	
	@Mock
	private AccountDao accountDao;
	
	private AcccountService accountService;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		accountService=new AccountServiceImpl(accountDao);
	}

	/*@Rule
	public ExpectedException thrown=ExpectedException.none();
	
	@Test
	public void test() throws InvalidInitialAmountException {
		Customer customer=new Customer();
		
		thrown.expect(InvalidInitialAmountException.class);
		//thrown.expectMessage("Insufficient Balance");
		thrown.expectMessage(Matchers.contains("Balance"));
		
		//Actual Function
		accountService.addAccount(customer, 100);
	}*/
	
	
	@Rule
	public Timeout timeout;
	@Test
	public void test_sumnumbers(){
		timeout.millis(3);
		accountService.sumNumbers(100000);
	}
	
	
	@Test
	public void test_addAccount_with_validAccount() throws InvalidInitialAmountException{
		Account account=new Account();
		
		Customer customer=new Customer();
		
		customer.setCustName("Tom");
		account.setCustomer(customer);
		account.setAmount(5000);
		
		//Declaration
		Mockito.when(accountDao.createAccount(account)).thenReturn(true);
		
		//Actual Logic
		Account newAccount=accountService.addAccount(customer, 5000);
		
		//Verification
		Mockito.verify(accountDao).createAccount(account);
		
		assertEquals(account.getAmount(), newAccount.getAmount(),0.0);
	}
	
	
	
	@Test
	public void test_Find_byAccount_ID(){
		
		Account account=new Account();
		account.setAccountNo(1001);
		account.setAmount(4500);
		Customer customer=new Customer();
		customer.setCustName("Jack");
		account.setCustomer(customer);
		
		//declaration
		Mockito.when(accountDao.findAccountById(1001)).thenReturn(account);
		
		
		Account find_Acc=accountService.findAccountById(1001);
		
		//Mockito.verify(accountDao).findAccountById(1001);
		
		assertEquals(1001, find_Acc.getAccountNo());
	}
	
	
	@Test
	public void test_WithDrawMethod() throws InsufficientBalanceException{
		Account account=new Account();
		account.setAccountNo(1001);
		account.setAmount(4500);
		Customer customer=new Customer();
		customer.setCustName("Jack");
		account.setCustomer(customer);
		
		//declaration
		Mockito.when(accountDao.findAccountById(1001)).thenReturn(account);
		
		
		//Acutal
		Account mAccount=accountService.withdraw(1001, 500);
		
		
		//Verify
		Mockito.verify(accountDao).findAccountById(1001);
		assertEquals(4000, mAccount.getAmount(),0.0);
	}
	
	
	
	
	
	
	
	
	

}
