package com.ui.automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultsPage;

public class SearchPageTestCase {

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
	public void verifyFirstSearchedResult() {
		driver.get("https://www.brighthorizons.com/");
		
		HomePage homePage = new HomePage(driver);
		homePage.acceptCookies();
		homePage.clickSearchIcon();
		homePage.searchForItem("Employee Education in 2018: Strategies to Watch");
		
		SearchResultsPage serchresult = new  SearchResultsPage(driver);
		
		Assert.assertEquals("Employee Education in 2018: Strategies to Watch", serchresult.getFirstSearchResultText());
	}
	
	@AfterClass
	public void tearDown() {
		// Close the browser
		if (driver != null) {
			driver.quit();
		}
	}

}
