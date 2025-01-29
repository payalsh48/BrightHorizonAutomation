package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
	private WebDriver driver;

	private By firstSearchResult = By.xpath("//*[@class='results container']/a[1]/div/h3");

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstSearchResultText() {
		return driver.findElement(firstSearchResult).getText();
	}


}
