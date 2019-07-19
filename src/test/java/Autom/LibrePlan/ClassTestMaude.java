package Autom.LibrePlan;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ClassTestMaude extends TestAbstract{
	String nav = "chrome";
	String url = "http://localhost:8090/libreplan/";
	WebDriver driver;
	
	@Test
	public void Gre01(){
	// ACTION Connexion
	PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
	// ACTION Direction vers page Participants
	page_index.clickSurRessourcesPuisParticipants(driver);
	}
}
