package capstone;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import graphql.Assert;

public class One {
	
	WebDriver driver=null;
	JavascriptExecutor j;
	//Printing all the navigation bar options
	@Test(priority=1)
	public void all() {
		List<WebElement> bakeries = driver.findElements(By.className("fusion-menu"));
		System.out.print("The elements of navgation bar is: ");		
		for (WebElement webElement : bakeries) {
            String name = webElement.getText();
            System.out.print(name);
        }
		System.out.println();
	}
	
  //Checking if home is visible
  @Test(priority=2)
  public void verificationOfHome() {
	  WebElement home=driver.findElement(By.id("menu-item-207"));
	  boolean homeVerification=home.isDisplayed();
	  Assert.assertTrue(homeVerification);
	  if(homeVerification==true) {
	  System.out.println("Home is Visible");}
  }
  
  //Checking if about is visible
  @Test(priority=3)
  public void verificationOfAbout() {
	  WebElement about=driver.findElement(By.id("menu-item-616"));
	  boolean aboutVerification=about.isDisplayed();
	  Assert.assertTrue(aboutVerification);
	  if(aboutVerification==true) {
	  System.out.println("About is Visible");}
  }
  
  //Checking if programs is visible
  @Test(priority=4)
  public void verificationOfPrograms() {
	  WebElement programs=driver.findElement(By.id("menu-item-264"));
	  boolean programVerification=programs.isDisplayed();
	  Assert.assertTrue(programVerification);
	  if(programVerification==true) {
	  System.out.println("Programs is Visible");}
  }
  
  //Checking if Services is visible
  @Test(priority=5)
  public void verificationOfServices() {
	  WebElement services=driver.findElement(By.id("menu-item-331"));
	  boolean serviceVerification=services.isDisplayed();
	  Assert.assertTrue(serviceVerification);
	  if(serviceVerification==true) {
	  System.out.println("Services is Visible");}
  }
  
  //Checking if CPR is visible
  @Test(priority=6)
  public void verificationOfCPR() {
	  WebElement CPR=driver.findElement(By.id("menu-item-467"));
	  boolean CPRVerification=CPR.isDisplayed();
	  Assert.assertTrue(CPRVerification);
	  if(CPRVerification==true) {
	  System.out.println("CPR is Visible");}
  }
  
  //Checking if contact is visible
  @Test(priority=7)
  public void verificationOfContact() {
	  WebElement contact=driver.findElement(By.id("menu-item-209"));
	  boolean contactVerification=contact.isDisplayed();
	  Assert.assertTrue(contactVerification);
	  if(contactVerification==true) {
	  System.out.println("Contact is Visible");}
  }
  
  //Checking if News is visible
  @Test(priority=8)
  public void verificationOfNews() {
	  WebElement news=driver.findElement(By.id("menu-item-1097"));
	  boolean newsVerification=news.isDisplayed();
	  Assert.assertTrue(newsVerification);
	  if(newsVerification==true) {
	  System.out.println("News is Visible");}
  }
  
