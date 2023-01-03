package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class NewAccountPage {
	
	private By emailId_new = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");

}
