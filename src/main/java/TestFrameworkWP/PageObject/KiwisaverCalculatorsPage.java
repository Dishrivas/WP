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

public class KiwisaverCalculatorsPage {
	
	WebDriver driver;
	WaitHelper waitHelper;



	//<a class="btn" href="/kiwisaver/calculators/kiwisaver-calculator/">Click here to get started.</a>
	
	@FindBy(xpath="//*[@id=\'content-ps\']/div[2]/div/section/p[4]/a")
	public WebElement kiwiSaverRetirementCalculator;

	
	public KiwisaverCalculatorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		TestBase testBase = new TestBase();
		//waitHelper.waitForElement(driver, kiwiSaverRetirementCalculator,new Config(TestBase.OR).getExplicitWait());
	}
	
	public void mouseOver(String data){
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();
	}
	
	public String GetTitle()
	{
		return this.driver.getTitle();
	}
	
	
	public KiwisaverRetirementCalculatorPage clickOnIntem(WebElement element){
		
		element.click();
		return new KiwisaverRetirementCalculatorPage(driver);
	}
	

}
