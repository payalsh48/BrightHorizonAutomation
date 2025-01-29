package com.ui.automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ChildCarePage;
import pages.HomePage;

public class ChildCareLocatorTestCase {

	private WebDriver driver;

	@BeforeClass()
	public void setUp() {
		String pathToChromeDriver = System.getProperty("user.dir")
				+ "/src/test/resources/chromedriver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test
	public void verifyCurrentUrlHasChildCareLocator() {
		driver.get("https://www.brighthorizons.com/");

		HomePage homePage = new HomePage(driver);
		homePage.acceptCookies();
		homePage.clickCenterButton();

		Assert.assertEquals(true, driver.getCurrentUrl().contains("child-care-locator"));

	}

	@Test
	public void verifyNumberOfFoundCenters() {

		driver.get("https://www.brighthorizons.com/");

		HomePage homePage = new HomePage(driver);
		homePage.acceptCookies();
		homePage.clickCenterButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(40000));

		ChildCarePage childcarepage = new ChildCarePage(driver);
		childcarepage.inputAddressField("NewYork");
		childcarepage.inputAddressFieldKeyEnter();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		Assert.assertEquals(childcarepage.resultInputAdressField(),
				String.valueOf(childcarepage.countNumberofCentersList()));

	}

	@Test
	public void verifyFirstAddressTextFromCenterList() {
		driver.get("https://www.brighthorizons.com/");

		HomePage homePage = new HomePage(driver);
		homePage.acceptCookies();
		homePage.clickCenterButton();

		ChildCarePage childcarepage = new ChildCarePage(driver);
		childcarepage.inputAddressField("NewYork");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
	
		childcarepage.inputAddressFieldKeyEnter();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

		childcarepage.getfirstAdressfromCentersList();

		Assert.assertEquals(childcarepage.getFirstAddressTextFromCenterList(), childcarepage.getMapToolTipText());

	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		if (driver != null) {
			driver.quit();
		}
	}

}
