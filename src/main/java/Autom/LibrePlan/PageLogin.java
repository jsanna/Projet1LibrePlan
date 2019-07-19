package Autom.LibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {

	@FindBy (xpath = "//input[@name = 'j_username']")
	private static WebElement utilisateur;
	
	@FindBy (xpath = "//input[@name = 'j_password']")
	private static WebElement mot_de_pass;
	
	@FindBy (xpath = "//input[@name = 'button']")
	private static WebElement submit;
	
	public PageMenu login(WebDriver driver)
	
	{
		Outil.renseignerChamp(utilisateur, "admin");
		Outil.renseignerChamp(mot_de_pass, "admin");
		submit.click();
		
		return PageFactory.initElements(driver, PageMenu.class);
	}
	
}
