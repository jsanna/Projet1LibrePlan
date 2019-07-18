package Autom.LibrePlan;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ClassMaude extends PageMenu{
	String nav = "chrome";
	String url = "http://localhost:8090/libreplan/";
	WebDriver driver;
	
	@Before
	public void setUp() {
		Outil.choisirUnNavigateur(nav);
		driver.get(url);
	}
	
	// ACTION Aller à la page des participants
	public PageParticipants ressources_participants() {
		ressources.click();
		  return PageFactory.initElements(driver, PageParticipants.class);

	}
}
