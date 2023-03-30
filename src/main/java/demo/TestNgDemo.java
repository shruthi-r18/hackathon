package demo;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

public class TestNgDemo {
	
	@Test(priority = 1)
	public void login1() {
		System.out.println("home page ... ");
	}
	
	@Test(priority = 1)
	public void login2() {
		System.out.println("login page .... ");
	}
	
	@Test (priority = 2)
	public void accounts() {
		System.out.println("accounts.... ");
	}
	
	@Test (priority = -1)
	public void opportunities() {
		System.out.println("opportunities... ");
	}
	
}