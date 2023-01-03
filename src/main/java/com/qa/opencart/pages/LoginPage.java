package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locator: OR

	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By logoutHeader = By.cssSelector("div#common-success h1");

	// 2. Page constructor

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		eleUtil = new ElementUtil(driver);
	}

	// 3. page actions

	@Step("get login page title")
	public String getLoginPageTitle() {

		// return driver.getTitle();

		return eleUtil.waitForTitleContains(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_TITLE);

	}

	@Step("get login page url")
	public String getLoginPageUrl() {

		// return driver.getCurrentUrl();
		return eleUtil.waitForUrlContains(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_URL_FRACTION);

	}

	@Step("user is able to login with username: {0} and password: {1}")
	public AccountsPage doLogin(String un, String pwd) {

		System.out.println("Login credentials is : " + un  + " : " + pwd);

		/*
		 * driver.findElement(emailId).sendKeys(un);
		 * driver.findElement(password).sendKeys(pwd);
		 * driver.findElement(loginBtn).click();
		 */

		eleUtil.doSendKeys(emailId, un);
		eleUtil.doSendKeys(password, pwd);

		eleUtil.doClick(loginBtn);
		
		return new AccountsPage(driver);
	}

	@Step("is forget link exist")
	public boolean isForgotPwdLinkExist() {

	//	return driver.findElement(forgotPwdLink).isDisplayed();
		
		return eleUtil.doIsEnabled(forgotPwdLink);
	}

	@Step("is register link exist")
	public boolean isRegisterLinkExist() {

	//	return driver.findElement(registerLink).isDisplayed();
		
		return eleUtil.doIsDisplayed(registerLink);
	}
	
	@Step("is logout header exist")
	public boolean isLogoutHeaderExist() {

		//	return driver.findElement(registerLink).isDisplayed();
			
			return eleUtil.doIsDisplayed(logoutHeader);
		}
	
	@Step("Navigate to register page")
	public RegisterPage goToRegisterPage() {
		
		eleUtil.doClick(registerLink);
		
		return new RegisterPage(driver);
	}

}
