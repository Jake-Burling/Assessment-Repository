package com.qa.assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(xpath = "//*[@id=\"j_username\"]")
	private WebElement username;
	@FindBy(xpath = "/html/body/div/div/form/div[2]/input")
	private WebElement password;
	@FindBy(xpath ="/html/body/div/div/form/div[3]/input")
	private WebElement submit;
	
	public void loginUser(String text1,String text2) {
		username.sendKeys(text1);
		password.sendKeys(text2);
		submit.submit();
	}
}
