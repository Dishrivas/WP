package TestFrameworkWP.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestFrameworkWP.helper.Logger.LoggerHelper;
import TestFrameworkWP.helper.Wait.WaitHelper;
import TestFrameworkWP.PageObject.HomePage;
import TestFrameworkWP.testbase.Config;
import TestFrameworkWP.testbase.TestBase;

public class KiwisaverRetirementCalculatorPage {
	
	WebDriver driver;
	WaitHelper waitHelper;
	
	String KiwiSaver = "";

	private final Logger log = LoggerHelper.getLogger(KiwisaverRetirementCalculatorPage.class);
	
	
	@FindBy(css ="button.icon-target.icon-target-help-toggle.icon-btn.icon-btn-info.ir.ng-scope")
	public WebElement informationIconForCurrentAge;
	
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div/p")
	public WebElement informationMessageForCurrentAge;
	
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div[1]/div/div/input")
	public WebElement currentAge;
	
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div")
	public WebElement employmentStatusArrow;
	
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div")
	public WebElement employmentStatus;
	
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]/ul/li[1]")
	public WebElement employmentStatusEmployed;
	
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]/ul/li[2]")
	public WebElement employmentStatusSelfEmployed;
	
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]/ul/li[3]")
	public WebElement employmentStatusNotEmployed;
	
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input")
	public WebElement salaryPerYear;
	
	@FindBy(css="input#radio-option-04F")
	public WebElement memberContribution;
	
	@FindBy(css="input.ng-pristine.ng-valid") 
	public WebElement voluntaryContri;
	
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div") 
	public WebElement voluntaryContriFreqArrow;	
	
	//Voluntary Contributions Fortnight Frequency
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[2]/ul/li[3]") 
	public WebElement voluntaryContriFreqFortnight;
	
	//Voluntary Contributions Annual Frequency
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[2]/ul/li[5]") 
	public WebElement voluntaryContriFreqAnnual;
	
	//Savings goal at retirement
	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input") 
	public WebElement savingsGoal;
	
	@FindBy(xpath="//*[@id=\"radio-option-01C\"]") 
	public WebElement riskProfileHigh;
	
	@FindBy(xpath="//*[@id=\"radio-option-019\"]") 
	public WebElement riskProfileMedium;
	
	@FindBy(css="button.btn.btn-regular.btn-results-reveal.btn-has-chevron") 
	public WebElement viewKiwiSaverProjections;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")
	public WebElement kiwiSaverRetirementCalculator;
	
	

	@FindBy(xpath="//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input")
	public WebElement currentKiwiSaverBalance;
	
	public KiwisaverRetirementCalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		TestBase testBase = new TestBase();
		//waitHelper.waitForElement(driver, employmentStatus,new Config(TestBase.OR).getExplicitWait());
	}
	
	public void mouseOver(String data){
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).click().build().perform();
	}
	
	public String GetTitle()
	{
		return this.driver.getTitle();
	}
	

public  void FillHighRiskCalculationDetails (WebDriver driver) throws InterruptedException{

	log.info("Filling High risk details.");
	
	this.currentAge.click();
	this.currentAge.sendKeys("30");
	
	this.employmentStatusArrow.click();
	this.mouseOver("Employed");
	
	this.salaryPerYear.sendKeys("82000");
	
	this.riskProfileHigh.click();
	log.info(" completed all details for High risk  KiwiSaverProjections ");
	Thread.sleep(6000);

	}

public  void FillMediumRiskBalanceDetails (WebDriver driver ) throws InterruptedException{
	
	log.info("Filling Medium risk details.");
	
	currentAge.click();
	currentAge.sendKeys("45");
	
	employmentStatusArrow.click();
	mouseOver("Self-employed");
	//kiwisaverRetirementCalculatorPage.employmentStatusSelfEmployed.click();
		
	currentKiwiSaverBalance.sendKeys("100000");
	voluntaryContri.sendKeys("90");
	voluntaryContriFreqArrow.click();		
	
	voluntaryContriFreqFortnight.click();
	
	riskProfileMedium.click();
	log.info(" Input Savings goal 290000 ");

	savingsGoal.sendKeys("290000");
	
	log.info(" completed all details for High risk  KiwiSaverProjections ");

	Thread.sleep(6000);
}

public  void FillMediumRiskBalanceDetailsAged55 (WebDriver driver ) throws InterruptedException{
	
	log.info("Filling Medium risk details.");
	
	currentAge.click();
	currentAge.sendKeys("55");
	
	employmentStatusArrow.click();
	mouseOver("Not employed");
	//kiwisaverRetirementCalculatorPage.employmentStatusSelfEmployed.click();
		
	currentKiwiSaverBalance.sendKeys("140000");
	voluntaryContri.sendKeys("10");
	voluntaryContriFreqArrow.click();		
	
	voluntaryContriFreqAnnual.click();
	
	riskProfileMedium.click();
	
	log.info(" Input Savings goal 200000 ");
	savingsGoal.sendKeys("200000");
	
	log.info(" completed all details for High risk  KiwiSaverProjections ");

	Thread.sleep(6000);
}

	public void clickOnInformationIconForCurrentAge(WebElement element){
	
		informationIconForCurrentAge.click();
		//return new ProductCategoryPage(driver);
	}
	
	public String GetTextOfInformationMessageForCurrentAge(){
		
		
		return informationMessageForCurrentAge.getText();
	}

}
