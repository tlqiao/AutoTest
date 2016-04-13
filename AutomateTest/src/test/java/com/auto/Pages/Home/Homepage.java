package com.auto.Pages.Home;

import com.auto.common.AutoTest;
import org.springframework.stereotype.Component;

/**
 * Created by tlqiao on 4/12/16.
 */
@Component
public class Homepage extends AutoTest {

	public void NavigateHomePage(String url)
	{
		super.open(url);
	}
}
