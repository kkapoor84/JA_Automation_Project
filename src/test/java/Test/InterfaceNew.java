package Test;

import org.testng.annotations.Test;

public interface InterfaceNew {
	
/*	@Test
	public void method1();*/
	
	@Test
	public static void method2()
	{
		System.out.println("static method");
	}
	
	@Test
	public default void method3()
	{
		System.out.println("default method");
	}

}


