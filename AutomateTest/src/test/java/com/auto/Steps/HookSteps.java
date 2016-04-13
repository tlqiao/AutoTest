package com.auto.Steps;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tlqiao on 4/12/16.
 */
public class HookSteps {
	@Autowired
	WebDriver webDriver;

	@After
	public void close()
	{
		webDriver.close();
		webDriver.quit();
	}

}
