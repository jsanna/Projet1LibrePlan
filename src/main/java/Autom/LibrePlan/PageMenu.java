package Autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class PageMenu {

	@FindBy(xpath = "//td/div/button[substring(@id,5)='7-b']")
	protected WebElement calendrier;

	@FindBy(xpath = "//td/div/button[substring(@id,5)='r-b']")
	protected WebElement ressources;
	@FindBy(xpath = "//td/div/button[substring(@id,5)='p0-b']")
	protected WebElement cout;
	@FindBy(xpath = "//td/div/button[substring(@id,5)='81-b']")
	protected WebElement configuration;
	@FindBy(xpath = "//td/div/button[substring(@id,5)='m1-b']")
	protected WebElement communication;
	@FindBy(xpath = "//td/div/button[substring(@id,5)='22-b']")
	protected WebElement rapports;
	
	@FindBy(xpath = "//div/a[substring(@id,4)='Qt-a']")
	protected WebElement participants;
	
	@FindBy(xpath = "//tbody/descendant::*[@class='message_INFO']")
	WebElement message;

	
	public void clickSurCalendrierPuisVotreBouton (WebDriver driver)
	{

		Actions a = new Actions(driver);
		a.moveToElement(calendrier).build().perform();
	 a.moveToElement(calendrier)
				.moveToElement(driver.findElement(By.xpath("VOTRE_X_PATH"))).click()
				.build().perform();
	}
	
	public void clickMenu(WebDriver driver, String title, String subtitle) {
		WebElement section = driver.findElement(By.xpath("//*[contains(@class,'mainmenu')]/descendant::button[contains(.,'"+ title.trim()+"')]/.."));
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions actions = new Actions(driver);
		actions.moveToElement(section);
		actions.build().perform();
		
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(wait.until(ExpectedConditions.visibilityOf(section.findElement(By.xpath("//div[contains(@class, 'submenu')]/ul/li/descendant::a[contains(., '"+subtitle+"')]")))));
		actions2.click();
		actions2.build().perform();
	}
	public void clickSurRessourcesPuisTypes (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions a = new Actions(driver);
		a.moveToElement(ressources).build().perform();
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href=\"/libreplan/advance/advanceTypes.zul\"]")))));
		actions2.click();
		actions2.build().perform();
	}
	
}
