package Autom.LibrePlan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageMenu {
	
	@FindBy (xpath = "//button[contains(.,'Calendrier')]")
	protected WebElement calendrier;
	
	@FindBy (xpath = "//button[contains(.,'Ressources')]")
	protected WebElement ressources;
	@FindBy (xpath = "//button[contains(.,'Coût')]")
	protected WebElement cout;
	@FindBy (xpath = "//button[contains(.,'Configuration')]")
	protected WebElement configuration;
	@FindBy (xpath = "//button[contains(.,'Communication')]")
	protected WebElement communication;
	@FindBy (xpath = "")
	protected WebElement creer_nouveau_projet;
	@FindBy (xpath = "")
	protected WebElement rapport;
	@FindBy (xpath = "")
	protected WebElement impression;
	
	
}
