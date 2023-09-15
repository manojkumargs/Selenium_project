package com.shoecarnival.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.shoecarnival.pageobjects.Scenario_1;
import com.shoecarnival.pageobjects.scenario3;
import com.shoecarnival.utilities.readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class shoe_carnival {
	
  WebDriver driver;
  ExtentReports extent;
  ExtentSparkReporter spark;
  ExtentTest test;
  JavascriptExecutor js;
  
  private static readconfig read= new readconfig();
  
  @Test(dataProvider = "dp",priority = 1)
  public void shoecarnival(String email,String pass) throws InterruptedException {
	  
	  test=extent.createTest(read.testoperations());
	  String timestamp=new SimpleDateFormat(read.dateformat()).format(new Date());
	  String screenshot="Screenshot"+timestamp+".png";
	  
	  Scenario_1 obj1=new Scenario_1(driver);
	  
	  obj1.login(email, pass);
	  Thread.sleep(10000);
	  String ss1=screenshot_capture(driver);
	  Thread.sleep(2000);
	  System.out.println("url after login "+driver.getCurrentUrl());
	  Thread.sleep(5000);
	  if(driver.getCurrentUrl().equals(read.url1())) {
		  test.pass("login is success",MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss1).build());
		  takeAndSaveScreenshot(driver, "test1"+screenshot);
//		  test.addScreenCaptureFromPath("E:\\ECLIPSE WORKSPACE\\Shoe_Carnival\\Screenshots\\"+ss1);
	  }
	  else {
		  test.fail("login is not success",MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss1).build());
		  takeAndSaveScreenshot(driver, "test1"+screenshot);
//		  test.addScreenCaptureFromPath("E:\\ECLIPSE WORKSPACE\\Shoe_Carnival\\Screenshots\\"+ss1);
	  }
	  
	  obj1.brands_domain();
	  
	  obj1.color_change();
	  Thread.sleep(4000);
	  String ss2=screenshot_capture(driver);
	  System.out.println("url after color change "+driver.getCurrentUrl());
	  Thread.sleep(3000);
	  if(driver.getCurrentUrl().equals(read.url2())) {
		  test.pass("color change is success",MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss2).build());
		  takeAndSaveScreenshot(driver, "test2"+screenshot);
//		  test.addScreenCaptureFromPath("E:\\ECLIPSE WORKSPACE\\Shoe_Carnival\\Screenshots\\"+ss2);
	  }
	  else {
		  test.fail("color change is not success",MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss2).build());
		  takeAndSaveScreenshot(driver, "test2"+screenshot);
//		  test.addScreenCaptureFromPath("E:\\ECLIPSE WORKSPACE\\Shoe_Carnival\\Screenshots\\"+ss2);
	  }
	  
	  obj1.prod_sel_cart();
	  Thread.sleep(5000);
	  String ss3=screenshot_capture(driver);
	  if(driver.getCurrentUrl().equals(read.url3())) {
		  test.pass("product is added to cart",MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss3).build());
		  takeAndSaveScreenshot(driver, "test3"+screenshot);
//		  test.addScreenCaptureFromPath("E:\\ECLIPSE WORKSPACE\\Shoe_Carnival\\Screenshots\\"+ss3);
	  }
	  else {
		  test.fail("product is not added to cart",MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss3).build());
		  takeAndSaveScreenshot(driver, "test3"+screenshot);
//		  test.addScreenCaptureFromPath("E:\\ECLIPSE WORKSPACE\\Shoe_Carnival\\Screenshots\\"+ss3);
	  }
	  
	  obj1.log_out();
	  Thread.sleep(2000);
	  String ss4=screenshot_capture(driver);
	  if(driver.getCurrentUrl().equals(read.url4())) {
		  test.pass("logout is successful",MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss4).build());
		  takeAndSaveScreenshot(driver, "test4"+screenshot);
//		  test.addScreenCaptureFromPath("E:\\ECLIPSE WORKSPACE\\Shoe_Carnival\\Screenshots\\"+ss4);
	  }
	  else {
		  test.fail("logout is unsuccessful",MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss4).build());
		  takeAndSaveScreenshot(driver, "test4"+screenshot);
//		  test.addScreenCaptureFromPath("E:\\ECLIPSE WORKSPACE\\Shoe_Carnival\\Screenshots\\"+ss4);
	  }
	  Thread.sleep(3000);
	  
  }
  
  @Test(priority = 2)
  public void PagenoNavigationChecker() throws InterruptedException {
	  
	  String timestamp=new SimpleDateFormat(read.dateformat()).format(new Date());
	  //test is linked for report creating
	  test=extent.createTest("Test Case for Page No Selection"+timestamp);
	  //POM used
	  scenario3 sc3=new scenario3(driver);
	  sc3.hoverkids();
	  js=(JavascriptExecutor)driver;
	  sc3.selectBacktoSchool();
	  Thread.sleep(3000);
	  js.executeScript("window.scrollTo(0,650)");
	  Thread.sleep(2000);
	  sc3.selectpage2();
	  //Verifying Page changes
	  Boolean verify1=sc3.verifypage2();
	  
	  //initialization for screeshot capture
//	  TakesScreenshot ts =(TakesScreenshot)driver;
//	  File sourcefile1=ts.getScreenshotAs(OutputType.FILE);
//	  String timestamp1=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//	  String screenshot1="Page_2_"+timestamp1+".png";
//	  File destfile1=new File("./screenshots/"+screenshot1);
//	  try {
//	  FileUtils.copyFile(sourcefile1,destfile1);
//	  }
//	  catch(Exception e1)
//	  {
//	  e1.printStackTrace();
//	  }
	  String ss5=screenshot_capture(driver);
	  if (verify1.equals(true)) {
		    test.pass("Page 2 is displayed", MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss5).build());
		    System.out.println("Verification page:2  Successfull");
		} else {
		    test.fail("Page 2 is NOT displayed", MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss5).build());
		    System.out.println("Verification page:2  unsuccessfull");
		}
	  Thread.sleep(2000);
	  
	  sc3.selectpage3();
	  //Verify next page selection
	  Boolean verify2=sc3.verifypage3();
