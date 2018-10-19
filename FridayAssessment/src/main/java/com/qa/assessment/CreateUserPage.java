package com.qa.assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {
	@FindBy(id = "username")
	private WebElement userName;
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement password2;
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullname;
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement email;
	@FindBy(name = "Submit")
	private WebElement btn;

	public void createUser(String name, String passWord, String passWord2, String fullName, String eMail) {
		userName.sendKeys(name);
		password.sendKeys(passWord);
		password2.sendKeys(passWord2);
		fullname.sendKeys(fullName);
		email.sendKeys(eMail);
	}
	public void submitUser() {
		btn.click();
	}
}
