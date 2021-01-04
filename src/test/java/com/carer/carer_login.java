package com.carer;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class carer_login {
	public WebDriver driver;

	@BeforeTest
	public void init_browser() {
		System.setProperty("webdriver.chrome.driver", "/home/shanmukh/automation/chromedriver");

		driver = new ChromeDriver();
		driver.get("https://demo.eplancare.com/web/login");
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void login() throws InterruptedException {
		
		WebElement validusername1 = driver.findElement(By.xpath("//input[@data-parsley-id='4']"));
		Assert.assertTrue(validusername1.isDisplayed());
		validusername1.sendKeys("shanmukh.balkunde@v2stech.com");

		WebElement validpass = driver.findElement(By.xpath("//input[@data-parsley-id='6']"));
		Assert.assertTrue(validpass.isDisplayed());
		validpass.sendKeys("Care@321");

		WebElement showsignin = driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]"));
		showsignin.click();
		System.out.println("login Successfully");
		Thread.sleep(1000);
		String expect="https://demo.eplancare.com/web/";
		Assert.assertEquals(expect, driver.getCurrentUrl());
		System.out.println("pass assertion");
		
		
	}

	@Test(priority=-1)
	public void navigateToResidentManagement() throws InterruptedException {
		System.out.println("navigateToResidentManagement");
		WebElement navigateToResidentManagemen  = driver.findElement(By.xpath("//body/div[@id='main-container']/div[4]/div[1]/ul[1]/li[1]/a[1]/span[1]"));
		navigateToResidentManagemen.click();
		Thread.sleep(1000);
	}
	
	@Test(priority=0)
	public void searchResidentName() throws InterruptedException {
		System.out.println("searchResidentName");
		WebElement searchResidentName  = driver.findElement(By.xpath("//input[@id='residentSearch']"));
		searchResidentName.sendKeys("Hettie");
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void clickCarePlan()  {
		System.out.println("clickCarePlan");
		//WebDriverWait wait=new WebDriverWait(driver, 3);
		//WebElement clickCarePlan=  wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//tbody/tr[1]/td[3]/a[1]/span[1]"))));
		 driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a[1]/span[1]")).click();
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickCarePlan);
		//clickCarePlan.click();
		//System.out.println(clickCarePlan.getText());
	}
	
	
	@Test(priority=2)
	public void returnToResidentDashbord() throws InterruptedException {
		System.out.println("returnToResidentDashbord");
		WebElement returnToResidentDashbord  = driver.findElement(By.xpath("//a[contains(text(),'Resident s Dashboard')]"));
		returnToResidentDashbord.click();
		Thread.sleep(3000);
	
	}
	@Test(priority=3)
	public void clearallFilter() throws InterruptedException {
		System.out.println("clearallFiltere");
		WebElement removeFilter = driver.findElement(By.xpath("//em[@id='clearResidentDatatableFilter']"));
		removeFilter.click();
		Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void searchWorkername() throws InterruptedException {
		System.out.println("searchWorkername");
		WebElement searchResidentName  = driver.findElement(By.xpath("//input[@id='keyWorkerSearch']"));
		searchResidentName.sendKeys("Brendan Carer");
		Thread.sleep(3000);
	}
	
//	@Test(priority=3)
//	public void clickWorkername() throws InterruptedException {
//		System.out.println("clickWorkername");
//		WebElement clickWorkername  = driver.findElement(By.xpath("(//i[@class='s7-search'])[2]"));
//		clickWorkername.click();
//		Thread.sleep(3000);
	//}
	
	@Test(priority=5)
	public void addNewResident()  {
		System.out.println("addNewResident");
		//WebDriverWait wait=new WebDriverWait(driver, 3);
		//WebElement clickCarePlan=  wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//tbody/tr[1]/td[3]/a[1]/span[1]"))));
		 driver.findElement(By.xpath("//a[contains(text(),'Add new Resident')]")).click();
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickCarePlan);
		//clickCarePlan.click();
		//System.out.println(clickCarePlan.getText());
		
	}
	
	
	@Test(priority=6)
	public void addingNewResident() throws InterruptedException {
		System.out.println("addingNewResident");
		WebElement title  = driver.findElement(By.xpath("//select[@id='resHonorific']"));
		//addingNewResident.sendKeys("Mr");
		Select s=new Select(title);
		s.selectByVisibleText("Mr");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='resFirstName']")).sendKeys("Andrew");//first name
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='resLastName']")).sendKeys("Shindha");//last name
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id='residentDOB']")).sendKeys("05-11-1972");//DoB
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//select[@id='resStatus']")).sendKeys("Active");//status
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//select[@id='resStatus']")).sendKeys("Active");//gender
	     
	
	}
	
//	@Test
//	public void careSummery() {
//		System.out.println(" careSummery");
//		WebElement careSummery  = driver.findElement(By.xpath("//span[@class='round-icon fa fa-CS manageIcons2 md-trigger icon-eye-font-weight font20']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();",careSummery);
//	}
//	
//	@Test
//	public void clickResidentImage() {
//		System.out.println("clickResidentImage");
//		WebElement clickResidentImage  = driver.findElement(By.xpath("//img[@alt='logo']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();",clickResidentImage);
//	}
//	
//	@Test(priority=12)
//	public void logout() throws InterruptedException {
//		System.out.println("logout");
//		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();",logout);
//	    Thread.sleep(2000);
	//}
// @AfterTest
// public void login2() {
//		WebElement username = driver.findElement(By.xpath("(//input[@name='username'])[1]"));
//		username.sendKeys("vikas.kale@v2stech.com");
//
//		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
//		pass.sendKeys("Vikascare@123");
//
//		WebElement signin = driver.findElement(By.xpath("//button[@type='submit'])]"));
//		signin.click();
//	}
//
// @Test(priority=12)
//	public void navigateTestCarerDashbord2() throws InterruptedException {
//		System.out.println("navigateTestCarerDashbord");
//		WebElement carer = driver.findElement(By.xpath("//body/div[@id='main-container']/div[4]/div[1]/ul[1]/li[2]/a[1]"));
//		carer.click();
// }

}
