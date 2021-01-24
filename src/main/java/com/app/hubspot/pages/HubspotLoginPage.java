package com.app.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HubspotLoginPage {
	
	private WebDriver driver;

	public HubspotLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By emailAddress = By.xpath("//input[@id='txtUsername']");
	private By password = By.xpath("//input[@id='txtPassword']");
	private By loginButton = By.xpath("//input[@id='btnLogin']");
	private By forgotPassword = By.xpath("//*[text()='Forgot your password?']");
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordDisplayed() {
		return driver.findElement(forgotPassword).isDisplayed();
	}

	public void enterUsername(String userName) {
		driver.findElement(emailAddress).sendKeys(userName);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginButton).click();
	}
}
