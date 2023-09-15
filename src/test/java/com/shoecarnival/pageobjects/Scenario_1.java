package com.shoecarnival.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario_1 {
	WebDriver driver;
	JavascriptExecutor js;
	Actions a;
	WebDriverWait wait;
	
	By account=By.linkText("Account");
	By email_id=By.xpath("//input[@name='email' and @type='email']");
	By password=By.name("password");
	By login=By.className("MuiButton-label");
	By brands=By.linkText("BRANDS");
	By adidas=By.linkText("Adidas");
	By whitecolor=By.xpath("//*[@id=\"sv-category-page\"]/div[4]/div[1]/div/div[4]/div[2]/div/div/div/div/div[1]/div/div[2]/button/span");
	By select_product=By.xpath("//*[@id=\"item-0\"]/div/div[1]/a/div/img");
	By size_product=By.xpath("//*[@id=\"sv-product-page\"]/div/div[1]/div[2]/div/div[5]/div[3]/div[11]/button/span[1]");
	By add_to_bag=By.xpath("//*[@id=\"sv-product-page\"]/div/div[1]/div[2]/div/div[10]/button");
	By view_bag=By.linkText("VIEW CART");
	
	By acc_menu=By.xpath("//*[@id=\"__next\"]/header/div/div[2]/div[1]/div[2]/div/div[2]/div[4]/div[1]/div/div/span/a/span");
	By logout=By.linkText("LOGOUT");
	
	public Scenario_1(WebDriver driver1) {
		this.driver=driver1;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void login(String email,String pass) throws InterruptedException {
		Thread.sleep(10000);
		js=(JavascriptExecutor)driver;
		driver.findElement(account).click();
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,300)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(email_id)).sendKeys(email);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(login).click();
	}
	public void brands_domain() {
		js=(JavascriptExecutor)driver;
		a=new Actions(driver);
		a.moveToElement(driver.findElement(brands)).perform();
		wait.until(ExpectedConditions.elementToBeClickable(brands)).click();
		js.executeScript("window.scrollBy(0,300)");
		a.moveToElement(driver.findElement(adidas)).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(adidas)).click();
		
	}
	public void color_change() throws InterruptedException {
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,800)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(whitecolor)).click();
	}
	public void prod_sel_cart() throws InterruptedException {
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,0)");
        wait.until(ExpectedConditions.elementToBeClickable(select_product)).click();
        Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,600)");
		wait.until(ExpectedConditions.elementToBeClickable(size_product)).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");
		wait.until(ExpectedConditions.elementToBeClickable(add_to_bag)).click();
		wait.until(ExpectedConditions.elementToBeClickable(view_bag)).click();
	}
	
	public void log_out() throws InterruptedException {
		Thread.sleep(3000);
		a=new Actions(driver);
		a.moveToElement(driver.findElement(acc_menu)).perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(acc_menu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
	}
}
