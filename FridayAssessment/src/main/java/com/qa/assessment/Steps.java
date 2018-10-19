package com.qa.assessment;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;
	boolean replaceExisting;
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Assessment\\AssessmentReport.html", replaceExisting);
	ExtentTest test;
	Constants a = new Constants();

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		String username = "root";
		String password = "root";
		driver.manage().window().maximize();
		driver.get(Constants.loginPage);
		LoginPage c = PageFactory.initElements(driver, LoginPage.class);
		c.loginUser(username, password);
		driver.get(Constants.usersPage);
	}

	@After
	public void teardown() {
		extent.endTest(test);
		driver.close();
		extent.flush();
	}

	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() {
		test = extent.startTest("Going to the User Screen.");
		driver.get(Constants.createUser);
		assertEquals(Constants.createUser, driver.getCurrentUrl());
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() {
		test.log(LogStatus.INFO, "Creating a User.");
		String name = "Jake";
		String password = "ruby";
		String fullName = "JakeBurling";
		String email = "root@root.com";
		CreateUserPage b = PageFactory.initElements(driver, CreateUserPage.class);
		b.createUser(name, password, password, fullName, email);

	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() {
		CreateUserPage b = PageFactory.initElements(driver, CreateUserPage.class);
		b.submitUser();
		test.log(LogStatus.INFO, "Creating User.");
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() {
		String name = "Jake";
		assertEquals(false, driver.findElements(By.linkText(name)).isEmpty());
		test.log(LogStatus.PASS, "User visible on User Screen.");
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, "
			+ "\"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$") 
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(
			String arg1, String arg2, String arg3, String arg4) {
		test.log(LogStatus.INFO, "Creating a User.");
		String username = arg1;
		String password = arg2;
		String confirmPassword = arg3;
		String fullName = arg4;
		String email = "root@root.com";
		CreateUserPage b = PageFactory.initElements(driver, CreateUserPage.class);
		b.createUser(username, password, confirmPassword, fullName, email);
		test.log(LogStatus.PASS, "User Created.");
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) {
		String name = arg1;
		assertEquals(false, driver.findElements(By.linkText(name)).isEmpty());
		test.log(LogStatus.PASS, "User visible on User Screen");
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) {
		test = extent.startTest("Finding User on User Screen.");
		String name = arg1;
		assertEquals(false, driver.findElements(By.linkText(name)).isEmpty());
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		String name = arg1;
		UserPage d = PageFactory.initElements(driver, UserPage.class);
		d.clickUser(name, driver);
		test.log(LogStatus.INFO, "Clicking on Username.");
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
		UserPage e = PageFactory.initElements(driver, UserPage.class);
		if (e.isThere(arg1, driver)) {
			e.clickUser(arg1, driver);
		}
		test.log(LogStatus.PASS, "Navigated to Profile Screen.");
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
		test = extent.startTest("Configure User Profile.");
		driver.get(Constants.userStem + arg1 + "/");
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
		WebElement configure = driver.findElement(By.linkText("Configure"));
		configure.click();
		test.log(LogStatus.INFO, "Clicking Configure Button.");
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable {
		WebElement changeName = driver.findElement(By.name("_.fullName"));
		changeName.clear();
		changeName.sendKeys(arg1);
		test.log(LogStatus.INFO, "Changing Full Name.");
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		WebElement save = driver.findElement(By.name("Submit"));
		save.click();
		test.log(LogStatus.INFO, "Saving new Full Name.");
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
		assertEquals(false, driver.findElements(By.linkText(arg1)).isEmpty());
		test.log(LogStatus.PASS, "Name Change Successful.");
	}
}
