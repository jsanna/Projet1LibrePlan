package Autom.LibrePlan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageIndex {
	
	
	@FindBy (xpath = "//img[@src='/libreplan/common/img/ico_print.png']")
	protected WebElement impression;
	
	@FindBy (xpath = "//img[@src='/libreplan/common/img/ico_add.png']")
	protected WebElement creer_nouveau_projet;

}
