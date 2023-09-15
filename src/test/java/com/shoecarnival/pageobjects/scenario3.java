package com.shoecarnival.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class scenario3 {
	WebDriver driver;
	
	By kids=By.xpath("//a[@title='Shop all kids shoes']");
	By BacktoSchool=By.linkText("Back to School");
	By pageno2=By.linkText("2");
	By pageno3=By.linkText("3");
	

	By mens=By.xpath("//a[@title='Shop all Mens Shoes']");
	By CowboyAndWestern=By.linkText("Cowboy and Western");
	By allproducts=By.xpath("//div[@role='img']");
	
	By rating4=By.xpath("//*[@id=\"sv-category-page\"]/div[4]/div[1]/div/div[8]/div[2]/div/div/div/div/label[2]");
	By rating5=By.xpath("//*[@id=\"sv-category-page\"]/div[4]/div[1]/div/div[8]/div[2]/div/div/div/div/label[1]");
	
	public scenario3(WebDriver driver) {
		
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	public void hoverkids() {
		WebElement ele=driver.findElement(kids);
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	public void selectBacktoSchool() {
		driver.findElement(BacktoSchool).click();
	}
	public void selectpage2() {
		driver.findElement(pageno2).click();
	}
	public boolean verifypage2() {
		String page2url = driver.getCurrentUrl();
		if(page2url.contains("page=2"))
			return true;
		return false;
	}
	public void selectpage3() {
		driver.findElement(pageno3).click();
	}
	public boolean verifypage3() {
		String page3url = driver.getCurrentUrl();
		if(page3url.contains("page=3"))
			return true;
		return false;
	}
	
////////////////////////////////////////////MENS////////////////
	public void hovermens() {
		WebElement ele=driver.findElement(mens);
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	public void selectCowboy() {
		driver.findElement(CowboyAndWestern).click();
	}
	public void checkboxrating(int n) throws InterruptedException {
		By rating = null;
		if(n==4) {
			rating=rating4;
		}
		if(n==5) {
			rating=rating5;
		}
		Thread.sleep(5000);
		driver.findElement(rating).click();
	}
	public boolean verifyrating(int n) {
		List<WebElement> elements = driver.findElements(allproducts);
		boolean allElementsMeetCriteria = true;        
        for (WebElement ele : elements) {
            String ariaLabel = ele.getAttribute("aria-label");
            System.out.println(ariaLabel);
            System.out.println(elements.size());
            if (ariaLabel == null || !ariaLabel.contains("Rating: ")) {
                allElementsMeetCriteria = false;
                break;
            }
            double rating = Double.parseDouble(ariaLabel.split("Rating: ")[1].split(" out")[0]);
            switch(n) {
            case 4:
            if (rating < 4.0) {
                allElementsMeetCriteria = false;
                break; 
            }
            case 5:
                if (rating < 5.0) {
                    allElementsMeetCriteria = false;
                    break; 
                }
            }
        }

        if (allElementsMeetCriteria) {
            System.out.println("All elements meet the criteria.");
            return true;
        } else {
            System.out.println("Not all elements meet the criteria.");
            return false;
        }
        
	}
}