package TestFrameworkWP.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestFrameworkWP.helper.Wait.WaitHelper;
import TestFrameworkWP.testbase.Config;
import TestFrameworkWP.testbase.TestBase;

public class HomePage {
	
	WebDriver driver;
	WaitHelper waitHelper;
	


	
	@FindBy(css="a#ubermenu-section-link-kiwisaver-ps")
	public WebElement kiwiSaverMenu;
	
	//a#ubermenu-item-cta-kiwisaver-calculators-ps
	
	@FindBy(xpath="//*[@id='ubermenu-item-cta-kiwisaver-calculators-ps']")
	public WebElement kiwiSaverCalculators;
	
	

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		TestBase testBase = new TestBase();
	}
	
	public void mouseOver(String data){
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();
	}
	
	public String GetTitle()
	{
		return this.driver.getTitle();
	}
	
	public KiwisaverCalculatorsPage clickOnMenu(WebElement element){
		element.click();
		return new KiwisaverCalculatorsPage(driver);
	}
	

}
