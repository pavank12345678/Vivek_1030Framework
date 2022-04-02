package com.Selenium.My_Framework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import repository.Home_P_rep;
import resources.Base;

public class Home_Page extends Base {
	
	Home_P_rep hp;

	@BeforeTest
	public void set_up() throws IOException {
		driverint();
		properties_load();
		hp=new Home_P_rep(driver);
	}

	@Test
	public void TC1() {
		String Home_Page_URL = prop.getProperty("Home_Page");
		driver.get(Home_Page_URL);
	boolean homepage_text=hp.getHomePagetext().isDisplayed();
		//boolean text = driver.findElement(By.xpath("//h1[text()='Welcome to the Simple Travel Agency!']"))
			//	.isDisplayed();
		Assert.assertTrue(homepage_text);
	}

	@Test
	public void TC2() throws IOException // Find Flights

	{
		List<String> homepagedata = ExcelDataImport("HomePage");
	//	Select From_Loc = new Select(driver.findElement(By.name("fromPort")));
		Select From_Loc = new Select(hp.getFromPort());
		From_Loc.selectByVisibleText(homepagedata.get(2));
		String From_city = From_Loc.getFirstSelectedOption().getText();
		Assert.assertEquals(From_city, "Paris");
		//Select To_Loc = new Select(driver.findElement(By.name("toPort")));
		Select To_Loc = new Select(hp.gettoPort());
		To_Loc.selectByVisibleText(homepagedata.get(3));
		String To_city = To_Loc.getFirstSelectedOption().getText();
		System.out.println("The selected option" + To_city);
		Assert.assertEquals(To_city, "Rome");

		//driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		hp.getFindFlightButton().click();

	}

}
