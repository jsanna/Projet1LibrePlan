package Autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public abstract class PageMenu {

	@FindBy(xpath = "//td/div/button[substring(@id,5)='7-b']")
	protected WebElement calendrier;

	@FindBy(xpath = "//td/div/button[substring(@id,5)='r-b']")
	protected WebElement ressources;
	@FindBy(xpath = "//td/div/button[substring(@id,6)='0-b']")
	protected WebElement cout;
	@FindBy(xpath = "//td/div/button[substring(@id,5)='81-b']")
	protected WebElement configuration;
	@FindBy(xpath = "//td/div/button[substring(@id,5)='m1-b']")
	protected WebElement communication;
	@FindBy(xpath = "//td/div/button[substring(@id,4)='P22-b']")
	protected WebElement rapports;
	
	@FindBy(xpath = "//a[contains(@href,'worker/worker')]")
	protected WebElement participants;

	
	public void clickSurCalendrierPuisVotreBouton (WebDriver driver)
	{

		Actions a = new Actions(driver);
		a.moveToElement(calendrier).build().perform();
		a.moveToElement(calendrier)
				.moveToElement(driver.findElement(By.xpath("VOTRE_X_PATH"))).click()
				.build().perform();
	}
	
	public void clickSurRessourcesPuisParticipants (WebDriver driver)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ressources).build().perform();
		a.moveToElement(ressources)
				.moveToElement(participants).click()
				.build().perform();
	}
	
	
	
}
