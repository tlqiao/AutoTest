package com.auto.common;

import com.google.common.base.Function;
import cucumber.api.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by tlqiao on 3/24/16.
 */
@Component
public class AutoTest {
	@Autowired
	WebDriver webDriver;

	public AutoTest() {
		System.setProperty("webdriver.chrome.driver", "/Users/tlqiao/project/AutomateTest/Native/chromedriver");
	}

	public WebElement findElement(String locator) {
		if (locator.startsWith("xpath")) {
			return webDriver.findElement(By.xpath(locator.substring(6)));
		} else if (locator.startsWith("id")) {
			return webDriver.findElement(By.id(locator.substring(3)));
		} else if (locator.startsWith("linkText")) {
			return webDriver.findElement(By.linkText(locator.substring(8)));
		} else if (locator.startsWith("name")) {
			return webDriver.findElement(By.name(locator.substring(5)));
		} else if (locator.startsWith("className")) {
			return webDriver.findElement(By.className(locator.substring(10)));
		} else if (locator.startsWith("tagName")) {
			return webDriver.findElement(By.tagName(locator.substring(8)));
		} else if (locator.startsWith("select")) {
			return webDriver.findElement(By.cssSelector(locator.substring(7)));

		}
		return null;
	}

	public void open(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/tlqiao/project/AutomateTest/Native/chromedriver");
		webDriver.get(url);
	}

	public void sleep(long mill) {
		try {
			Thread.sleep(mill);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForElement(String locator, long timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locator.substring(4))));
	}

	public void waitElement(String locator) {
		for (int i = 0; i < 30; i++) {
			sleep(1000);
			try {
				findElement(locator).isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void waitForElementDisplay(String locator, Long timeOutInSecond) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSecond);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				return findElement(locator).isDisplayed();
			}
		});
	}

	public void waitForElementPresent(String locator, Long timeOutInSecond) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSecond);
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver webDriver) {
				return findElement(locator);
			}
		});
	}

	public Set<String> getWindowHandlers() {
		Set<String> windowHandlers = webDriver.getWindowHandles();
		for (int i = 0; i < 10; i++) {
			if (windowHandlers.size() == 1) {
				sleep(1000);
				windowHandlers = webDriver.getWindowHandles();
			} else {
				break;
			}
		}
		return windowHandlers;
	}

	public WebDriver selectSubWindow() {
		String currentWindow = webDriver.getWindowHandle();
		Set<String> windowHandlers = getWindowHandlers();
		for (String windowHandler : windowHandlers) {
			if (!currentWindow.equals(windowHandler)) {
				return webDriver.switchTo().window(windowHandler);

			}
		}
		return webDriver;
	}

	public void verifyMessageBox(String textlocator, String expectedMessage) {
		String windowHandle = webDriver.getWindowHandle();
		selectSubWindow();
		String realText = findElement(textlocator).getText().trim();
		assert (realText.equals(expectedMessage));
		webDriver.switchTo().alert().dismiss();
		webDriver.switchTo().window(windowHandle);
	}

	public Boolean isTextExist(String text) {
		return webDriver.getPageSource().contains(text);
	}

	public Boolean isTitleExist(String title) {
		return webDriver.getTitle().contains(title);
	}

}
