package Autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageMenu {

	@FindBy(xpath = "//button[contains(.,'Calendrier')]")
	protected WebElement calendrier;

	@FindBy(xpath = "//button[contains(.,'Ressources')]")
	protected WebElement ressources;
	@FindBy(xpath = "//button[contains(.,'Coût')]")
	protected WebElement cout;
	@FindBy(xpath = "//button[contains(.,'Configuration')]")
	protected WebElement configuration;
	@FindBy(xpath = "//button[contains(.,'Communication')]")
	protected WebElement communication;
	@FindBy(xpath = "//button[contains(.,'Rapports')]")
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
