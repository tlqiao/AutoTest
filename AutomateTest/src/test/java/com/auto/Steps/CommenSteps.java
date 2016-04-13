package com.auto.Steps;

import com.auto.Pages.Home.Homepage;
import com.auto.Pages.Login.LoginPage;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tlqiao on 4/12/16.
 */
@Component
public class CommenSteps{

	@Autowired
	LoginPage loginPage;
	@Autowired
	Homepage homePage;

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public Homepage getHomepage() {
		return homePage;
	}

}
