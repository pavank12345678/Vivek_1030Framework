package com.Selenium.My_Framework;

import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.Logger;


import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import repository.Login_P_Rep;
import resources.Base;

public class Login extends Base {

	public static Login_P_Rep lp;
	public static Logger log=LogManager.getLogger(Login.class.getName());
	@BeforeTest
	public void set_up() throws IOException {
		driverint();
		log.info("driver is intialized");
		log.error("the error");
		properties_load();
		 lp = new Login_P_Rep(driver);
		}

	@Test(priority = 0)
	public void tc1() {
		
		String Login_url = prop.getProperty("login_Url");
		System.out.println(Login_url);
		driver.get(Login_url);
		// boolean text = driver.findElement(By.xpath("//h2[text()='Login
		// Page']")).isDisplayed();
		boolean text = lp.getLogintext().isDisplayed();
		Assert.assertTrue(text);

	}

	@Test(priority = 1)
	public void TC2() throws IOException {
		
		List<String> Login_data = ExcelDataImport("Login");
		System.out.println("The usename" + Login_data);
		// driver.findElement(By.cssSelector("#username")).sendKeys(Login_data.get(2));
		lp.getusername().sendKeys(Login_data.get(2));
		// driver.findElement(By.id("password")).sendKeys(Login_data.get(3));
		lp.getpassword().sendKeys(Login_data.get(3));
		lp.getLoginbbutton().click();
		// driver.findElement(By.cssSelector(".radius")).click();
		boolean login_text = driver.findElement(By.className("subheader")).isDisplayed();
		Assert.assertTrue(login_text);
		// String text_val = driver.findElement(By.className("subheader")).getText();
		String text_val = lp.getLoginvalidatontext().getText();
		Assert.assertEquals(text_val, "Welcome to the Secure Area. When you are done click logout below.");

	}

	@Test(priority = 2)

	public void TC3() {
		driver.findElement(By.cssSelector(".button.secondary.radius")).click();

		boolean Logout_val = driver.findElement(By.id("flash")).isDisplayed();
		Assert.assertTrue(Logout_val);
		String back_color = driver.findElement(By.id("flash")).getCssValue("background-color");
		System.out.println("The background color" + back_color);

	}

}
