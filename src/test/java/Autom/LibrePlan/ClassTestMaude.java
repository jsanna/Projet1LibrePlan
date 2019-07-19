package Autom.LibrePlan;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ClassTestMaude extends TestAbstract{
	
	@Test
	public void Gre01() throws InterruptedException{
	// ACTION Connexion
	PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
	
	// VERIFICATION onglet calendrier présent
	assertEquals("Calendrier ", driver.findElement(By.xpath("//td/div/button[substring(@id,5)='7-b']")).getText());
	
	// ACTION Direction vers page Participants	
	page_index.clickMenu(driver, "Ressources", "Participants");	
	PageParticipants page_participants = PageFactory.initElements(driver, PageParticipants.class);
	
	// VERIFICATION page Participants
	page_participants.verifPageParticipantsPas2(driver);
	
	// ACTION Accès page Créer Participant
	page_participants.clickBtnCreer();
	
	// VERIFICATION page créer Participant
	page_participants.verifPageCreerParticipant();

	// VERIFICATION conformité onglet données personnelles
//	page_participants.verifOngletDonneesPersonnelles();
		
	// ACTION creation d'un nouvel utilisateur
	page_participants.creationNouvelUtilisateur();
	}
}