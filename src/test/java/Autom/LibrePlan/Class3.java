package Autom.LibrePlan;

import org.junit.Before;
import org.openqa.selenium.support.PageFactory;

public class Class3 {
	String nav = "chrome";
	
	@Before
	public void setUp() {
		Outil.choisirUnNavigateur(nav);
	}
	
	// ACTION Aller à la page des participants
	public PageParticipants ressources_particpants() {
		  return PageFactory.initElements(driver, PageParticipants.class);

	}
}
