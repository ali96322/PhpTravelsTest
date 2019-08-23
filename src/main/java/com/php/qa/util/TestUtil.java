package com.php.qa.util;

import com.php.qa.base.TestBase;

public class TestUtil extends TestBase
{
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 40;
	
	public void switchToFrame(String name)
	{
		driver.switchTo().frame(name);
	}
	
}
