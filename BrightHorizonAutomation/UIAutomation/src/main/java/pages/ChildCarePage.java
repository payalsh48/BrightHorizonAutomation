package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChildCarePage {

	private WebDriver driver;

	private By inputAdress = By.xpath("//*[@id='addressInput']");
	private By selectElementfromdropdown = By.xpath("//*[@class='pac-target-input focus-visible']");
	private By resultinputAdress = By.xpath("//span[@class='resultsNumber']");
	private By firstAdressfromList = By.xpath("//div[@id='center-results-container']/div[1]/div[1]/h3");
	private By listofCountAdress = By.xpath("//div[@class='heading-section']//h3");
	private By listofAddressTitle = By.xpath("//h3[@class='centerResult__name']");
	private By mapTooltipHeader = By.xpath("//span[@class='mapTooltip__headline']");
	
	// private By firstListOfList =By.xpath(" ");

	public ChildCarePage(WebDriver driver) {
		this.driver = driver;
	}

	
	
	public void inputAddressField(String input) {
		WebElement element = driver.findElement(inputAdress);
		element.sendKeys(input);
		
	}

	public void inputAddressFieldKeyEnter() {
		driver.findElement(inputAdress).click();
		driver.findElement(inputAdress).sendKeys(" ");
	}

	public String resultInputAdressField() {
		return driver.findElement(resultinputAdress).getText();

	}

	public int countNumberofCentersList() {
		List<WebElement> list = driver.findElements(listofCountAdress);

		int count = list.size();
		return count;

	}

	public void getfirstAdressfromCentersList() {

		List<WebElement> list = driver.findElements(listofCountAdress);
		list.getFirst().click();

	}

	public String getFirstAddressTextFromCenterList() {
		List<WebElement> list = driver.findElements(listofCountAdress);
		return list.getFirst().getText();

	}

	public void selctFisrtAdressfromList() {
		driver.findElement(firstAdressfromList).click();
	}

	public String getMapToolTipText() {
		return driver.findElement(mapTooltipHeader).getText();
	}
	
	public void selectfirstelment()
	{
		driver.findElement(selectElementfromdropdown).click();
		
	}

}
