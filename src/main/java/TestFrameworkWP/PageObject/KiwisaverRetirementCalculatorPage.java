package TestFrameworkWP.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestFrameworkWP.helper.Wait.WaitHelper;
import TestFrameworkWP.testbase.Config;
import TestFrameworkWP.testbase.TestBase;

public class KiwisaverRetirementCalculatorPage {
	
	WebDriver driver;
	WaitHelper waitHelper;
	
	String KiwiSaver = "";
	
	
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
	
	
public static void GetKiwiSaverHighRiskBalance (WebDriver driver, int Age, int Salary,int kiwiSaverBalance, int volContributions, int savingGoals ) throws InterruptedException{
		
		
		driver.get("https://www.westpac.co.nz");
		HomePage homePage = new HomePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		homePage.mouseOver("KiwiSaver");
		KiwisaverCalculatorsPage newPage = homePage.clickOnMenu(homePage.kiwiSaverCalculators);
		
		driver.manage().window().maximize();
		js.executeScript("arguments[0].scrollIntoView();", newPage.kiwiSaverRetirementCalculator);
		KiwisaverRetirementCalculatorPage kiwisaverRetirementCalculatorPage = newPage.clickOnIntem(newPage.kiwiSaverRetirementCalculator);
		
		Integer size = driver.findElements(By.tagName("iframe")).size();
		driver.switchTo().frame(0);		
		
		kiwisaverRetirementCalculatorPage.currentAge.click();
		kiwisaverRetirementCalculatorPage.currentAge.sendKeys("30");
		
		//kiwisaverRetirementCalculatorPage.employmentStatus.click();
		kiwisaverRetirementCalculatorPage.employmentStatusArrow.click();
		kiwisaverRetirementCalculatorPage.mouseOver("Employed");
		//kiwisaverRetirementCalculatorPage.employmentStatusEmployed.click();
		
		kiwisaverRetirementCalculatorPage.currentKiwiSaverBalance.sendKeys("Salary");
		kiwisaverRetirementCalculatorPage.memberContribution.click();
		kiwisaverRetirementCalculatorPage.riskProfileHigh.click();
		kiwisaverRetirementCalculatorPage.viewKiwiSaverProjections.click();
		
		Thread.sleep(9000);
	}

public static void GetKiwiSaverMediumRiskBalance (WebDriver driver, String Age, String Salary,String kiwiSaverBalance, String volContributions, String savingGoals ) throws InterruptedException{
	
	driver.get("https://www.westpac.co.nz");
	HomePage homePage = new HomePage(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	homePage.mouseOver("KiwiSaver");
	KiwisaverCalculatorsPage newPage = homePage.clickOnMenu(homePage.kiwiSaverCalculators);
	
	driver.manage().window().maximize();
	js.executeScript("arguments[0].scrollIntoView();", newPage.kiwiSaverRetirementCalculator);
	KiwisaverRetirementCalculatorPage kiwisaverRetirementCalculatorPage = newPage.clickOnIntem(newPage.kiwiSaverRetirementCalculator);
	
	Integer size = driver.findElements(By.tagName("iframe")).size();
	driver.switchTo().frame(0);		
	
	kiwisaverRetirementCalculatorPage.currentAge.click();
	kiwisaverRetirementCalculatorPage.currentAge.sendKeys(Age);
	
	kiwisaverRetirementCalculatorPage.employmentStatusArrow.click();
	kiwisaverRetirementCalculatorPage.mouseOver("Self-employed");
	//kiwisaverRetirementCalculatorPage.employmentStatusSelfEmployed.click();
	
	
	kiwisaverRetirementCalculatorPage.salaryPerYear.sendKeys("Salary");
	kiwisaverRetirementCalculatorPage.memberContribution.click();
	kiwisaverRetirementCalculatorPage.riskProfileHigh.click();
	kiwisaverRetirementCalculatorPage.viewKiwiSaverProjections.click();
	
	Thread.sleep(9000);
}
	
	public void clickOnInformationIconForCurrentAge(WebElement element){
	
		informationIconForCurrentAge.click();
		//return new ProductCategoryPage(driver);
	}
	
	public String GetTextOfInformationMessageForCurrentAge(){
		
		
		return informationMessageForCurrentAge.getText();
	}

}
