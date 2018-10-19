package com.qa.assessment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage {

	@FindBy(id = "people")
	private WebElement list;
	
	public void clickUser(String arg1, WebDriver driver) {
		List<WebElement> users = driver.findElements(By.linkText(arg1));
		for(WebElement m : users) {
			if(m.getAttribute("href").equalsIgnoreCase("http://localhost:8080/securityRealm/user/" + arg1 + "/")) {
				m.click();
			}
		}
	}
	public boolean isThere(String arg1,WebDriver driver) {
		if(!driver.findElements(By.linkText(arg1)).isEmpty()) {
			return true;
		}
		return false;
	}
}
