package Autom.LibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ClassMaude extends PageMenu {
	
	public PageParticipants ressources_participants(WebDriver driver) {
		clickSurRessourcesPuisParticipants(driver);
		  return PageFactory.initElements(driver, PageParticipants.class);
	}
}
