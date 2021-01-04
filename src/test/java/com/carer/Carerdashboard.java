package com.carer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Carerdashboard {
WebDriver driver;
	@Test(priority=-1)
	public void navigateTestCarerDashbord() throws InterruptedException {
		System.out.println("navigateTestCarerDashbord");
		WebElement carer = driver.findElement(By.xpath("//body/div[@id='main-container']/div[4]/div[1]/ul[1]/li[2]/a[1]"));
		carer.click();
	}

	@Test(priority=2)
	public void sortByRoom() throws InterruptedException {
		System.out.println("sortByRoom");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//input[@id='roomNumberSearch']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	@Test(priority=3)
	public void sortBySurname() throws InterruptedException {
		System.out.println("sortBySurname");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//input[@id='surnameSearch']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	@Test(priority=4)
	public void searchBySurname() throws InterruptedException {
		System.out.println("searchBySurname");
		WebElement search = driver.findElement(By.xpath("//input[@id='residentSearch']"));
		search.clear();
		search.sendKeys("Andrew");
		Thread.sleep(2000);
	}
	
	@Test(priority=5) 
	public void searchByRoomNo() throws InterruptedException {
		System.out.println("searchByRoomNo");
		WebElement search = driver.findElement(By.xpath("//input[@id='residentSearch']"));
		search.clear();
		search.sendKeys("Room 4");
		Thread.sleep(2000);
	}
  
	@Test(priority=0)
	public void showAllResidents() throws InterruptedException  {
		System.out.println("showAllResidents");
		WebElement showallresidents = driver.findElement(By.xpath("//a[@id='showAllResidents']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showallresidents);
	    Thread.sleep(2000);
	}
  
	@Test(priority=6)
	public void viewFlasMessage() throws InterruptedException  {
		System.out.println("viewFlasMessage");
		WebElement viewFlasMessage = driver.findElement(By.xpath("//a[@id='showAllResidents']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewFlasMessage);
	    Thread.sleep(2000);
	}
}
