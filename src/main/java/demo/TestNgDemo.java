package demo;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

public class TestNgDemo {
	
	@Test(priority = 3)
	public void login1() {
		System.out.println("home page ... ");
	}
	
	@Test(priority = 2)
	public void login2() {
		System.out.println("login page .... ");
	}
	
<<<<<<< HEAD
	@Test (priority = 1)
=======
	@Test (priority = 3)
>>>>>>> 9171585 (Final changes for bugfix)
	public void accounts() {
		System.out.println("accounts page.... ");
	}
	
<<<<<<< HEAD
	@Test ()
=======
	@Test (priority = 4)
>>>>>>> 9171585 (Final changes for bugfix)
	public void opportunities() {
		System.out.println("opportunities page... ");
	}
	
}
