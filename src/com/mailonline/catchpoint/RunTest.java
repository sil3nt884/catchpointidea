package com.mailonline.catchpoint;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunTest{

	  private WebDriver driver;
	  private String url = "http://www.dailymail.co.uk/index.html";
	  private Set<Cookie> cookies;
	
	public void setup() {
		  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		  driver = new ChromeDriver();

		
		
	}

	public String goToPageAndConsent() {
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement button = wait.until(
		        ExpectedConditions.elementToBeClickable(By.className(("mol-ads-cmp--btn-primary"))));
		button.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		boolean cleared = wait2.until(ExpectedConditions.invisibilityOf(button));
		String html = "";
		if(cleared) {
				html = driver.getPageSource();
				System.out.println(html);
			
			cookies = driver.manage().getCookies();
		}
		
		
	
		return html;
	}

	public Set<Cookie> getCookies() {
		// TODO Auto-generated method stub
		return cookies;
	}
	
	
	public void quit () {
		driver.quit();
	}
	
}