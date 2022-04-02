package repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_P_rep {
	WebDriver driver;
	
	public Home_P_rep(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1[text()='Welcome to the Simple Travel Agency!']")
	WebElement Homepage_Text;

	
	@FindBy(name="fromPort")
	WebElement From_Dest;
	
	@FindBy(name="fromPort")
	WebElement to_Dest;
	
	@FindBy(css=".btn.btn-primary")
	WebElement FindFlightsbutton;
	
	  
	public WebElement getHomePagetext()
	{
		return Homepage_Text;
	}
	
	public WebElement getFromPort()
	{
		return From_Dest;
	}
	


	public WebElement gettoPort()
	{
		return to_Dest;
	}


	public WebElement getFindFlightButton()
	{
		return FindFlightsbutton;
	}
	
	
}
