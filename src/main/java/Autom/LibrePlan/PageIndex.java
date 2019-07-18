package Autom.LibrePlan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageIndex {

	@FindBy (xpath = "//input[@name = 'j_username']")
	WebElement utilisateur;
	
	@FindBy (xpath = "//input[@name = 'j_password']")
	WebElement mot_de_pass;
	
	public static PageMenu login(WebDriver driver)
	
	{
		return PageFactory.initElements(driver, PageMenu.class)
	}
	
}