  //Checking if Account is visible
  @Test(priority=9)
  public void verificationOfAccount() {
	  WebElement account=driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]"));
	  boolean accountVerification=account.isDisplayed();
	  Assert.assertTrue(accountVerification);
	  if(accountVerification==true) {
	  System.out.println("My Account is Visible");}
  }
  
  //Checking if "Board of Director" page is working
  @Parameters("browserName")
  @Test(priority=1)
  public void boardOfDirectors(String browserName) throws IOException, InterruptedException {
	  WebElement program=driver.findElement(By.id("menu-item-616"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-594")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("BOARD OF DIRECTORS");
	  j.executeScript("arguments[0].style.backgroundColor='green'", driver.findElement(By.className("entry-title")) );
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/1.png");
	  FileUtils.copyFile(source,des);
	  Thread.sleep(10000);
	  Assert.assertTrue(match);
  }

  
  //Checking if "Staff" page is working  
  @Parameters("browserName")
  @Test(priority=11)
  public void staff(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-616"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-593")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Staff");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/2.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "Partners" page is working
  @Parameters("browserName")
  @Test(priority=12)
  public void partners(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-616"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-305")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Partners and Memberships");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/3.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "Work With Us" page is working 
  @Parameters("browserName")
  @Test(priority=13)
  public void workWithUs(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-616"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-644")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Work With Us");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/4.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "History of AHEC" page is working
  @Parameters("browserName")
  @Test(priority=14)
  public void history(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-616"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-571")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("History of AHEC");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/5.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "Community Based Student Education and Training" page is working 
  @Parameters("browserName")
  @Test(priority=15)
  public void community(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-331"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-440")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Community Based Student Education and Training");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/6.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "Continuing Education Services" page is working 
  @Parameters("browserName")
  @Test(priority=16)
  public void education(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-331"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-330")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Continuing Education Services");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/7.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  //Checking if "Shop" page is working
  @Parameters("browserName")
  @Test(priority=17)
  public void shop(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-467"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-693")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Shop");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/8.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "Books" page is working
  @Parameters("browserName")
  @Test(priority=18)
  public void books(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-467"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-694")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Books");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/9.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "Cards" page is working
  @Parameters("browserName")
  @Test(priority=19)
  public void cards(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-467"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-695")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Cards");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/10.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "Rentals" page is working
  @Parameters("browserName")
  @Test(priority=20)
  public void rentals(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-467"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-696")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Rentals");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/11.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  
  //Checking if "CPR Classes" page is working
  @Parameters("browserName")
  @Test(priority=21)
  public void cprClasses(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-467"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-747")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("CPR Classes");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/12.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
 
  //Checking if "Tobacco" page is working
  @Parameters("browserName")
  @Test(priority=22)
  public void tobaccoProgram(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-264"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-344")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Tobacco");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/13.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "AHEC Scholars" page is working
  @Parameters("browserName")
  @Test(priority=23)
  public void scholarsProgram(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-264"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-280")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("AHEC Scholars");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/14.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "Healthy Aging" page is working
  @Parameters("browserName")
  @Test(priority=24)
  public void healthyAgingProgram(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-264"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-534")).click();
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Healthy Aging");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/15.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "Covering Florida" page is working
  @Parameters("browserName")
  @Test(priority=25)
  public void coveringFloridaProgram(String browserName) throws IOException {
	  WebElement program=driver.findElement(By.id("menu-item-264"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-1572")).click();
	  String heading=driver.findElement(By.xpath("//*[@id=\"post-1479\"]/div/div[1]/div/div/div/div/h2")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("Educating Towards a Healthier Community");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.xpath("//*[@id=\"post-1479\"]/div/div[1]/div/div/div/div/h2")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/16.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }
  
  //Checking if "Contact Us" page is working
  @Parameters("browserName")
  @Test(priority=26)
  public void contactUsPage(String browserName) throws IOException {
	  driver.findElement(By.cssSelector("li#menu-item-209")).click();
	  boolean title=driver.getCurrentUrl().equals("https://westfloridaahec.org/");
	  String heading=driver.findElement(By.className("entry-title")).getText();
	  System.out.println(heading);
	  boolean match=heading.equalsIgnoreCase("CONTACT US");
	  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/17.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(match);
  }

  //Checking if "Search box" is working
  @Test(priority=27)
  public void searchBar() {
	  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[1]/label/input")).sendKeys("Tobacco");
	  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[2]/input")).click();
	  String input=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div/div/div/form/div/div[1]/label/input")).getAttribute("value");
	  System.out.println("Input in textbox is: "+input);
	  String value=driver.findElement(By.xpath("//*[@id=\"posts-container\"]/div[1]")).getText();
	  Boolean contains=value.contains("Tobacco");
	  Assert.assertTrue(contains);
	  if(contains==true) {
	  System.out.println("Searched keyword is present in the searchbox");}
  }
  
  //Checking if "Registration" is working
  @Parameters("browserName")
  @Test(priority=27)
  public void registration(String browserName) throws IOException {
	  driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]/a")).click();
	  
	  driver.findElement(By.id("reg_username")).sendKeys("Aman");
	  driver.findElement(By.id("reg_email")).sendKeys("abc@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("AmanJain@1998");
	  String username= driver.findElement(By.id("reg_username")).getAttribute("value");
	  String mail=driver.findElement(By.id("reg_email")).getAttribute("value");
	  String pass=driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).getAttribute("value");
	  System.out.println("Username : "+username+"   Mail : "+mail+"  Password : "+pass);
	  driver.findElement(By.cssSelector("button[value='Register'")).click();
	  String error=driver.findElement(By.xpath("//*[@id=\"post-381\"]/div/div/div[1]/div/div")).getText();
  	  boolean contains=error.contains("An account is already registered with abc@gmail.com");
  	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/18.png");
	  FileUtils.copyFile(source,des);
  	  Assert.assertTrue(contains);
  }
  
  //Checking if "LogIn" is working
  @Parameters("browserName")
  @Test(priority=28)
  public void login(String browserName) throws IOException {
	  driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]/a")).click();
	  
	  driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Zee");
	  driver.findElement(By.id("password")).sendKeys("Bonna@1911");
	  String username=driver.findElement(By.xpath("//*[@id=\"username\"]")).getAttribute("value");
	  String pass=driver.findElement(By.id("password")).getAttribute("value");
	  System.out.println("Username : "+username+"    Password : "+pass);
	  driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();	
	  String text=driver.findElement(By.xpath("//*[@id=\"post-381\"]/div/div/div[2]/h2")).getText();
  	  boolean condition=text.equalsIgnoreCase("Dashboard");
  	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/19.png");
	  FileUtils.copyFile(source,des);
  	  Assert.assertTrue(condition);
  }
  
  //Formfillup
  @Parameters("browserName")
  @Test(priority=85)
  public void formFillUp(String browserName) throws InterruptedException, IOException {
	  WebElement program=driver.findElement(By.id("menu-item-264"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-1572")).click();
	  Thread.sleep(5000);
	  driver.switchTo().frame(1);
	  driver.findElement(By.id("zipCode")).sendKeys("32006");
	  Select distance=new Select(driver.findElement(By.name("miles")));
	  distance.selectByIndex(2);
	  
	  Select language=new Select(driver.findElement(By.className("selectInput")));
	  language.selectByIndex(2);
	  
	  List<WebElement> checkbox=driver.findElements(By.cssSelector("input[type='checkbox'"));
	  for(WebElement x:checkbox) {
		  x.click();
	  }
	  
	  driver.findElement(By.name("in_person")).click();
	  driver.findElement(By.id("submit_button")).click();
	  Thread.sleep(8000);
	  j.executeScript("window.scrollBy(0,500)");
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/20.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertNotNull(driver.findElement(By.className("locations")));
	  }
  
  //Forget Password
  @Parameters("browserName")
  @Test
  public void forgetPassword(String browserName) throws IOException {
	  driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]")).click();
	  driver.findElement(By.linkText("Lost your password?")).click();
	  driver.findElement(By.name("user_login")).sendKeys("kashuandbonna@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"post-381\"]/div/div/form/p[3]/button")).click();
	  String output=driver.findElement(By.xpath("//*[@id=\"post-381\"]/div/div/div/div")).getText();
	  boolean condition=output.equalsIgnoreCase("Password reset email has been sent.");
	  TakesScreenshot tk=(TakesScreenshot) driver;
	  File source=tk.getScreenshotAs(OutputType.FILE);
	  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/21.png");
	  FileUtils.copyFile(source,des);
	  Assert.assertTrue(condition);
	  
  }
  
  //Quit Tobacco
  @Parameters("browserName")
  @Test
  public void quitTobacco(String browserName) throws IOException, InterruptedException {
		  WebElement program=driver.findElement(By.id("menu-item-264"));
		  Actions a=new Actions(driver);
		  a.moveToElement(program).perform();
		  driver.findElement(By.id("menu-item-344")).click();
		  Thread.sleep(5000);
		  j.executeScript("window.scrollBy(0,300)");
		  driver.findElement(By.xpath("//*[@id=\"post-340\"]/div/div/div/div/div/div[1]/div[1]/div/div[1]/a/div/img")).click();
		  String text=driver.findElement(By.className("entry-title")).getText();
		  boolean condition=text.equalsIgnoreCase("Quit Tobacco");
		  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
		  TakesScreenshot tk=(TakesScreenshot) driver;
		  File source=tk.getScreenshotAs(OutputType.FILE);
		  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/22.png");
		  FileUtils.copyFile(source,des);
		  Assert.assertTrue(condition);
  }
  
  //Systems Change
  @Parameters("browserName")
  @Test
  public void systemChange(String browserName) throws IOException, InterruptedException {
		  WebElement program=driver.findElement(By.id("menu-item-264"));
		  Actions a=new Actions(driver);
		  a.moveToElement(program).perform();
		  driver.findElement(By.id("menu-item-344")).click();
		  Thread.sleep(5000);
		  j.executeScript("window.scrollBy(0,300)");
		  driver.findElement(By.xpath("//*[@id=\"post-340\"]/div/div/div/div/div/div[1]/div[2]/div/div[1]/a/div/img")).click();
		  String text=driver.findElement(By.className("entry-title")).getText();
		  boolean condition=text.equalsIgnoreCase("Systems Change");
		  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
		  TakesScreenshot tk=(TakesScreenshot) driver;
		  File source=tk.getScreenshotAs(OutputType.FILE);
		  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/22.png");
		  FileUtils.copyFile(source,des);
		  Assert.assertTrue(condition);
  }
  
//Training
  @Parameters("browserName")
  @Test
  public void training(String browserName) throws IOException, InterruptedException {
		  WebElement program=driver.findElement(By.id("menu-item-264"));
		  Actions a=new Actions(driver);
		  a.moveToElement(program).perform();
		  driver.findElement(By.id("menu-item-344")).click();
		  Thread.sleep(5000);
		  j.executeScript("window.scrollBy(0,300)");
		  driver.findElement(By.xpath("//*[@id=\"post-340\"]/div/div/div/div/div/div[1]/div[3]/div/div[1]/a")).click();
		  String text=driver.findElement(By.className("entry-title")).getText();
		  boolean condition=text.equalsIgnoreCase("Training");
		  j.executeScript("arguments[0].style.backgroundColor='green'",driver.findElement(By.className("entry-title")));
		  TakesScreenshot tk=(TakesScreenshot) driver;
		  File source=tk.getScreenshotAs(OutputType.FILE);
		  File des=new File("C:\\Users\\zeesh\\Desktop\\ScreenShot\\"+browserName+"/23.png");
		  FileUtils.copyFile(source,des);
		  Assert.assertTrue(condition);
  }
  
  //AHEC form fillup
  @Test
  public void ahec_form_fillup() throws InterruptedException {
	  WebElement program=driver.findElement(By.id("menu-item-264"));
	  Actions a=new Actions(driver);
	  a.moveToElement(program).perform();
	  driver.findElement(By.id("menu-item-534")).click();
	  Thread.sleep(30000);
	  driver.findElement(By.xpath("//*[@id=\"cog-input-auto-0\"]")).sendKeys("John");
	  driver.findElement(By.id("cog-input-auto-1")).sendKeys("Jacobs");
	  driver.findElement(By.id("cog-1")).sendKeys("9876543210");
	  driver.findElement(By.xpath("//*[@id=\"cog-2\"]")).sendKeys("abc@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[1]/div[1]/div[1]/div/label[2]")).click();
	  driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[1]/div[1]/div[1]/div/label[5]")).click();
	  driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[2]/div[1]/div[1]/div/label[2]")).click();
	  driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[5]/fieldset/div[1]/div[1]/div/label[1]")).click();
	  driver.findElement(By.xpath("//*[@id=\"cog-6\"]")).sendKeys("An individual looking to take classes wherever they may be available in my county");
	  driver.findElement(By.id("cog-7")).sendKeys("I am a good tester");
	  driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[10]/button")).click();
	  Thread.sleep(7000);
	  String message=driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div[1]/div/div[1]")).getText();
  	  boolean condition=message.equalsIgnoreCase("Thank you for filling out the form. Your response has been recorded.");
      Assert.assertTrue(condition);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  Boolean URL=driver.getCurrentUrl().equals("https://westfloridaahec.org/");
	  if(URL==false) {
		  driver.navigate().to("https://westfloridaahec.org/");
	  }
  }
	  
  @Parameters("browserName")
  @BeforeClass
  public void beforeClass(String browserName) {
	  if(browserName.equalsIgnoreCase("chrome")) {
		  driver=new ChromeDriver();
	  }
	  else if(browserName.equalsIgnoreCase("edge")) {
		  driver=new EdgeDriver();
	  }
	  else if(browserName.equalsIgnoreCase("firefox")) {
		  driver=new FirefoxDriver();
	  }
	  j=(JavascriptExecutor)driver;
	  driver.manage().window().maximize();
	  driver.get("https://westfloridaahec.org/");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
