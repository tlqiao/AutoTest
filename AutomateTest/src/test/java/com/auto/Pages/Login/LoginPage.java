package com.auto.Pages.Login;

import com.auto.common.AutoTest;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;


/**
 * Created by tlqiao on 4/12/16.
 */
@Component
public class LoginPage extends AutoTest {
	String userNameLocator="id=ls_username";
	String passwordLocator="id=ls_password";
	String loginButtonLocator="xpath=//*[@id='lsform']/div/div/table/tbody/tr[2]/td[3]/button";
	String loginUserNameLocator="xpath=//*[@id='um']/p[1]/strong/a";
	public void loginDiscuz(String userName,String password)
	{
		findElement(userNameLocator).sendKeys(userName);
		findElement(passwordLocator).sendKeys(password);
		findElement(loginButtonLocator).click();
	}
	public void loginSuccess()
	{
		assert isLoginSuccess();
	}
	public void loginFailed()
	{
		assert !isLoginSuccess();
	}
	private boolean isLoginSuccess()
	{
		if (!findElement(loginUserNameLocator).getText().isEmpty())
			return true;
		else return false;
	}

}
