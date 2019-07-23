package Autom.LibrePlan;

import static org.junit.Assert.assertEquals;

import org.junit.After;
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
	page_participants.verifPageParticipants(driver);
	
	// ACTION Accès page Créer Participant
	page_participants.clickBtnCreer();
	
	// VERIFICATION page créer Participant
	page_participants.verifFormulaireCreation();

	// VERIFICATION conformité onglet données personnelles
	page_participants.verifOngletDonneesPersonnelles(driver);
		
	// ACTION creation d'un nouvel utilisateur
	page_participants.creationNouvelUtilisateur("Jean", "Du", "jdu", "jdu");
	
	// ACTION creation de plusieurs utilisateurs
//			page_participants.creationPlusieursUtilisateurs(driver);
			
	// ACTION navigation
	page_participants.navigation_next(driver);
	page_participants.navigation_prev();
	page_participants.navigation_last();
	page_participants.navigation_first();
	
	// ACTION suppression des utilisateurs
//	page_participants.supprimerTousRoles(driver);
//	page_participants.supprimerLigne();
	
	// ACTION connexion nouvel utilisateur
	page_participants.reconnexion(driver);
	}
}