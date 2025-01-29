package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	private By searchIcon = By.xpath("//*[@href='#subnav-search-desktop-top']");
	private By searchBox = By.xpath("//nav[@id='subnav-search-desktop-top']//input[@id='search-field']");
	private By searchButton = By.xpath("//nav[@id='subnav-search-desktop-top']//button[@type='submit']");
	private By acceptCookies = By.xpath("//*[@id='onetrust-accept-btn-handler']");
    private By findaCenter =By.xpath("//nav[@class='nav-shared txt-nav-hierarchy nav-top js-nav-shared js-nav-top']//li[@class='nav-item displayed-desktop']//a");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void acceptCookies() {
		driver.findElement(acceptCookies).click();
	}

	public void clickSearchIcon() {
		driver.findElement(searchIcon).click();
	}

	public void searchForItem(String itemName) {
		driver.findElement(searchBox).sendKeys(itemName);
		driver.findElement(searchButton).click();
		
	}
	
	public void clickCenterButton() {
		driver.findElement(findaCenter).click();
	}

}
