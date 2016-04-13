package com.auto.Steps.Login;

import com.auto.Steps.CommenSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by tlqiao on 4/12/16.
 */
public class LoginSteps extends CommenSteps {
	@Given("^Open Discuz\"(.*)\"$")
	public void navigateHomePage(String url)
	{
		getHomepage().open(url);
	}
	@When("^Login in Discuz with \"(.*)\" and \"(.*)\"$")
	public void loginDiscuz(String userName,String password)
	{
		getLoginPage().loginDiscuz(userName, password);
	}

	@Then("^Login success$")
	public void loginSuccess()
	{
		getLoginPage().loginSuccess();
	}
}
