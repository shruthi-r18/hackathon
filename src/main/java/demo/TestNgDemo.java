package demo;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

public class TestNgDemo {
	
//	Default priority as 0
//	A-Z, a-z, 0-9
//	Priorities can be from -ve to +ve
	@Test(priority = 1)
	public void login1() {
		System.out.println("home ... ");
	}
	
	@Test(priority = 1)
	public void login2() {
		System.out.println("login .... ");
//		throw new NoSuchElementException();
	}
	
	@Test (priority = 1)
	public void accounts() {
		System.out.println("accounts.... ");
	}
	
	@Test (priority = -1)
	public void opportunities() {
		System.out.println("opportunities... ");
	}
	
}
