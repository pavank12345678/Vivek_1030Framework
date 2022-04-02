package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_P_Rep {
	WebDriver driver;
	public Login_P_Rep(WebDriver driver)
	{
		this.driver=driver;
	}
	By Login_Page_Text=By.xpath("//h2[text()='Login Page']");
	By username=By.cssSelector("#username");
	By password =By.id("password");
	By LoginButtonClick=By.cssSelector(".radius");
	By LoginValidationtext=By.className("subheader");
	
	public 	WebElement getLogintext()
	{
		return driver.findElement(Login_Page_Text);
		
	}
	
	public 	WebElement getusername()
	{
		return driver.findElement(username);
		
	}
	
	public 	WebElement getpassword()
	{
		return driver.findElement(password);
  		
	}
	
	public 	WebElement getLoginbbutton()
	{
		return driver.findElement(LoginButtonClick);
		
	}
	
	public 	WebElement getLoginvalidatontext()
	{
		return driver.findElement(LoginValidationtext);
	}
	
}