//	  
//	  File sourcefile2=ts.getScreenshotAs(OutputType.FILE);
//	  String timestamp2=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//	  String screenshot2="Page_3_"+timestamp2+".png";
//	  File destfile2=new File("./screenshots/"+screenshot2);
//	  try {
//	  FileUtils.copyFile(sourcefile2,destfile2);
//	  }
//	  catch(Exception e1)
//	  {
//	  e1.printStackTrace();
//	  }
	  String ss6=screenshot_capture(driver);
	  if (verify2.equals(true)) {
		    test.pass("Page 3 is displayed", MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss6).build());
		    System.out.println("Verification page:3  Successfull");
		} else {
		    test.fail("Page 3 is NOT displayed", MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss6).build());
		    System.out.println("Verification page:3  unsuccessfull");
		}
	  
  }
  
  @Test(priority = 3)
  public void ProductRatingChecker() throws InterruptedException {
	  
	  driver.get(read.main_url());
	  Thread.sleep(3000);
	  String timestamp=new SimpleDateFormat(read.dateformat()).format(new Date());
	  //test is linked for report creating
	  test=extent.createTest("Test Case for Rating Check Selection"+timestamp);
	  //POM used
	  js=(JavascriptExecutor)driver;
	  scenario3 sc3=new scenario3(driver);
	  sc3.hovermens();
	  sc3.selectCowboy();
	  Thread.sleep(3000);
	  long pageHeight = (Long) js.executeScript("return document.body.scrollHeight;");
      System.out.println("Total page height: " + pageHeight + " pixels");
	  js.executeScript("window.scrollTo(0,2000)");
	  Thread.sleep(3000);
	  sc3.checkboxrating(4);
	  Thread.sleep(3000);
	  //Verify Rating is Reflected in the Prducts
	  Boolean verify = sc3.verifyrating(4);
	  js.executeScript("window.scrollTo(2000,250)");
	  
	//initialization for screeshot capture
//	  TakesScreenshot ts =(TakesScreenshot)driver;
//	  File sourcefile1=ts.getScreenshotAs(OutputType.FILE);
//	  String timestamp1=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//	  String screenshot1="Rating_"+timestamp1+".png";
//	  File destfile1=new File("./screenshots/"+screenshot1);
//	  try {
//	  FileUtils.copyFile(sourcefile1,destfile1);
//	  }
//	  catch(Exception e1)
//	  {
//	  e1.printStackTrace();
//	  }
	  String ss7=screenshot_capture(driver);
	  
	  if (verify.equals(true)) {
		    test.pass("All Products are Rating 4", MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss7).build());
		    System.out.println("Verification  Successfull");
		} else {
		    test.fail("All Products are not Rating 4", MediaEntityBuilder.createScreenCaptureFromPath(read.sspath()+ss7).build());
		    System.out.println("Verification  unsuccessfull");
		}
	  
  } 
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @DataProvider
  public Object[][] dp() throws IOException {
	  String[][] data=new String[2][2];
	  
	  File file=new File(read.path());
	  FileInputStream fis=new FileInputStream(file);
	  XSSFWorkbook workbook=new XSSFWorkbook(fis);
	  XSSFSheet sheet=workbook.getSheetAt(0);
	  int rowcount=sheet.getPhysicalNumberOfRows();
	  System.out.println("row count:"+rowcount);
	  
	  for(int i=0;i<rowcount;i++)
	  {
		  data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
		  data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue(); 
	  }
	  return data;
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get(read.main_url());
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  driver.navigate().refresh();
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
	  driver.quit();
  }

  @BeforeSuite
  public void beforeSuite() {
	  extent=new ExtentReports();
	  String extent_report=new SimpleDateFormat(read.dateformat()).format(new Date());
	  spark=new ExtentSparkReporter("./Extentreports/" + extent_report +".html");
	  extent.attachReporter(spark);
  }

  @AfterSuite
  public void afterSuite() {
  }
  
  public static void takeAndSaveScreenshot(WebDriver driver, String filename) {
      try {
          TakesScreenshot ts = (TakesScreenshot) driver;
          File sourceFile = ts.getScreenshotAs(OutputType.FILE);
          String destDirectory = "./Screenshots/";
//          String screenshotPath = destDirectory + filename;
          File destFile = new File(destDirectory + filename);
          FileUtils.copyFile(sourceFile, destFile);
          System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
//          return screenshotPath;
      } catch (IOException e) {
          e.printStackTrace();
//          return null;
      }
  }
  
  public static String screenshot_capture(WebDriver driver) {
	  TakesScreenshot ts = (TakesScreenshot) driver;
      File sourceFile = ts.getScreenshotAs(OutputType.FILE);
      String timestamp1=new SimpleDateFormat(read.dateformat()).format(new Date());
	  String screenshot1="Screenshot"+timestamp1+".png";
      String destDirectory = "./Screenshots/";
//      String screenshotPath = destDirectory + screenshot;
      File destFile = new File(destDirectory + screenshot1);
      try {
		FileUtils.copyFile(sourceFile, destFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return screenshot1;
  }
  
}
