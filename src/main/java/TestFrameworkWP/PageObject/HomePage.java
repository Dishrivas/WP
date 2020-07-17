package TestFrameworkWP.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestFrameworkWP.PageObject.HomePage;
import TestFrameworkWP.helper.Logger.LoggerHelper;

import TestFrameworkWP.helper.Wait.WaitHelper;
import TestFrameworkWP.testbase.Config;
import TestFrameworkWP.testbase.TestBase;

public class HomePage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
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
		waitHelper.waitForElement(driver, kiwiSaverMenu,new Config(TestBase.OR).getExplicitWait());

	}
	
	public void mouseOver(String data){
		log.info("doing mouse over on :"+data);
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
