package TestFrameworkWP.homePage;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


import TestFrameworkWP.PageObject.KiwisaverCalculatorsPage;
import TestFrameworkWP.PageObject.KiwisaverRetirementCalculatorPage;
import TestFrameworkWP.helper.Logger.LoggerHelper;
import TestFrameworkWP.PageObject.HomePage;
import TestFrameworkWP.testbase.Config;
import TestFrameworkWP.testbase.TestBase;


/**
 * Unit test for simple App.
 */
public class HomePageTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(HomePageTest.class);

	HomePage homePage ;
	KiwisaverCalculatorsPage newPage;
	KiwisaverRetirementCalculatorPage kiwisaverRetirementCalculatorPage;
	
	@Test
	public void CheckCurrentAgeInformationIconMessage(){
		log.info(HomePageTest.class.getName()+" started");
		
		Config config = new Config(OR);
		log.info(config.getWebsite()+" started for testWebsiteNavigation");
		log.info("Testing Scenario : Given User Clicks information icon besides Current age the message “This calculator has an age\r\n" + 
				"limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.” is displayed below\r\n" + 
				"the current age field.");
		
		driver.get(config.getWebsite());
		 homePage = new HomePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		homePage.mouseOver("KiwiSaver");
		KiwisaverCalculatorsPage newPage = homePage.clickOnMenu(homePage.kiwiSaverCalculators);
		
		driver.manage().window().maximize();
		js.executeScript("arguments[0].scrollIntoView();", newPage.kiwiSaverRetirementCalculator);
		 kiwisaverRetirementCalculatorPage = newPage.clickOnIntem(newPage.kiwiSaverRetirementCalculator);
		
		Integer size = driver.findElements(By.tagName("iframe")).size();
		driver.switchTo().frame(0);		
		
		kiwisaverRetirementCalculatorPage.clickOnInformationIconForCurrentAge(kiwisaverRetirementCalculatorPage.currentAge);
		
		String message = kiwisaverRetirementCalculatorPage.GetTextOfInformationMessageForCurrentAge();
		if (message.equals("This calculator has an age limit of 18 to 64 years old."))
		{
			 log.info("Message verified : This calculator has an age limit of 18 to 64 years old.");	
		}
		else{
			Assert.assertTrue(false, "Not Showing Information messages");
		}
	}
	
	@Test
	public void testOpeningRetirementCalculatorPage(){
		
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		log.info(config.getWebsite()+" started for testOpeningRetirementCalculatorPage");
		log.info("Testing Scenario : User can successfuly navigate around : Navigation Flow KiwiSaver &gt; KiwiSaver Calculators &gt; Click here to get started button\r\n" + 
				"under (Westpac KiwiSaver Scheme Retirement Calculator)");
		 homePage = new HomePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		homePage.mouseOver("KiwiSaver");
		 newPage = homePage.clickOnMenu(homePage.kiwiSaverCalculators);
		
		driver.manage().window().maximize();
		js.executeScript("arguments[0].scrollIntoView();", newPage.kiwiSaverRetirementCalculator);
		 kiwisaverRetirementCalculatorPage = newPage.clickOnIntem(newPage.kiwiSaverRetirementCalculator);
		
		String title = kiwisaverRetirementCalculatorPage.GetTitle();
		if (title.equals("KiwiSaver Retirement Calculator - Westpac NZ")){
			 log.info(" verified :Opening Retirement Calculator Page ");
		}
		else{
			log.info(" verified :Failed to open  Retirement Calculator Page ");
			Assert.assertTrue(false, "Failed to open Retirement Calculator Page ");
		}
		
	}
	
	
	@Test
	public void GetKiwiSaverHighRiskBalance() throws InterruptedException{
		
		
		 Config config = new Config(OR);
		 driver.get(config.getWebsite());
		log.info(config.getWebsite()+" started for GetKiwiSaverHighRiskBalance");
		log.info("Testing Scenario : User whose Current age is 30 is Employed @ a Salary 82000 p/a and contributes to\r\n" + 
				"KiwiSaver @ 4% has a PIR 17.5% and chooses a high risk profile is able to calculate his\r\n" + 
				"projected balances at retirement.");
		 homePage = new HomePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		homePage.mouseOver("KiwiSaver");
		 newPage = homePage.clickOnMenu(homePage.kiwiSaverCalculators);
		
		driver.manage().window().maximize();
		js.executeScript("arguments[0].scrollIntoView();", newPage.kiwiSaverRetirementCalculator);
		 kiwisaverRetirementCalculatorPage = newPage.clickOnIntem(newPage.kiwiSaverRetirementCalculator);
		
		Integer size = driver.findElements(By.tagName("iframe")).size();
		driver.switchTo().frame(0);		
		
		kiwisaverRetirementCalculatorPage.FillHighRiskCalculationDetails(driver);
		
		log.info(" Viewing KiwiSaverProjections ");
		kiwisaverRetirementCalculatorPage.viewKiwiSaverProjections.click();
		
}

	@Test
	public void GetKiwiSaverMediumRiskAged45Balance() throws InterruptedException{
		
		
		 Config config = new Config(OR);
		 driver.get(config.getWebsite());
		log.info(config.getWebsite()+" started for GetKiwiSaverMediumRiskAged45Balance");
		log.info("Testing Scenario :User whose current aged 45 is Self-employed, has a PIR 10.5%, current KiwiSaver\r\n" + 
				"balance is $100000, voluntary contributes $90 fortnightly and chooses medium risk\r\n" + 
				"profile with saving goals requirement of $290000 is able to calculate his projected\r\n" + 
				"balances at retirement.");

		 homePage = new HomePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		homePage.mouseOver("KiwiSaver");
		 newPage = homePage.clickOnMenu(homePage.kiwiSaverCalculators);
		
		driver.manage().window().maximize();
		js.executeScript("arguments[0].scrollIntoView();", newPage.kiwiSaverRetirementCalculator);
		 kiwisaverRetirementCalculatorPage = newPage.clickOnIntem(newPage.kiwiSaverRetirementCalculator);
		
		Integer size = driver.findElements(By.tagName("iframe")).size();
		driver.switchTo().frame(0);	
		kiwisaverRetirementCalculatorPage.FillMediumRiskBalanceDetails(driver);
		
		log.info(" Viewing KiwiSaverProjections ");

		kiwisaverRetirementCalculatorPage.viewKiwiSaverProjections.click();
		
	}

	@Test
	public void GetKiwiSaverMediumRiskAged55Balance() throws InterruptedException{
		
		
		 Config config = new Config(OR);
		 driver.get(config.getWebsite());
		log.info(config.getWebsite()+" started for GetKiwiSaverMediumRiskAged55Balance");
		log.info("Testing Scenario :User whose current aged 55 is not employed, has a PIR 10.5%, current KiwiSaver balance\r\n" + 
				"is $140000, voluntary contributes $10 annually and chooses medium risk profile with\r\n" + 
				"saving goals requirement of $200000 is able to calculate his projected balances at\r\n" + 
				"retirement.");
		
		 homePage = new HomePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		homePage.mouseOver("KiwiSaver");
		 newPage = homePage.clickOnMenu(homePage.kiwiSaverCalculators);
		
		driver.manage().window().maximize();
		js.executeScript("arguments[0].scrollIntoView();", newPage.kiwiSaverRetirementCalculator);
		 kiwisaverRetirementCalculatorPage = newPage.clickOnIntem(newPage.kiwiSaverRetirementCalculator);
		
		Integer size = driver.findElements(By.tagName("iframe")).size();
		driver.switchTo().frame(0);		
		
		kiwisaverRetirementCalculatorPage.FillMediumRiskBalanceDetailsAged55(driver);
		log.info(" Viewing KiwiSaverProjections ");
		kiwisaverRetirementCalculatorPage.viewKiwiSaverProjections.click();
	}
}
